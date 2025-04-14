package pl.goral.tests;


import org.junit.jupiter.api.BeforeEach;
import pl.goral.SeleniumTest;
import pl.goral.config.ConfigProvider;
import pl.goral.http.LoginApi;
import pl.goral.http.RegisterApi;
import pl.goral.http.dto.RegisterRequestDto;

import static pl.goral.generators.UserGenerator.getRandomUser;


public abstract class LoggedInSeleniumTest extends SeleniumTest {

    protected String token;
    protected RegisterRequestDto user;

    @BeforeEach
    public void loginUserAndSetLocalStorage() {
        user = getRandomUser();
        RegisterApi.register(user);
        token = LoginApi.login(user.getUsername(), user.getPassword());

        driver.get(ConfigProvider.get("frontend.url"));
        driver.executeScript("window.localStorage.setItem('token', arguments[0]);", token);
    }

}
