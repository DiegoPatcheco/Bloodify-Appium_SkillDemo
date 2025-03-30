package pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.ContextManager;
import utilities.Gestures;
import utilities.Logs;

public class WebViewPage extends BasePage {
    private final By robotImage = By.xpath("//h1[@class='hero__title']");
    private final By subtitleLabel = By.className("hero__subtitle");
    private final By getStartedButton = AppiumBy.accessibilityId("Get Started");
    private final By whyWdIOButton = AppiumBy.accessibilityId("Why WebdriverIO?");
    private final By gitHubViewButton = AppiumBy.accessibilityId("View on GitHub");
    private final By youTubeWatchButton = AppiumBy.accessibilityId("Watch on YouTube");
    private final By canvas = AppiumBy.androidUIAutomator("className(\"android.webkit.WebView\").instance(0)");

    @Override
    @Step("Waiting for web view page to load")
    public void waitPageToLoad() {
        waitPage(AppiumBy.androidUIAutomator(
                        "text(\"WebdriverIO\")"),
                this.getClass().getSimpleName());
    }

    @Override
    @Step("Verify web view page elements")
    public void verifyPage() {
        Logs.info("Switch to web view context");
        ContextManager.switchWebViewContext();

        Logs.info("Verify web view page elements");
        softAssert.assertTrue(waitForDisplayed(robotImage).isDisplayed());
        softAssert.assertTrue(find(subtitleLabel).isDisplayed());
        softAssert.assertAll();

        Logs.info("Switch to native app context");
        ContextManager.switchNativeAppContext();

        Logs.info("Perform a swipe up");
        Gestures.verticalSwipe(50, 80, 30, find(canvas));

        Logs.info("Verify web view page elements");
        softAssert.assertTrue(waitForDisplayed(getStartedButton, 10).isDisplayed());
        softAssert.assertTrue(find(whyWdIOButton).isDisplayed());
        softAssert.assertTrue(find(gitHubViewButton).isDisplayed());
        softAssert.assertTrue(find(youTubeWatchButton).isDisplayed());
        softAssert.assertAll();
    }
}
