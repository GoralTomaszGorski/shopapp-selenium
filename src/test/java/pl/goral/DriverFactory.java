package pl.goral;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.goral.config.ConfigProvider;

import java.io.IOException;

public class DriverFactory {

    public static WebDriver getDriver() throws IOException {
        String name = ConfigProvider.get("browser.name").toLowerCase();

        switch (name) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }
}
