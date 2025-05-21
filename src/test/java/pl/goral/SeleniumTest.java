package pl.goral;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import pl.goral.config.ConfigProvider;
import pl.goral.extensions.NameLoggingExtension;
import pl.goral.extensions.ScreenshotTakerExtension;
import pl.goral.listeners.TestExecutionListener;

@Slf4j
@ExtendWith({NameLoggingExtension.class, ScreenshotTakerExtension.class})
public abstract class SeleniumTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUpDriver() {
        WebDriver original = setupAppropriateDriver();
        WebDriverListener listener = new TestExecutionListener();
        driver = new EventFiringDecorator<>(listener).decorate(original);
        ScreenshotTakerExtension.setDriver(driver);
    }

    private WebDriver setupAppropriateDriver() {
        String name = ConfigProvider.get("browser.name").toLowerCase();

        switch (name) {
            case "edge" -> {
                log.info("Using Edge");
                return new EdgeDriver();
            }
            case "firefox" -> {
                log.info("Using Firefox");
                return new FirefoxDriver();
            }
            default -> {
                log.info("Using Chrome");
                return new ChromeDriver();
            }
        }
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

}
