package pages;

import base.BasePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Condition.visible;

public class ProductDetailsPage extends BasePage {
    @Step("Open Product Details Page")
    public ProductDetailsPage open(String id) {
        Selenide.open("?id_product=" + id + "&controller=product");
        return this;
    }

    private SelenideElement qtyFld = $("#quantity_wanted");
    private SelenideElement sizeDd = $("#group_1");
    private SelenideElement addToCartBtn = $x("//button[@class='exclusive']/span");

    private SelenideElement colorBox(String color) {
        return $x("//a[@name='" + color + "']");
    }

    @Step("Select product props")
    public ProductDetailsPage selectProductProps(String qty, String size, String color) {
        qtyFld.setValue(qty);
        sizeDd.selectOption(size);
        colorBox(color).click();
        return page(this);
    }

    @Step("Click 'Add to cart' btn")
    public ProductDetailsPage addToCart() {
        addToCartBtn.click();
        productAddedConfirmation.shouldBe(visible);
        return page(this);
    }
}
