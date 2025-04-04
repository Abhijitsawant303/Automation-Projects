package digital.fms.utils.readers;

import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
public class DBConfig {

    private final String propertyFilePath = "src/main/resources/db.properties";
    private String dbHostname;
    private String dbUsername;
    private String dbPassword;
    private String dbName;

    Properties properties = new Properties();

    public DBConfig(){
        try {
            FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
            properties.load(fileInputStream);

            this.dbHostname = properties.getProperty("db.hostname");
            this.dbUsername = properties.getProperty("db.username");
            this.dbPassword = properties.getProperty("db.password");
            this.dbName = properties.getProperty("db.name");

            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propName) {
        try {
            InputStream input = new FileInputStream(propertyFilePath);
            properties.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return properties.getProperty(propName);
    }

    /**
     * @param fileName : File name to located in Config folder
     * @param propName : Property name to retrieve value from fileName
     * @return String : Value of property in config.properties
     */
    public String getProperty(String fileName, String propName) {
        try {
            InputStream input = new FileInputStream(
                    System.getProperty("user.dir") + File.separator + "Config" + File.separator + fileName);
            properties.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return properties.getProperty(propName);
    }
}

