package utilities;

import pages.BottomBar;
import pages.DragPage;
import pages.FormsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SwipePage;
import pages.WebViewPage;

public class CommonFlows {
    public void goToHomePage() {
        new HomePage().waitPageToLoad();
    }

    public void goToWebViewPage() {
        goToHomePage();
        new BottomBar().goToWebViewScreen();
        new WebViewPage().waitPageToLoad();
    }

    public void goToLoginPage() {
        goToHomePage();
        new BottomBar().goToLoginScreen();
        new LoginPage().waitPageToLoad();
    }

    public void goToFormsPage() {
        goToHomePage();
        new BottomBar().goToFormsScreen();
        new FormsPage().waitPageToLoad();
    }

    public void goToSwipePage() {
        goToHomePage();
        new BottomBar().goToSwipeScreen();
        new SwipePage().waitPageToLoad();
    }

    public void goToDragPage() {
        goToHomePage();
        new BottomBar().goToDragScreen();
        new DragPage().waitPageToLoad();
    }
}
