package pl.goral.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.goral.SeleniumTest;
import pl.goral.config.ConfigProvider;
import pl.goral.http.LoginApi;
import pl.goral.http.RegisterApi;
import pl.goral.http.dto.RegisterRequestDto;
import pl.goral.pages.LoggedInHomePage;

import static pl.goral.generators.UserGenerator.getRandomUser;


public class LoggedInHomePageTest extends SeleniumTest {

    String token;
    RegisterRequestDto user;

    @BeforeEach
    public void setUp() {
        user = getRandomUser();
        RegisterApi.register(user);
        token = LoginApi.login(user.getUsername(), user.getPassword());

        driver.get(ConfigProvider.get("frontend.url"));
        driver.executeScript("window.localStorage.setItem('token', arguments[0]);", token);
        driver.navigate().to(ConfigProvider.get("frontend.url"));
    }

    @Test
    public void shouldLogOutSuccessfully() {
        driver.quit();
    }

    @Test
    public void shouldOpenProfilePage() {
        new LoggedInHomePage(driver)
                .getLoggedInHeader()
                .clickOnName(user.getFirstName(), user.getLastName())
                .verifyPersonalInformation(user);
    }
}
