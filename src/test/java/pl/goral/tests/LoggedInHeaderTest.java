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

    @Test
    public void shouldOpenProfilePage() {
        new LoggedInHomePage(driver)
                .getLoggedInHeader()
                .clickOnName(user.getFirstName(), user.getLastName())
                .verifyPersonalInformation(user);
    }

    @Test
    public void shouldOpenQrPage() {
        new LoggedInHomePage(driver)
                .getLoggedInHeader()
                .clickOnLink("QR Code", QrPage.class)
                .verifyIsLoaded();
    }

}
