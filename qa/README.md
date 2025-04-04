# QA Automation intro

## Tech Stack:

* [Maven](https://maven.apache.org/) - build automation tool
* [TestNG](https://testng.org/doc/) - unit testing framework
* [Selenide](https://selenide.org/) - library that wraps Selenium. The main differences are described [here](https://github.com/selenide/selenide/wiki/Selenide-vs-Selenium).
* [Rest-assured](https://rest-assured.io/) - library that is used to test RESTful Web Services
* [Lombock](https://projectlombok.org/) - library that allows your class has a fully featured builder with one annotation
* [Allure](https://docs.qameta.io/allure-report/) - test report tool

---

# Project structure

The project consists of two parts: for **API** and for **E2E** testing

### src/main/
- `/api` api calls implementation consisting of query-enums and response-pojo;
- `/pageObject` pageObject implementation consisting of pages, pageElements, modals and enums;
- `/utils` contain readers, listeners, logger implementation etc.;
- `/resources` contain project configuration files and different testData;


### src/test/
- `BaseTest.java` - Global base class. Contains @Before and @After methods reliable for both api and e2e testing. Extended by `BaseAPITest.java` and `BaseE2ETest.java`;
- `BaseApiTest.java` - API testing base class. Contains @Before and @After methods reliable only to API tests. Should be extended by appropriate api-test classes;
- `BaseE2ETest.java` - E2E testing base class. Contains @Before and @After methods reliable only to E2E tests. Responsible for driver creation. Should be extended by appropriate e2e-test classes;

- `/api` contain classes with API-test scripts;
- `/e2e` contain classes with E2E-test scripts;

---

# Lifecycle sequence

1. Maven performs whatever is configured until the relevant test phase (either test or integration-test);
1. TestNG calls its `@Before` annotations;
1. Tests execution;
1. TestNG calls its `@After` annotations;
1. Maven performs whatever is configured after the test phase;

More about TestNG annotations sequence [here](https://howtodoinjava.com/testng/testng-before-and-after-annotations/);

Global TestNG annotations placed in `BaseTest`, `BaseApiTest` and `BaseE2ETest` classes; TestClass-related TestNG annotations placed directly in test-classes.

---

# Parallel execution

Parallelism is implemented by maven-surefire-plugin mechanism and can be reconfigured in `.pom.xml`.
As of now it configured to execute Test Classes in parallel, so each Test.class will be executed in separate thread where all it's test mehtods will be launched one by one.

The number of threads can be configured in `.pom.xml`. Max number of threads depends on the system parameters and the created load.

```xml
<configuration>
    <parallel>classes</parallel>
    <threadCount>3</threadCount>
</configuration>
```

---

# Report generation

### Simple generation
This is already enough to see the Allure report in one command:

`allure serve target/allure-results` - generates a report in temporary folder from the data found in the provided path and then creates a local Jetty server instance, serves generated report and opens it in the default browser;

There is few additional helpful commands available:
### Generate the report
But if you need to generete it, and save some where, you can use:
`allure generate target/allure-results -o target/allure-report —clean` - generates a report

### Open the report
When the report is generated you can open it in your default system browser. Simply run
`allure open target/allure-report` - opens last report

More [info about allure reports](https://docs.qameta.io/allure/) and it's configuration.

---

# Framework convention

* Follow Java code convention;
* Save the abstraction level;
* Element locators should be always implemented as Strings;
* Assertions should be on test level;
* Try to avoid names clipping, it makes code less readable;

---



# How to start with this project
* Add new repository for your New project
* Clone New project and checktout
* Clone Basic project
* Copy files from Basic project  to New project directory
* Update  configuration depending on your needs  
  - `/pom.xml`:

    ```xml
    <systemPropertyVariables>
      <base.url>https://your.base.url.here/</base.url>
      <api.url>https://your.base.Api.url.here/graphql</api.url>
    </systemPropertyVariables>
    ```
  - `src/main/resources/db.properties` :
    ```properties
    db.hostname= db-host.com
    db.username= db-userame
    db.password= db-password
    db.name= db-name
    ```
* Push your branch to new repository 
  * 
    `git add`
  * 
    `git commit -m "message"`
  * 
    `git push`

---

# How to add new tests
### UI test
Framework implement standard page Object Pattern:
- First of all, you need to locate elements on application page with xpath. Xpath should be added to YourPage.class  
- Second, on YourPage.class you need to create methods that operate with Locators. (click, get, is, etc)
- Third, you use corresponding page and methods, for navigation and assertions, directly in a test.

More details can be found in [this](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/
) complete Page object guide by Selenium documentation.

Tips:
- In case your page navigation methods returns page class - using methods chaining, you can follow business logic of application. 
This kind of implementation is very easy to read and maintain.

```
YourPage yourPage = open()
.login(User.ADMIN_1)
.getNavigationBar()
.clickNavigationBarLeaveRequestsButton()
.clickAddLeaveRequestsButton()

Assert.assertTrue(yourPage.isModalOpen());
```
- In case you have very lightweight application that don't contain a tonn of business logic - it make sense to not implement 
to add only locators to YourPage.class, and use them directly in a test according to [selenide guide](https://selenide.org/quick-start.html).
In this way tests will be less readable, tests will be harder to maintain, there will be more code directly in a test and you can forget about 'saved business logic',
but you will create tests faster, because you don't add methods to operate each locator. 
```
YourPage yourPage = open()
  .login(User.ADMIN_1);

  $(yourPage.NAVIGATION_BAR).click();
  $(yourPage.LEAVE_REQUEST_BUTTON).shouldBe(visible).click();
  $(yourPage.ADD_LEAVE_REQUEST_BUTTON).shouldBe(visible).click();
  
  LeaveRequestPage leaveRequestPage = page(LeaveRequestPage.class);

  $(leaveRequestPage.ADD_REQUEST_MODAL).shouldBe(visible);
  $(leaveRequestPage.ADD_REQUEST_MODAL_TITLE).shouldHave(text("Add request"));
```

### API test

- First you need to create Query. It's better to add it as string to enum. You can find example at:
```		
src/main/java/digital/windmill/api/enums/AssetQueries.java
```
- Second, add POJO representation of objects you can fetch from your service, and what fields it has. You can find example at:
```		
src/main/java/digital/windmill/api/pojo/assets/Asset.java
```
- Third, send your request:
```
QueryResponse response = sendRequest(AssetTypeQueries.ASSET_TYPES, queryVariables);
```
- Finally, verify fetched data:
```
Assert.assertTrue(response.getData().getAsset().getTitle(), "Title")
```

### DB test
Tests for DB are very similar to API testing, except you using dbUtils tool.
- First you need to create Query.
```		
PreparedStatement preparedStatement = dbUtils.connect().prepareStatement(
        		+ "SELECT "
        		+ "FROM "
        		+ "WHERE ");
```
- Second, send your request:
```
ResultSet dbData = dbUtils.fetchData(preparedStatement);
```
- Finally, verify fetched data:
```
BigDecimal quantity = new BigDecimal(0);
while(dbData.next()) {
            Assert.assertTrue(dbData.getString("title"))
        }
```

# Test launch
Basically, you can launch tests with command `mvn clean test`

### Local/remote execution
Tests can be launched locally(by default) or remotly.
For remote launch add:
`-Dselenide.remote=https://your.remote.selenoid.server/wd/hub`

### Single test
`-Dtest=HeaderTest#headerElements`

### Single class launch
`-Dtest=ClassName`

### Groups launch
`-DtestGroup=e2e/api`
Groups can be configured in pom

# Test launch with CI
When you running tests with CI you may need to change your basic url, api url or even threads count to fit VM params. 
For this case commands can be used:

`-Dbase.url=https://your.base.url.here/`

`-Dapi.url=https://your.base.Api.url.here/graphql`

`-DthreadCount=10`

---
# Remote setup
To launch your tests remotly you need to have
- Virtual Machine(VM)
- Selenoid server installed on VM
- Selenoid-UI - optionally, if you need to view your testruns.
- Configured Jenkins job.

The complete guide to setup your VM and all necessary requirements can be found on [Selenoid documentation](https://aerokube.com/selenoid/latest/)
Just reade attentively.

---
# Jenkins configuration
- Create a pipeline, and set Jenkins job to run it. Pipeline example:
```
// Variables for code_repos
def CLASS_TO_RUN    = "${CLASS}"
def git_branch      = "${git_branch}"
def gitUrlCode      = "git clone your Repo Here"

node("**YOUR NODE HERE**") {
        try {    

      withCredentials([
                **YOYR CREDENTIALS HERE**
                ]){
    stage ('Checkout the code repo'){
                checkout([$class: 'GitSCM', branches: [[name: "${git_branch}"]], extensions: [], userRemoteConfigs: [[url: "${gitUrlCode}"]]])
    }  
    

    stage('Build_war') {
            ansiColor('xterm')
            {
              sh 'cd qa && mvn clean test -Dtest=${CLASS} -Dselenide.remote=selenoidServerUrlHere -Dbase.url=${BaseUrl} -Dapi.url=${APIUrl} -DthreadCount=${ThreadsCount}'
            }
    }

    }
}
    catch (e) {
      // If there was an exception thrown, the build failed
      currentBuild.result = "FAILED"
      throw e
    } finally {
      allure([
              includeProperties: false,
              jdk: '',
              properties: [],
              reportBuildPolicy: 'ALWAYS',
              results: [[path: '**/target/allure-results']]
      ])
    }
      
  }
  

```
- Add to Jenkins job launching parameters you need :
`BaseUrl`, `APIUrl`, `ThreadsCount`, `git_branch`, `CLASS` etc.

