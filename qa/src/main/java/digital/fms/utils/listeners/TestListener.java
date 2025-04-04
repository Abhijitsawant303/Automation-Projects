package digital.fms.utils.listeners;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failure of test cases and its details are : "+result.getName());
        reportState();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skip of test cases and its details are : "+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Failure of test cases and its details are : "+result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    @Attachment(value = "URL at end of test", type = "text/plain")
    private String getCurrentURL() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return Selenide.screenshot(OutputType.BYTES);
    }

    private void reportState() {
        attachUrlToReport();
        attachScreenshotToReport();
    }

    private void attachUrlToReport() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            getCurrentURL();
        }
    }

    private void attachScreenshotToReport() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            saveScreenshotPNG();
        }
    }
}