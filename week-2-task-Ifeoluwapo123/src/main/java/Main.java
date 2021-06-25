import configparser.ConfigParser;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        /**
         *  testing application without passing filename to the constructor
         *  default file used is config.txt.dev
         * */
        ConfigParser test = new ConfigParser();
        System.out.println(test.get("application.name"));
        System.out.println(test.get("dbname"));

        /**
         *  A Scanner object created to be able to enter properties and get there values
         * */
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to test with command line: Y or N");
        String answer = scan.next();

        /**
         *  testing application base on production, development or staging
         * */
        if(args.length == 0 || args[0].equalsIgnoreCase("production")){

            ConfigParser config = new ConfigParser("config.txt");
            if(answer.equalsIgnoreCase("y")) useScannerInput(config, answer);
            else displayValues(config);

        }else if(args[0].equalsIgnoreCase("development")){

            ConfigParser config = new ConfigParser("config.txt.dev");
            if(answer.equalsIgnoreCase("y")) useScannerInput(config, answer);
            else displayValues(config);

        }else if(args[0].equalsIgnoreCase("staging")){

            ConfigParser config = new ConfigParser("config.txt.staging");
            if(answer.equalsIgnoreCase("y")) useScannerInput(config, answer);
            else displayValues(config);

        }else{
            System.out.println("Invalid argument entered");
        }

    }

    public static void displayValues(ConfigParser config) throws IOException {
        System.out.println(config.get("dbname"));
        System.out.println(config.get("theme"));
        System.out.println(config.get("pipeline"));
        System.out.println(config.get("application.name"));
        System.out.println(config.get("application.port"));
        System.out.println(config.get("application.context-url"));
        System.out.println(config.get("mode")+"\n");
    }

    public static void useScannerInput(ConfigParser config, String opt) throws IOException {
        Scanner scan = new Scanner(System.in);

        while(!opt.equalsIgnoreCase("N")){
            System.out.println("Enter property: or N to (terminate)=> ");
            opt = scan.nextLine();
            if(opt.equalsIgnoreCase("N")) break;
            System.out.println(config.get(opt));
        }
    }
}
