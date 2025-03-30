package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WebViewPage;
import utilities.BaseTest;

public class WebViewTests extends BaseTest {
    private final WebViewPage webViewPage = new WebViewPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToWebViewPage();
    }

    @Test(groups = {regression, smoke})
    public void verifyWebViewElementsTest() {
        webViewPage.verifyPage();
    }
}
