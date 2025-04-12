package pl.goral;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.goral.extensions.NameLoggingExtension;
import pl.goral.extensions.ScreenshotTakerExtension;

@ExtendWith({NameLoggingExtension.class, ScreenshotTakerExtension.class})
public abstract class SeleniumTest {

    protected ChromeDriver driver;

    @BeforeEach
    public void setUpDriver() {
        driver = new ChromeDriver();
        ScreenshotTakerExtension.setDriver(driver);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

}
