package digital.fms.tests;

//import digital.windmill.utils.DBUtils;
import digital.fms.utils.readers.Config;
import digital.fms.utils.readers.DBConfig;
import digital.fms.utils.readers.TestData;
import digital.fms.utils.listeners.TestListener;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;

@Listeners(TestListener.class)
public class BaseTest {
    public Config config = new Config();
    public DBConfig dbConfig = new DBConfig();
    public TestData testData = new TestData();
//    public DBUtils dbUtils = new DBUtils();
    public static RequestSpecification req;
//    public GraphQLQuery queryData = new GraphQLQuery();
    public RequestSpecification res;
//    public QueryVariables queryVariables = new QueryVariables();
    public Response response;

    @AfterSuite
    public void addEnvPropsToReport() {
        File source = new File("src/main/resources/environment.properties");
        File dest = new File("target/allure-results/");

        try {
            FileUtils.copyFileToDirectory(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
