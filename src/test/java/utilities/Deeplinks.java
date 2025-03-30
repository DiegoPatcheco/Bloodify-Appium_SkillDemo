package utilities;

public class Deeplinks {
    private static void goTo(String deeplink) {
        new DriverProvider().get().get(deeplink);
    }
}
