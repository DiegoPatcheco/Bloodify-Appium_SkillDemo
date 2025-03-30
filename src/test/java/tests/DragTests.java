package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragPage;
import utilities.BaseTest;

public class DragTests extends BaseTest {
    private final DragPage dragPage = new DragPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToDragPage();
    }

    @Test(groups = {regression, smoke})
    public void verifyFormsElementsTest() {
        dragPage.verifyPage();
    }

    @Test(groups = {regression, smoke})
    public void buildImagePuzzle() {
        dragPage.buildPuzzle();
        dragPage.verifyCongratulationsScreen();
    }
}
