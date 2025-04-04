package digital.fms.utils.readers;


import lombok.Data;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
public class Config {

    private final String propertyFilePath = "src/main/resources/environment.properties";
    private String baseURLGeneralUser;
    private String baseURLGeneralAdmin;
    private String browserName;
    private String browserSize;
    private String retriesCount;
    private String selenoidURL;
    private boolean remote;
    private int iterationLimit;
    private String downloadPath;
    private int timeout;
    private String apiURL;
    Properties properties = new Properties();

    public Config() {
        try {
            FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
            properties.load(fileInputStream);

            this.baseURLGeneralUser = properties.getProperty("url.e2e.generalUser");
            this.baseURLGeneralAdmin = properties.getProperty("url.e2e.generalAdmin");
            this.browserName = properties.getProperty("browser.name");
            this.browserSize = properties.getProperty("browser.size");
            this.apiURL = properties.getProperty("api.url");
            this.retriesCount = properties.getProperty("retries.count");
            this.iterationLimit = Integer.parseInt(properties.getProperty("iteration.limit"));
            this.downloadPath = properties.getProperty("download.folder");
            this.timeout = Integer.parseInt(properties.getProperty("browser.timeout"));

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
                    System.getProperty("user.dir") + File.separator + "resources" + File.separator + fileName);
            properties.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return properties.getProperty(propName);
    }
}
