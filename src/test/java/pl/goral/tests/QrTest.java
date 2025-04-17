package pl.goral.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.goral.config.ConfigProvider;
import pl.goral.pages.QrPage;

public class QrTest extends LoggedInSeleniumTest {

    @BeforeEach
    public void setUp() {
        driver.navigate().to(ConfigProvider.get("frontend.url") + "/qr");
    }


    @Test
    public void shouldGenerateQrCodeAndClearItSuccessfully() {
        new QrPage(driver)
                .generateQr("https://www.awesome-testing.com")
                .assertQrCodeDisplayed()
                .clearQrCode()
                .assertQrCodeNotDisplayed();
    }
}
