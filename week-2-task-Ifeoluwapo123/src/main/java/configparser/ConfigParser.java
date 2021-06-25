package configparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ConfigParser {

    private String path;
    private String absolutePath = "week-2-task-Ifeoluwapo123/src/main/resources/config-file/";
    private String defaultFile = "config.txt.dev";
    Map<String, String> fileData = new HashMap<String, String>();

    public ConfigParser(String fileName){
        this.path = absolutePath+fileName;
    }

    public ConfigParser(){
        this.path = absolutePath+defaultFile;
    }

    /**
     *  This method reads from a file and generate the number of lines and its content
     *  then splits each text per line into 2(key and value), then push into HashMap.
     *  @returns void
     * */
    private void parseFile() throws IOException {
        try (
                Stream<String> fileStream = Files.lines(Paths.get(path));
//                FileReader fileReader = new FileReader(path);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
                BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path));
        ) {
            int noOfLines = (int) fileStream.count();
            for(int i = 0; i < noOfLines; i++){
                String eachLine = bufferedReader.readLine();

                if(!eachLine.isEmpty()){
                    if(eachLine.indexOf("=") != -1){
                        int count = 0;
                        String key = eachLine.substring(0, eachLine.indexOf("=")).trim();
                        String value = eachLine.substring(eachLine.indexOf("=")+1).trim();

                        for(Map.Entry<String, String> item: fileData.entrySet()){
                            if(key.equals("name")) key = "application.name";
                            if(key.equals("port")) key = "application.port";
                            if(key.equals("context-url")) key = "application.context-url";
                            if(item.getKey().equals(key)){
                                count++;
                            }
                        }
                        if(count == 0){
                            if(key.equals("name")) key = "application.name";
                            if(key.equals("port")) key = "application.port";
                            if(key.equals("context-url")) key = "application.context-url";
                            fileData.put(key, value);
                        }
                    }
                }
            }
        }catch (IOException error){
            System.out.println(error.getMessage());
        }
    }

    /**
     * This method returns a value from the map list based on the key(property) supplied
     * if key wasn't found, it returns an invalid key entered.
     * @param property
     * @return string
     * */
    public String get(String property) throws IOException {
        String value = "";
        this.parseFile();

        if(property.equals("name")) return fileData.get("application.name");
        if(property.equals("context-url")) return fileData.get("application.context-url");
        if(property.equals("port")) return fileData.get("application.port");

        for(Map.Entry<String, String> item: fileData.entrySet()){
            if(item.getKey().equals(property)){
                value += item.getValue();
            }
        }

        if(value.length() > 0) return value;
        return "Invalid Entry, Check property";
    }

}
