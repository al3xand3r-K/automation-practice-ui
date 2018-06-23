package tests;

import base.BaseTest;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CatalogPage;
import pages.ProductDetailsPage;
import utils.AllureSelenideListener;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.close;

public class CartTest extends BaseTest {
    @BeforeClass
    public void addListener(){
        SelenideLogger.addListener("allure", new AllureSelenideListener());
    }

    @AfterMethod
    public void cleanUp() {
        close();
    }

    @Test
    public void guestUser__canAddProductToCart__fromCatalog() {
        new CatalogPage()
            .open()
            .addAnyProductToCart__catalog()
            .backToShopping()
            .openCart()
            .productQtyFld.first().shouldHave(value("1"));
    }

    @Test
    public void guestUser__canAddProductToCart__fromPDP() {
        CartPage p = new ProductDetailsPage()
            .open("4")
            .selectProductProps("2", "M", "Pink")
            .addToCart()
            .backToShopping()
            .openCart();
        p.productQtyFld.first().shouldHave(value("2"));
        p.productDescription.first().shouldHave(text("Color : Pink, Size : M"));
    }

    @Test
    public void guestUser__canRemoveProductFromCart() {
        new CatalogPage()
            .open()
            .addAnyProductToCart__catalog()
            .backToShopping()
            .openCart()
            .removeFirstProduct()
            .emptyCartWarning.shouldBe(visible);
    }

    @Test
    public void guestUser__canEditProductQtyInCart() {
        new ProductDetailsPage()
                .open("4")
                .selectProductProps("2", "M", "Pink")
                .addToCart()
                .backToShopping()
                .openCart()
                .setQty("3")
                .productQtyFld.first().shouldHave(value("3"));
    }

    @Test
    public void failingTest() {
        new ProductDetailsPage()
                .open("4")
                .selectProductProps("2", "M", "Pink")
                .addToCart()
                .backToShopping()
                .openCart()
                .productQtyFld.first().shouldHave(value("3"));
    }
}
