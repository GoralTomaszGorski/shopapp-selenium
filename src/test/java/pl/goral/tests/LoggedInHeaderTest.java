package pl.goral.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.goral.config.ConfigProvider;
import pl.goral.pages.LoggedInHomePage;
import pl.goral.pages.QrPage;

public class LoggedInHeaderTest extends LoggedInSeleniumTest {

    @BeforeEach
    public void setUp() {
        driver.navigate().to(ConfigProvider.get("frontend.url"));
    }

    @Test
    public void shouldLogOutSuccessfully() {
        new LoggedInHomePage(driver)
                .getLoggedInHeader()
                .clickLogout()
                .verifyLoginUrl();
    }


}
