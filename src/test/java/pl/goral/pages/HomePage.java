package pl.goral.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private static final By EMAIL_FIELD = By.cssSelector("p.text-lg.text-gray-600");
    private static final By NAME_HEADER = By.cssSelector(".font-bold.mb-2");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyIsLoaded(String firstName, String email) {
        wait.until(ExpectedConditions.textToBe(NAME_HEADER, String.format("Welcome, %s!", firstName)));
        wait.until(ExpectedConditions.textToBe(EMAIL_FIELD, email));
    }

}
