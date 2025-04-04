package digital.fms.pageObject.WebPages.admin;

import digital.fms.pageObject.BasePageObject;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePageObject {

    public static final String fmsLogo = "//img[@src='/assets/samadhanImage-B86-metx.svg']";
    public static final String loginSectionTitle = "//div[@data-name='Unified']//h1";
    public static final String loginSectionSubtitle = "//form[@id='localAccountForm']//div[@class='intro']//h2";
    public static final String joinButton = "//button[@data-testid='redirect_to-authentication-button']";
    public static final String leftSideImageTitle = "(//div[@class='image-side']//p)[1]";
    public static final String leftSideImageSubtitle = "(//div[@class='image-side']//p)[2]";
    public static final String emailInputLabel = "(//label)[1]";
    public static final String emailInput = "//input[@id='email']";
    public static final String passwordInputLabel = "(//label)[2]";
    public static final String passwordInput = "//input[@id='password']";
    public static final String forgotPasswordButton = "(//a)[1]";
    public static final String newAccountText = "(//button[@id='next']//following::div)[2]//p";
    public static final String createAccountButton = "(//button[@id='next']//following::div)[1]//following::a";
    public static final String loginTitle = "//div[@id='api']//h1";
    public static final String loginSubTitle = "(//h2)[1]";
    public static final String sigInButton = "//button[@id='next']";
    public static final String lblPasswordError = "(//*[@id='email']//parent::div//following::p)[2]";
    private static final String lblEmailError = "(//*[@id='email']//parent::div//following::p)[1]";

    public static void verifyEmailValidationDisplayed() {
        $x(lblEmailError).should(exist).shouldBe(visible);
    }

    public static void verifyEmailValidationText(String text) {
        $x(lblEmailError).shouldHave(text(text));
    }

    public static boolean isEmailValidationDisplayed() {
        return $x(lblEmailError).isDisplayed();
    }

    public static void verifyPasswordValidationDisplayed() {
        $x(lblPasswordError).should(exist).shouldBe(visible);
    }

    public static void verifyPasswordValidationText(String text) {
        $x(lblPasswordError).shouldHave(text(text));
    }
}