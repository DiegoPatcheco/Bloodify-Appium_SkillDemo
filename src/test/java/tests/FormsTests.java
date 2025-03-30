package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormsPage;
import utilities.BaseTest;

public class FormsTests extends BaseTest {
    private final FormsPage formsPage = new FormsPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToFormsPage();
    }

    @Test(groups = {regression, smoke})
    public void verifyFormsElementsTest() {
        formsPage.verifyPage();
    }

    @Test(groups = {regression, smoke})
    public void verifyActiveModalElementsTest() {
        formsPage.verifyActiveModal();
    }

    @Test(groups = {regression, smoke})
    public void formElementsInteraction() {
        formsPage.interactFormElements();
        formsPage.verifyFormElementsInteraction("This app is awesome");
    }
}
