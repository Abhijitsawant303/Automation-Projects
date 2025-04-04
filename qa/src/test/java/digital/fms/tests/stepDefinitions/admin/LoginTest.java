package digital.fms.tests.stepDefinitions.admin;

import digital.fms.pageObject.WebPages.admin.LoginPage;
import digital.fms.tests.BaseE2ETest;
import io.cucumber.java.en.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest extends BaseE2ETest {
    boolean emptyEmail = false, emptyPassword = false, invalidEmail = false;

    @Given("^Open browser for \"([^\"]*)\"$")
    public void open_browser_for_something(String applicationName) {
        if (applicationName.equalsIgnoreCase("FmsAdmin")) {
            open(config.getBaseURLGeneralUser());
            sleep(3000);
        } else if (applicationName.equalsIgnoreCase("Fms")) {
            open(config.getBaseURLGeneralAdmin());
            sleep(3000);
        }
    }

    @When("^User on login screen$")
    public void user_on_login_screen() {
        $x(LoginPage.fmsLogo).should(exist).shouldBe(visible);
    }
}