package tests;

import data.CustomDataProviders;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BaseTest;

public class LoginTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToLoginPage();
    }

    @Test(groups = {regression, smoke})
    public void verifyLoginElementsTest() {
        loginPage.verifyPage();
    }

    @Test(groups = {regression, smoke})
    public void verifySignUpElementsTest() {
        loginPage.verifySignUpForm();
    }

    @Test(groups = {regression, smoke})
    public void loginTest() {
        final var user = new User();

        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.verifyLoginSuccessMessage();
        loginPage.waitPageToLoad();
    }

    @Test(
            groups = {regression, smoke},
            dataProviderClass = CustomDataProviders.class,
            dataProvider = CustomDataProviders.DP_JSON_CREDENTIALS
    )
    public void invalidDataLoginTest(String email, String password, String errorMessage) {
        loginPage.fillLoginForm(email, password);
        loginPage.verifyErrorMessage(errorMessage);
    }

    @Test(
            groups = {regression, smoke},
            dataProviderClass = CustomDataProviders.class,
            dataProvider = CustomDataProviders.DP_EXCEL_CREDENTIALS
    )
    public void invalidDataSignUpTest(String email, String password, String pwdConfirm, String errorMessage) {
        loginPage.fillSignUpForm(email, password, pwdConfirm);
        loginPage.verifyErrorMessage(errorMessage);
    }
}
