package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class CartPage {
    @Step("Open Cart Page")
    public CartPage open() {
        Selenide.open("?controller=order");
        return this;
    }

    private ElementsCollection removeProductBtn = $$x("//i[@class='icon-trash']");
    public ElementsCollection productQtyFld = $$x("//table[@id='cart_summary']/tbody/tr/td[contains(@class, 'cart_quantity')]/input[2]");
    public ElementsCollection productDescription = $$x("//td[@class='cart_description']/small/a");
    public SelenideElement emptyCartWarning = $x("//p[text()='Your shopping cart is empty.']");

    @Step("Remove first product in the list")
    public CartPage removeFirstProduct() {
        removeProductBtn.first().click();
        return page(this);
    }

    @Step("Set product qty")
    public CartPage setQty(String qty) {
        productQtyFld.first().setValue(qty);
        return page(this);
    }
}
