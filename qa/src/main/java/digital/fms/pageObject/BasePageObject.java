package digital.fms.pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import digital.fms.utils.Log;
import digital.fms.utils.readers.Config;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThanOrEqual;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePageObject {
    public Config config = new Config();

    public boolean isDisplayed(SelenideElement element) {
        try {
            element.should(exist).shouldBe(visible).isDisplayed();
            return true;
        } catch (ElementNotFound e) {
            return false;
        }
    }

    public boolean isNotDisplayed(SelenideElement element) {
        try {
            element.shouldNot(exist).shouldNotBe(visible).isDisplayed();
            return true;
        } catch (ElementNotFound e) {
            return false;
        }
    }

    public boolean isPresent(ElementsCollection elements) {
        try {
            elements.shouldHave(sizeGreaterThan(0));
            return true;
        } catch (ElementNotFound e) {
            return false;
        }
    }

    public boolean isNotPresent(ElementsCollection elements) {
        try {
            elements.shouldHave(sizeLessThanOrEqual(0));
            return true;
        } catch (ElementNotFound e) {
            return false;
        }

    }

    protected void clearModalInput(String locator) {
        Log.info("clearInput: " + locator);
        $x(locator).sendKeys(Keys.CONTROL, "a");
        $x(locator).sendKeys(Keys.DELETE);
    }
}
