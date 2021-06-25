package configparser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ConfigParserTest {
    ConfigParser configParserTest, configParser, configParser2, configParser3;

    @BeforeEach
    public void setup(){
        configParser = new ConfigParser("config.txt");
        configParser2 = new ConfigParser("config.txt.dev");
        configParser3 = new ConfigParser("config.txt.staging");
        configParserTest = new ConfigParser();
    }

    @Test
    public void getDbName() throws IOException {
        //test for config.txt
        String value = configParser.get("dbname");
        assertEquals("sq04_db", value);
        assertNotEquals("", value);
        assertNotEquals("sq04_db-development", value);

        //test for config.txt.dev
        String value2 = configParser2.get("dbname");
        assertEquals("sq04_db-development", value2);
        assertNotEquals("", value2);
        assertNotEquals("sq04_db", value2);

        //test for config.txt.staging
        String value3 = configParser3.get("dbname");
        assertEquals("sq04_db", value3);
        assertNotEquals("", value3);
        assertNotEquals("sq04_db-development", value3);

        //testing default file
        String value4 = configParserTest.get("dbname");
        assertNotEquals("sq04_db", value4);
        assertEquals("sq04_db-development", value4);


    }

    @Test
    public void getHost() throws IOException {
        //test for config.txt
        String value = configParser.get("host");
        assertEquals("127.0.0.1", value);
        assertNotEquals("", value);

        //test for config.txt.dev
        String value2 = configParser2.get("host");
        assertEquals("127.0.0.1", value2);
        assertNotEquals("", value2);

        //test for config.txt.staging
        String value3 = configParser3.get("host");
        assertEquals("127.0.0.1", value3);
        assertNotEquals("", value3);

        //testing default file
        String value4 = configParserTest.get("host");
        assertEquals("127.0.0.1", value4);
        assertNotEquals("", value4);

    }

    @Test
    public void getName() throws IOException {
        //test for config.txt
        String value = configParser.get("name");
        //String value = configParser.get("application.name");
        assertEquals("fintek", value);
        assertNotEquals("fintrack", value);
        assertNotEquals("fintrack-development", value);
        assertNotEquals("fintrack-staging", value);
        assertNotEquals("fintek-development", value);
        assertNotEquals("fintek-staging", value);

        //test for config.txt
        String value2 = configParser2.get("name");
        assertEquals("fintek-development", value2);
        assertNotEquals("fintek", value2);
        assertNotEquals("fintrack", value2);
        assertNotEquals("fintrack-staging", value2);
        assertNotEquals("fintrack-development", value2);
        assertNotEquals("fintek-staging", value2);

        //test for config.txt
        String value3 = configParser3.get("name");
        assertEquals("fintek-staging", value3);
        assertNotEquals("fintek", value3);
        assertNotEquals("fintrack-development", value3);
        assertNotEquals("fintrack", value3);
        assertNotEquals("fintrack-staging", value3);
        assertNotEquals("fintek-development", value3);

        //testing default file
        String value4 = configParserTest.get("name");
        assertEquals("fintek-development", value4);
        assertNotEquals("fintek", value4);
        assertNotEquals("fintrack", value4);
        assertNotEquals("fintrack-staging", value4);
        assertNotEquals("fintrack-development", value4);
        assertNotEquals("fintek-staging", value4);
    }

    @Test
    public void getMode() throws IOException {
        //test for config.txt
        String value = configParser.get("mode");
        assertEquals("production", value);
        assertNotEquals("development", value);
        assertNotEquals("staging", value);

        //test for config.txt.dev
        String value2 = configParser2.get("mode");
        assertEquals("development", value2);
        assertNotEquals("production", value2);
        assertNotEquals("staging", value2);

        //test for config.txt.staging
        String value3 = configParser3.get("mode");
        assertEquals("staging", value3);
        assertNotEquals("development", value3);
        assertNotEquals("production", value3);

        //testing default file
        String value4 = configParserTest.get("mode");
        assertEquals("development", value4);
        assertNotEquals("production", value4);
        assertNotEquals("staging", value4);
    }

    @Test
    public void getPipeline() throws IOException {
        //test for config.txt
        String value = configParser.get("pipeline");
        assertEquals("fast", value);
        assertNotEquals("fast-development", value);
        assertNotEquals("fast-staging", value);

        //test for config.txt
        String value2 = configParser2.get("pipeline");
        assertEquals("fast-development", value2);
        assertNotEquals("fast", value2);
        assertNotEquals("fast-staging", value2);

        //test for config.txt
        String value3 = configParser3.get("pipeline");
        assertEquals("fast-staging", value3);
        assertNotEquals("fast-development", value3);
        assertNotEquals("fast", value3);

        //testing default file
        String value4 = configParserTest.get("pipeline");
        assertEquals("fast-development", value4);
        assertNotEquals("fast", value4);
        assertNotEquals("fast-staging", value4);
    }

    @Test
    public void getTheme() throws IOException {
        //test for config.txt
        String value = configParser.get("theme");
        assertEquals("green", value);
        assertNotEquals("yellow", value);
        assertNotEquals("blue", value);

        //test for config.txt.dev
        String value2 = configParser2.get("theme");
        assertEquals("yellow", value2);
        assertNotEquals("green", value2);
        assertNotEquals("blue", value2);

        //test for config.txt.staging
        String value3 = configParser3.get("theme");
        assertEquals("blue", value3);
        assertNotEquals("yellow", value3);
        assertNotEquals("green", value3);

        //testing default file
        String value4 = configParserTest.get("theme");
        assertEquals("yellow", value4);
        assertNotEquals("green", value4);
        assertNotEquals("blue", value4);

    }

    @Test
    public void getPort() throws IOException {
        //test for config.txt
        String value = configParser.get("port");
        assertEquals("8080", value);
        assertNotEquals("8081", value);
        assertNotEquals("8082", value);

        //test for config.txt.dev
        String value2 = configParser2.get("port");
        assertEquals("8082", value2);
        assertNotEquals("8081", value2);
        assertNotEquals("8080", value2);

        //test for config.txt.config
        String value3 = configParser3.get("port");
        assertEquals("8081", value3);
        assertNotEquals("8080", value3);
        assertNotEquals("8082", value3);

        //testing default file
        String value4 = configParserTest.get("port");
        assertEquals("8082", value4);
        assertNotEquals("8081", value4);
        assertNotEquals("8080", value4);

    }

}