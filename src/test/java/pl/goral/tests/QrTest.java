package pl.goral.tests;

import org.junit.jupiter.api.BeforeEach;
import pl.goral.config.ConfigProvider;

public class QrTest extends LoggedInSeleniumTest {

    @BeforeEach
    public void setUp() {
        driver.navigate().to(ConfigProvider.get("frontend.url") + "/qr");
    }



}
