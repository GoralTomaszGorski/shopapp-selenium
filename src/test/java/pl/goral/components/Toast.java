package pl.goral.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.goral.pages.BasePage;

public class Toast extends BasePage {

    private static final By TYPE = By.cssSelector("._title_gmcqp_44");
    private static final By DESCRIPTION = By.cssSelector("._description_gmcqp_50");

    public Toast(WebDriver driver) {
        super(driver);
    }

    public void verifyErrorMessage(String errorMessage) {
        wait.until(ExpectedConditions.textToBe(TYPE, "Error"));
        wait.until(ExpectedConditions.textToBe(DESCRIPTION, errorMessage));
    }
}
