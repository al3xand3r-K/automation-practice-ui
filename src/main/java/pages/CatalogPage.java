package pages;

import base.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage extends BasePage {
    public CatalogPage open() {
        Selenide.open("?id_category=3&controller=category");
        return this;
    }

    private ElementsCollection products = $$x("//ul[@class='product_list grid row']/li");
    private ElementsCollection addToCartBtn = $$x("//a[@title='Add to cart']/..");

    public CatalogPage addAnyProductToCart__catalog() {
        hoverAndClick(products.first(), addToCartBtn.first());
        productAddedConfirmation.shouldBe(visible);
        return page(this);
    }
}
