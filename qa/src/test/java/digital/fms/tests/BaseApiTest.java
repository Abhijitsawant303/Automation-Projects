//package digital.windmill.tests;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import digital.windmill.api.enums.IQueries;
//import digital.windmill.api.pojo.GraphQLQuery;
//import digital.windmill.api.pojo.QueryResponse;
//import digital.windmill.api.pojo.QueryVariables;
////import digital.windmill.utils.DBUtils;
//import io.qameta.allure.Attachment;
//import io.qameta.allure.Step;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.RequestLoggingFilter;
//import io.restassured.filter.log.ResponseLoggingFilter;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.PrintStream;
//
//import static io.restassured.RestAssured.given;
//
//public class BaseApiTest extends BaseTest {
//
////    public DBUtils dbUtils = new DBUtils();
//
//    public RequestSpecification requestSpecification() throws IOException {
//
//        if (req == null) {
//            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
//            req = new RequestSpecBuilder().setBaseUri(config.getApiURL())
//                    .addFilter(RequestLoggingFilter.logRequestTo(log))
//                    .addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
//            return req;
//        }
//        return req;
//    }
//
//    public String getJsonPath(Response response, String key) {
//        String resp = response.asString();
//        JsonPath js = new JsonPath(resp);
//        return js.get(key).toString();
//    }
//
//    public String dataMapper(Object data) throws JsonProcessingException {
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        return ow.writeValueAsString(data);
//    }
//
//    public void setQuery(IQueries  query, QueryVariables queryVariable) throws IOException {
//        queryData.setQuery(query.getQuery());
//        queryData.setVariables(queryVariable);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        res = given().spec(requestSpecification()).body(ow.writeValueAsString(queryData));
//    }
//
//    public QueryResponse getRespose() throws JsonMappingException, JsonProcessingException {
//        response = res.when().post();
//        return new ObjectMapper().readValue(response.asPrettyString(), QueryResponse.class);
//    }
//
//    @Step
//    public QueryResponse sendRequest(IQueries query, QueryVariables queryVariable)  throws IOException {
//
//        queryData.setQuery(query.getQuery());
//        queryData.setVariables(queryVariable);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String queryToRequest = ow.writeValueAsString(queryData);
//        RequestSpecification requestSpecification = given().spec(requestSpecification()).body(queryToRequest);
//        Response rspns = requestSpecification.when().post();
//        attachQueryPayload(queryToRequest);
//        attachResponse(rspns.asPrettyString());
//        return new ObjectMapper().readValue(rspns.asPrettyString(), QueryResponse.class);
//    }
//
//    @Attachment(value = "Query Payload", type = "text/plain")
//    public String attachQueryPayload(String query) {
//        return query;
//    }
//
//    @Attachment(value = "Response", type = "text/plain")
//    public String attachResponse(String response) {
//        return response;
//    }
//}
