package utilities;

import io.appium.java_client.android.AndroidDriver;

public class ContextManager {
    private static AndroidDriver getDriver() {
        return new DriverProvider().get();
    }

    public static void switchWebViewContext() {
        final var driver = getDriver();
        final var contextSet = driver.getContextHandles();

        for (var context : contextSet) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
            }
        }
    }

    public static void switchNativeAppContext() {
        final var driver = getDriver();
        final var contextSet = driver.getContextHandles();

        for (var context : contextSet) {
            if (context.contains("NATIVE_APP")) {
                driver.context(context);
            }
        }
    }
}
