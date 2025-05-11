package pl.goral.listeners;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

@Slf4j
public class TestExecutionListener implements WebDriverListener {



    @Override
    public void afterGet(WebDriver driver, String url) {
        log.info("Navigated to {}", url);
    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {
        log.info("Navigated to {}", url);
    }


}
