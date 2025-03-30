package pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class HomePage extends BasePage {
    private final By robotImage = AppiumBy.androidUIAutomator("description(\"Home-screen\").childSelector(className(android.widget.ImageView).instance(0))");
    private final By appTitleLabel = AppiumBy.androidUIAutomator("text(\"WEBDRIVER\")");
    private final By appDescriptionLabel = AppiumBy.androidUIAutomator("text(\"Demo app for the appium-boilerplate\")");
    private final By supportLabel = AppiumBy.androidUIAutomator("text(\"Support\")");

    @Override
    @Step("Waiting for home page to load")
    public void waitPageToLoad() {
        waitPage(robotImage, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verify home page elements")
    public void verifyPage() {
        Logs.info("Verify home page elements");
        softAssert.assertTrue(find(robotImage).isDisplayed());
        softAssert.assertTrue(find(appTitleLabel).isDisplayed());
        softAssert.assertTrue(find(appDescriptionLabel).isDisplayed());
        softAssert.assertTrue(find(supportLabel).isDisplayed());
        softAssert.assertAll();
    }
}
