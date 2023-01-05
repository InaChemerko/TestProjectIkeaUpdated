import base.BaseTest;
import models.HomePage;
import models.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassTest extends BaseTest {

    @Test
    public void testSearch() {
        ShoppingCartPage cartPage = new HomePage(getDriver())
                .clickCookieOkButton()
                .enterWordAndPressEnterInSearchField("sofa")
                .clickProductItem(1)
                .clickAddToCartButton()
                .clickCloseButton()
                .enterWordAndPressEnterInSearchField("table")
                .clickProductItem(3)
                .clickAddToCartButton()
                .clickCloseButton()
                .clickShoppingCartButton();

        Assert.assertEquals(cartPage.getProductItems().size(), 2);

        cartPage.applyDiscount();

        Assert.assertEquals(cartPage.getInvalidMessage(), "Discount code is invalid.");
    }
}
