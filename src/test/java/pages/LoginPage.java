package pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {
    private final By emailLoginInput = AppiumBy.accessibilityId("input-email");
    private final By passwordLoginInput = AppiumBy.accessibilityId("input-password");
    private final By loginButton = AppiumBy.accessibilityId("button-LOGIN");
    private final By signUpFormButton = AppiumBy.accessibilityId("button-sign-up-container");
    private final By emailSignUpInput = AppiumBy.accessibilityId("input-email");
    private final By passwordSignUpInput = AppiumBy.accessibilityId("input-password");
    private final By pwdConfirmSignUpInput = AppiumBy.accessibilityId("input-repeat-password");
    private final By signUpButton = AppiumBy.accessibilityId("button-SIGN UP");
    private final By successTitle = AppiumBy.id("android:id/alertTitle");
    private final By successDescription = AppiumBy.id("android:id/message");
    private final By successConfirmButton = AppiumBy.id("android:id/button1");
    private final String errorMessageLocator = "text(\"%s\")";

    @Override
    @Step("Waiting for login page to load")
    public void waitPageToLoad() {
        waitPage(emailLoginInput, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verify login page elements")
    public void verifyPage() {
        Logs.info("Verify login page elements");
        softAssert.assertTrue(find(emailLoginInput).isDisplayed());
        softAssert.assertTrue(find(passwordLoginInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Verify signup form elements")
    public void verifySignUpForm() {
        Logs.info("Click on sign up form button");
        find(signUpFormButton).click();

        Logs.info("Verify signup form elements");
        softAssert.assertTrue(waitForDisplayed(emailSignUpInput).isDisplayed());
        softAssert.assertTrue(find(passwordSignUpInput).isDisplayed());
        softAssert.assertTrue(find(pwdConfirmSignUpInput).isDisplayed());
        softAssert.assertTrue(find(signUpButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Fill login form")
    public void fillLoginForm(String email, String password) {
        Logs.info("Enter email");
        find(emailLoginInput).sendKeys(email);

        Logs.info("Enter password");
        find(passwordLoginInput).sendKeys(password);

        Logs.info("Click on login button");
        find(loginButton).click();
    }

    @Step("Fill sign up form")
    public void fillSignUpForm(String email, String password, String pwdConfirm) {
        Logs.info("Go to sign up form");
        find(signUpFormButton).click();

        Logs.info("Enter email");
        waitForDisplayed(emailSignUpInput).sendKeys(email);

        Logs.info("Enter password");
        find(passwordSignUpInput).sendKeys(password);

        Logs.info("Confirm password");
        find(pwdConfirmSignUpInput).sendKeys(pwdConfirm);

        Logs.info("Click on sign up button");
        find(signUpButton).click();
    }

    @Step("Verify success message")
    public void verifyLoginSuccessMessage() {
        Logs.info("Verify success message");
        softAssert.assertTrue(waitForDisplayed(successTitle).isDisplayed());
        softAssert.assertTrue(find(successDescription).isDisplayed());
        softAssert.assertTrue(find(successConfirmButton).isDisplayed());
        softAssert.assertAll();

        Logs.info("Click on success confirm button");
        find(successConfirmButton).click();
    }

    @Step("Verify error message")
    public void verifyErrorMessage(String errorMessage) {
        Logs.info("Verify error message");
        final var errorMessageLabel = AppiumBy.androidUIAutomator(
                String.format(errorMessageLocator, errorMessage));

        softAssert.assertTrue(waitForDisplayed(errorMessageLabel).isDisplayed());
        softAssert.assertEquals(find(errorMessageLabel).getText(), errorMessage);
        softAssert.assertAll();
    }
}
