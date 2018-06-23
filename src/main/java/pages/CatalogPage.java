package pages;

import base.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage extends BasePage {
    @Step("Open Catalog Page")
    public CatalogPage open() {
        Selenide.open("?id_category=3&controller=category");
        return this;
    }

    private ElementsCollection products = $$x("//ul[@class='product_list grid row']/li");
    private ElementsCollection addToCartBtn = $$x("//a[@title='Add to cart']/..");

    @Step("Add any product from the catalog to cart")
    public CatalogPage addAnyProductToCart__catalog() {
        hoverAndClick(products.first(), addToCartBtn.first());
        productAddedConfirmation.shouldBe(visible);
        return page(this);
    }
}
