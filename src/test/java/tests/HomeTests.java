package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BottomBar;
import pages.HomePage;
import utilities.BaseTest;

public class HomeTests extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final BottomBar bottomBar = new BottomBar();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToHomePage();
    }

    @Test(groups = {regression, smoke})
    public void verifyHomeElementsTest() {
        homePage.verifyPage();
    }

    @Test(groups = {regression, smoke})
    public void verifyBottomBarElementsTest() {
        bottomBar.verifyPage();
    }
}
