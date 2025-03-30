package pages;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Gestures;
import utilities.Logs;

public class FormsPage extends BasePage {
    private final String randomText = new Faker().animal().name();
    private final By textInput = AppiumBy.accessibilityId("text-input");
    private final By inputResult = AppiumBy.accessibilityId("input-text-result");
    private final By formSwitch = AppiumBy.accessibilityId("switch");
    private final By switchText = AppiumBy.accessibilityId("switch-text");
    private final By formDropDown = AppiumBy.androidUIAutomator("resourceId(\"text_input\")");
    private final By dropDownOptions = AppiumBy.androidUIAutomator("className(\"android.widget.CheckedTextView\")");
    private final By activeButton = AppiumBy.accessibilityId("button-Active");
    private final By inActiveButton = AppiumBy.accessibilityId("button-Inactive");
    private final By activeModalTitle = AppiumBy.id("android:id/alertTitle");
    private final By activeModalSubtitle = AppiumBy.id("android:id/message");
    private final By activeModalOkButton = AppiumBy.id("android:id/button1");
    private final By activeModalCancelButton = AppiumBy.id("android:id/button2");

    @Override
    @Step("Waiting for forms page to load")
    public void waitPageToLoad() {
        waitPage(textInput, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verify forms page elements")
    public void verifyPage() {
        Logs.info("Verify forms page elements");
        softAssert.assertTrue(find(textInput).isDisplayed());
        softAssert.assertTrue(find(inputResult).isDisplayed());
        softAssert.assertTrue(find(formSwitch).isDisplayed());
        softAssert.assertTrue(find(formDropDown).isDisplayed());
        softAssert.assertTrue(find(activeButton).isDisplayed());
        softAssert.assertTrue(find(inActiveButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Verify button's active modal elements")
    public void verifyActiveModal() {
        Logs.info("Tap on active button");
        Gestures.tap(find(activeButton));

        Logs.info("Verify button's active modal elements");
        softAssert.assertTrue(find(activeModalTitle).isDisplayed());
        softAssert.assertTrue(find(activeModalSubtitle).isDisplayed());
        softAssert.assertTrue(find(activeModalOkButton).isDisplayed());
        softAssert.assertTrue(find(activeModalCancelButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Interact with form elements")
    public void interactFormElements() {
        Logs.info("Enter random text into text input");
        find(textInput).sendKeys(randomText);

        Logs.info("Tap on switch element");
        Gestures.tap(find(formSwitch));

        Logs.info("Tap on dropdown element & then on its third option");
        Gestures.tap(find(formDropDown));
        waitForDisplayed(dropDownOptions);
        Gestures.tap(findAll(dropDownOptions).get(3));
    }

    @Step("Verify form elements after interaction")
    public void verifyFormElementsInteraction(String optionText) {
        Logs.info("Verify form elements after interaction");
        softAssert.assertEquals(find(inputResult).getText(), randomText);
        softAssert.assertEquals(find(switchText).getText(), getSwitchElementState(formSwitch));
        softAssert.assertEquals(find(formDropDown).getText(), optionText);
        softAssert.assertAll();
    }

    private String getSwitchElementState(By locator) {
        final var state = Boolean.parseBoolean(find(locator).getDomAttribute("checked"));

        if (state) {
            return "Click to turn the switch OFF";
        } else {
            return "Click to turn the switch ON";
        }
    }
}
