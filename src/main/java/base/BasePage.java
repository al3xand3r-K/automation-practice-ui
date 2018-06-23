package base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.CartPage;
import pages.CatalogPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class BasePage extends ConciseAPI {
    public SelenideElement cartBtn = $x("//div[@class='shopping_cart']/a");
    public SelenideElement productAddedConfirmation = $x("//h2/i[@class='icon-ok']");
    public SelenideElement continueShoppingBtn = $x("//span[@title='Continue shopping']");

    @Step("Open cart")
    public CartPage openCart() {
        cartBtn.click();
        return page(CartPage.class);
    }

    @Step("Click 'Continue shopping' btn")
    public CatalogPage backToShopping() {
        continueShoppingBtn.click();
        return page(CatalogPage.class);
    }
}
