package pl.goral.extensions;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class ScreenshotTakerExtension implements AfterTestExecutionCallback {

    private static final String SCREENSHOT_DIR = "target/screenshots";

    @Setter
    private static WebDriver driver;

    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isPresent()) {
            log.info("Detected test failure, attempting to create a screenshot");
            try {
                Path screenshotDir = Paths.get(SCREENSHOT_DIR);
                ensureTheScreenshotDirectoryExists(screenshotDir);
                String filename = getFilename(context);
                Path destinationPath = screenshotDir.resolve(filename);
                takeScreenshotAndSaveToFile(destinationPath);
            } catch (IOException e) {
                log.error("Failed to save screenshot", e);
            } catch (Exception e) {
                log.error("Unexpected error during screenshot capture", e);
            }
        }
    }

    private void takeScreenshotAndSaveToFile(Path destinationPath) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshotFile.toPath(), destinationPath);
        log.info("Screenshot saved to: {}", destinationPath.toAbsolutePath());
    }

    private String getFilename(ExtensionContext context) {
        String className = context.getRequiredTestClass().getSimpleName();
        String methodName = context.getRequiredTestMethod().getName();
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return String.format("%s_%s_%s.jpg", className, methodName, timestamp);
    }

    private void ensureTheScreenshotDirectoryExists(Path screenshotDir) throws IOException {
        if (Files.notExists(screenshotDir)) {
            Files.createDirectories(screenshotDir);
        }
    }

}
