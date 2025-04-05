package pl.goral.pages.components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.goral.pages.BasePage;
import pl.goral.pages.ProfilePage;

public class LoggedInHeader extends BasePage {

    public LoggedInHeader(WebDriver driver) {
        super(driver);
    }

    public ProfilePage clickOnName(String firstName, String lastName) {
        String name = String.format("%s %s", firstName, lastName);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(name)));
        driver.findElement(By.linkText(name)).click();
        return new ProfilePage(driver);
    }
}
