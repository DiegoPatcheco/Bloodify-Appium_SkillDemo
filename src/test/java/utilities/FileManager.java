package utilities;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private static final String screenshotPath = "src/test/resources/screenshots";
    private static final String pageStructurePath = "src/test/resources/pageStructure";

    public static void getScreenshot(String screenshotName) {
        Logs.debug("Taking screenshot");
        final var screenshotFile = ((TakesScreenshot) new DriverProvider().get())
                .getScreenshotAs(OutputType.FILE);

        final var path = String.format("%s/%s.png", screenshotPath, screenshotName);

        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException.getLocalizedMessage());
        }
    }

    public static void getPageSource(String fileName) {
        Logs.debug("Taking the page source");
        final var path = String.format("%s/%s", pageStructurePath, fileName);

        try {
            final var file = new File(path);

            if (file.getParentFile().mkdirs()) {
                final var fileWriter = new FileWriter(file);
                final var pageSource = new DriverProvider().get().getPageSource();
                if (pageSource != null) {
                    fileWriter.write(Jsoup.parse(pageSource).toString());
                }
                fileWriter.close();
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException.getLocalizedMessage());
        }
    }

    public static void deletePreviousEvidence() {
        try {
            FileUtils.deleteDirectory(new File(screenshotPath));
            FileUtils.deleteDirectory(new File(pageStructurePath));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException.getLocalizedMessage());
        }
    }

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] getScreenshot() {
        return ((TakesScreenshot) new DriverProvider().get())
                .getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "pageSource", type = "text/html", fileExtension = "txt")
    public static String getPageSource() {
        final var pageSource = new DriverProvider().get().getPageSource();

        return pageSource != null ?
                Jsoup.parse(pageSource).toString() : "Fail when taking page source";
    }
}
