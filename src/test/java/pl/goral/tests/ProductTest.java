package pl.goral.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.goral.config.ConfigProvider;
import pl.goral.http.interceptors.GetCartApi;
import pl.goral.pages.ProductsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest extends LoggedInSeleniumTest {

    @BeforeEach
    public void setUp() {
        driver.navigate().to(ConfigProvider.get("frontend.url") + "/products");
    }

    @Test
    public void shouldAddProductToBasket() {
        // given
        ProductsPage productsPage = new ProductsPage(driver);

        // when
        int productIndex = productsPage
                .verifyIsLoaded()
                .addRandomProductToBasketAndReturnItsIndex();

        // then
        String productName = productsPage.getProductName(productIndex);
        productsPage.verifyProductCartUpdated(productIndex);
        productsPage.getToast().verifyMessage("Added to cart", String.format("1 × %s added to your cart", productName));
        productsPage.getLoggedInHeader().assertProductCountInBasket(1);

        assertThat(GetCartApi.getCurrentNumberOfItemsInCart(token)).isEqualTo(1);
    }

}
