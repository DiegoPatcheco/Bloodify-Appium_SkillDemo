package pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Gestures;
import utilities.Logs;

import java.util.ArrayList;

public class DragPage extends BasePage {
    private final By titleDragLabel = AppiumBy.androidUIAutomator("text(\"Drag and Drop\")");
    private final By refreshButton = AppiumBy.accessibilityId("renew");
    private final By congratsTitle = AppiumBy.androidUIAutomator("text(\"Congratulations\")");
    private final By congratsLabel = AppiumBy.androidUIAutomator("text(\"You made it, click retry if you want to try it again.\")");
    private final By congratsRetryButton = AppiumBy.accessibilityId("button-Retry");
    private final By[] dragItemArray = new By[]{
            AppiumBy.accessibilityId("drag-l1"),
            AppiumBy.accessibilityId("drag-c1"),
            AppiumBy.accessibilityId("drag-r1"),
            AppiumBy.accessibilityId("drag-l2"),
            AppiumBy.accessibilityId("drag-c2"),
            AppiumBy.accessibilityId("drag-r2"),
            AppiumBy.accessibilityId("drag-l3"),
            AppiumBy.accessibilityId("drag-c3"),
            AppiumBy.accessibilityId("drag-r3")
    };
    private final By[] dropContainerArray = new By[]{
            AppiumBy.accessibilityId("drop-l1"),
            AppiumBy.accessibilityId("drop-c1"),
            AppiumBy.accessibilityId("drop-r1"),
            AppiumBy.accessibilityId("drop-l2"),
            AppiumBy.accessibilityId("drop-c2"),
            AppiumBy.accessibilityId("drop-r2"),
            AppiumBy.accessibilityId("drop-l3"),
            AppiumBy.accessibilityId("drop-c3"),
            AppiumBy.accessibilityId("drop-r3")
    };

    @Override
    @Step("Waiting for drag page to load")
    public void waitPageToLoad() {
        waitPage(titleDragLabel, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verify drag page elements")
    public void verifyPage() {
        Logs.info("Verify drag page elements");
        softAssert.assertTrue(find(titleDragLabel).isDisplayed());
        softAssert.assertTrue(find(dragItemArray[0]).isDisplayed());
        softAssert.assertTrue(find(dragItemArray[1]).isDisplayed());
        softAssert.assertTrue(find(dragItemArray[2]).isDisplayed());
        softAssert.assertTrue(find(dragItemArray[3]).isDisplayed());
        softAssert.assertTrue(find(dragItemArray[4]).isDisplayed());
        softAssert.assertTrue(find(dragItemArray[5]).isDisplayed());
        softAssert.assertTrue(find(dragItemArray[6]).isDisplayed());
        softAssert.assertTrue(find(dragItemArray[7]).isDisplayed());
        softAssert.assertTrue(find(dragItemArray[8]).isDisplayed());
        softAssert.assertTrue(find(dropContainerArray[0]).isDisplayed());
        softAssert.assertTrue(find(dropContainerArray[1]).isDisplayed());
        softAssert.assertTrue(find(dropContainerArray[2]).isDisplayed());
        softAssert.assertTrue(find(dropContainerArray[3]).isDisplayed());
        softAssert.assertTrue(find(dropContainerArray[4]).isDisplayed());
        softAssert.assertTrue(find(dropContainerArray[5]).isDisplayed());
        softAssert.assertTrue(find(dropContainerArray[6]).isDisplayed());
        softAssert.assertTrue(find(dropContainerArray[7]).isDisplayed());
        softAssert.assertTrue(find(dropContainerArray[8]).isDisplayed());
        softAssert.assertTrue(find(refreshButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Drag and drop image items to containers")
    public void buildPuzzle() {
        final var itemList = getList(dragItemArray);
        final var containerList = getList(dropContainerArray);
        final var n = itemList.size();

        for (var i = 0; i < n; i++) {
            Gestures.dragTo(find(itemList.get(i)), find(containerList.get(i)));
        }
    }

    @Step("Verify congratulations screen")
    public void verifyCongratulationsScreen() {
        Logs.info("Verify congratulations screen");
        softAssert.assertTrue(waitForDisplayed(congratsTitle).isDisplayed());
        softAssert.assertTrue(find(congratsLabel).isDisplayed());
        softAssert.assertTrue(find(congratsRetryButton).isDisplayed());
        softAssert.assertAll();
    }

    private static ArrayList<By> getList(By[] array) {
        final var n = array.length;
        final var list = new ArrayList<By>();

        for (var i = 0; i < n; i++) {
            list.add(array[i]);
        }

        return list;
    }
}
