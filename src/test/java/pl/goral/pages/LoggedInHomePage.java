package pl.goral.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.goral.pages.components.LoggedInHeader;

public class LoggedInHomePage extends BasePage {

    private static final By EMAIL_FIELD = By.cssSelector("p.text-lg.text-gray-600");
    private static final By NAME_HEADER = By.cssSelector(".font-bold.mb-2");

    @Getter
    private final LoggedInHeader loggedInHeader;

    public LoggedInHomePage(WebDriver driver) {
        super(driver);
        this.loggedInHeader = new LoggedInHeader(driver);
    }

    public void verifyIsLoaded(String firstName, String email) {
        wait.until(ExpectedConditions.textToBe(NAME_HEADER, String.format("Welcome, %s!", firstName)));
        wait.until(ExpectedConditions.textToBe(EMAIL_FIELD, email));
    }

}
