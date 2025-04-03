package pl.goral.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import pl.goral.config.ConfigProvider;
import pl.goral.pages.HomePage;
import pl.goral.pages.LoginPage;

@Slf4j
public class LoginTest extends AbstractTest {

    @Test
    public void shouldSuccessfullyLogin() {
        String email = ConfigProvider.get("credentials.email");
        String password = ConfigProvider.get("credentials.password");
        new LoginPage(driver)
                .openPage()
                .attemptLogin(email, password, HomePage.class)
                .verifyIsLoaded("Slawomir", "awesome@testing.com");
    }

    @Test
    public void shouldShowAlertOfInvalidCredentials() {
        new LoginPage(driver)
                .openPage()
                .attemptLogin("wrong", "wrong", LoginPage.class)
                .getToast()
                .verifyErrorMessage("Invalid username/password");
    }
}
