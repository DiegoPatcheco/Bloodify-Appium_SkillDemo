package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SwipePage;
import utilities.BaseTest;

public class SwipeTests extends BaseTest {
    private final SwipePage swipePage = new SwipePage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToSwipePage();
    }

    @Test(groups = {regression, smoke})
    public void verifyFormsElementsTest() {
        swipePage.verifyPage();
    }

    @Test(groups = {regression, smoke})
    public void verifyCarouselItemTest() {
        swipePage.doLeftSwipe(3);
        swipePage.verifyCarouselItem(3);
    }

    @Test(groups = {regression, smoke})
    public void verifyRobotElementsTest() {
        swipePage.doUpSwipe(2);
        swipePage.verifyRobotElements();
    }
}
