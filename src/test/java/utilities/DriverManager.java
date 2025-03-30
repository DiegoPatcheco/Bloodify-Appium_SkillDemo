package utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private final boolean runServer = System.getenv("Run Appium Tests and Generate Allure Report") != null;

    public void buildDriver() {
        if (runServer) {
            buildRemoteDriver();
        } else {
            buildLocalDriver();
        }
    }

    public void killDriver() {
        Logs.debug("Killing driver");
        new DriverProvider().get().quit();
    }

    private void buildLocalDriver() {
        try {
            final var appiumURL = "http://127.0.0.1:4723/";
            final var desiredCapabilities = getDesiredLocalCapabilities();

            Logs.debug("Initializing driver");
            final var driver = new AndroidDriver(new URL(appiumURL), desiredCapabilities);

            Logs.debug("Assign driver to driver provider");
            new DriverProvider().set(driver);
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException.getLocalizedMessage());
        }
    }

    private void buildRemoteDriver() {
        try {
            final var remoteAppiumUrl = System.getProperty("remoteUrl", "http://remote-server-url:4723/");
            final var desiredCapabilities = getDesiredRemoteCapabilities();

            Logs.debug("Initializing remote Appium driver");
            final var driver = new AndroidDriver(new URL(remoteAppiumUrl), desiredCapabilities);

            Logs.debug("Assign remote driver to driver provider");
            new DriverProvider().set(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid remote Appium server URL: " + e.getMessage(), e);
        }
    }

    private static DesiredCapabilities getDesiredLocalCapabilities() {
        final var desiredCapabilities = new DesiredCapabilities();

        final var fileAPK = new File("src/test/resources/apk/wdioAPP.apk");

        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);
        desiredCapabilities.setCapability("appium:appWaitActivity", "com.wdiodemoapp.MainActivity");
        desiredCapabilities.setCapability("appium:platformName", "Android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:app", fileAPK.getAbsolutePath());

        return desiredCapabilities;
    }

    private static DesiredCapabilities getDesiredRemoteCapabilities() {
        final var desiredCapabilities = new DesiredCapabilities();

        final var fileAPK = new File("src/test/resources/apk/wdioAPP.apk");

        desiredCapabilities.setCapability("appium:platformName", "Android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:deviceName", "Android Emulator");
        desiredCapabilities.setCapability("appium:platformVersion", "11.0");
        desiredCapabilities.setCapability("appium:appWaitActivity", "com.wdiodemoapp.MainActivity");
        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);

        // Use either a local path or URL to the .apk depending on your remote setup
        desiredCapabilities.setCapability("appium:app", fileAPK.getAbsolutePath());

        return desiredCapabilities;
    }
}
