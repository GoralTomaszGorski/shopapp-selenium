package pl.goral.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.goral.pages.components.Toast;
import pl.goral.config.ConfigProvider;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Sign in')]")
    private WebElement signInButton;

    @Getter
    private final Toast toast;


    public LoginPage(WebDriver driver) {
        super(driver);
        toast = new Toast(driver);
    }

    public LoginPage openPage() {
        driver.get(ConfigProvider.get("frontend.url"));
        return this;
    }

    public <T extends BasePage> T attemptLogin(String username, String password, Class<T> expectedPage) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();
        return getInstance(expectedPage);
    }
}
