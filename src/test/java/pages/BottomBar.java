package pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class BottomBar extends BasePage {
    private final By homeButton = AppiumBy.accessibilityId("Home");
    private final By webViewButton = AppiumBy.accessibilityId("Webview");
    private final By loginButton = AppiumBy.accessibilityId("Login");
    private final By formsButton = AppiumBy.accessibilityId("Forms");
    private final By swipeButton = AppiumBy.accessibilityId("Swipe");
    private final By dragButton = AppiumBy.accessibilityId("Drag");

    @Override
    @Step("Waiting for bottom bar to load")
    public void waitPageToLoad() {
        waitPage(homeButton, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verify bottom bar elements")
    public void verifyPage() {
        Logs.info("Verify bottom bar elements");
        softAssert.assertTrue(find(homeButton).isDisplayed());
        softAssert.assertTrue(find(webViewButton).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertTrue(find(formsButton).isDisplayed());
        softAssert.assertTrue(find(swipeButton).isDisplayed());
        softAssert.assertTrue(find(dragButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Navigate to home screen")
    public void goToHomeScreen() {
        Logs.info("Navigate to home screen");
        find(homeButton).click();
    }

    @Step("Navigate to web view screen")
    public void goToWebViewScreen() {
        Logs.info("Navigate to web view screen");
        find(webViewButton).click();
    }

    @Step("Navigate to login screen")
    public void goToLoginScreen() {
        Logs.info("Navigate to login screen");
        find(loginButton).click();
    }

    @Step("Navigate to forms screen")
    public void goToFormsScreen() {
        Logs.info("Navigate to forms screen");
        find(formsButton).click();
    }

    @Step("Navigate to swipe screen")
    public void goToSwipeScreen() {
        Logs.info("Navigate to swipe screen");
        find(swipeButton).click();
    }

    @Step("Navigate to drag screen")
    public void goToDragScreen() {
        Logs.info("Navigate to drag screen");
        find(dragButton).click();
    }
}
