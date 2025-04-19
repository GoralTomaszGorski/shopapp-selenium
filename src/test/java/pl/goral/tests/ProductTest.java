package pl.goral.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.goral.config.ConfigProvider;
import pl.goral.pages.ProductsPage;

public class ProductTest extends LoggedInSeleniumTest {

    @BeforeEach
    public void setUp() {
        driver.navigate().to(ConfigProvider.get("frontend.url") + "/products");
    }

    @Test
    public void shouldAddProductToBasket() {
        ProductsPage productsPage = new ProductsPage(driver);
        int productIndex = productsPage
                .verifyIsLoaded()
                .addRandomProductToBasketAndReturnItsIndex();



        driver.quit();
    }

}
