package pl.goral.tests;

import org.junit.jupiter.api.Test;
import pl.goral.SeleniumTest;
import pl.goral.dto.RegisterRequestDto;
import pl.goral.pages.LoginPage;
import pl.goral.pages.RegisterPage;

import static pl.goral.generators.UserGenerator.getRandomUser;


public class RegisterTest extends SeleniumTest {

    @Test
    public void shouldSuccessfullyRegister() {
        RegisterRequestDto user = getRandomUser();

        new RegisterPage(driver)
                .openPage()
                .attemptRegister(user, LoginPage.class)
                .getToast()
                .verifySuccessMessage("Registration successful! You can now log in.");
    }

}
