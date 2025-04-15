package pl.goral.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import pl.goral.config.ConfigProvider;
import pl.goral.http.RegisterApi;
import pl.goral.http.dto.RegisterRequestDto;
import pl.goral.pages.HomePage;
import pl.goral.pages.LoggedInHomePage;
import pl.goral.pages.LoginPage;

import static pl.goral.generators.UserGenerator.getRandomUser;

@Slf4j
public class LoginTest extends AbstractTest {

    @Test
    public void shouldSuccessfullyLogin() {
        // given
        RegisterRequestDto user = getRandomUser();
        RegisterApi.register(user);

        // when + then
        new LoginPage(driver)
                .openPage()
                .attemptLogin(user.getUsername(), user.getPassword(), LoggedInHomePage.class)
                .verifyIsLoaded(user.getFirstName(), user.getEmail());
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
