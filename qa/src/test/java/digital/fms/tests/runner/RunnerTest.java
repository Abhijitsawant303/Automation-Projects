package digital.fms.tests.runner;

import io.cucumber.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/digital/fms/tests/features/"},
		//tags="@e2e",
		glue={"digital.fms.tests.stepDefinitions", "digital.fms.tests.base"},
		monochrome = true,
		plugin= {"pretty", "html:target/cucumber/report.html",
				"json:target/JSONReports/report.json","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		}
)

public class RunnerTest {

}