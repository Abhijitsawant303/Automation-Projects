package digital.fms.utils.readers;

import lombok.Data;

import java.io.*;
import java.util.Properties;

@Data
public class TestData {

    private final String propertyFilePath = "src/main/resources/testData.properties";

    private String testDataDirectory;
    private String downloadFolder;
    private String testImageJpeg;
    private String testImagePng;
    private String testImageWebp;
    private String xlsFileName;

    private String dbHostname;
    private String dbName;
    private String dbUsername;
    private String dbPassword;
    
    Properties properties = new Properties();

    public TestData(){
        try {
            FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
            properties.load(fileInputStream);

            this.testDataDirectory = properties.getProperty("test.data.directory");
            this.downloadFolder = properties.getProperty("download.folder");
            this.testImageJpeg = properties.getProperty("image.jpeg");
            this.testImagePng = properties.getProperty("image.png");
            this.testImageWebp = properties.getProperty("image.webp");
            this.dbHostname = properties.getProperty("db.hostname");
            this.dbName = properties.getProperty("db.name");
            this.dbUsername = properties.getProperty("db.username");
            this.dbPassword = properties.getProperty("db.password");
            this.xlsFileName = properties.getProperty("xlsFileName");

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
