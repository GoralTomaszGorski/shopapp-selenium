package pl.goral.pages;

import org.openqa.selenium.WebDriver;

import static org.awaitility.Awaitility.await;

public class QrPage extends BasePage {

    public QrPage(WebDriver driver) {
        super(driver);
    }

    @SuppressWarnings("ConstantConditions")
    public void verifyIsLoaded() {
        await().ignoreException(NullPointerException.class)
                .until(() -> driver.getPageSource().contains("QR Code Generator"));
    }
}
