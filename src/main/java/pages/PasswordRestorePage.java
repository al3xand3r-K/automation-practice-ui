package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PasswordRestorePage {
    public PasswordRestorePage open() {
        Selenide.open("?controller=password");
        return this;
    }

    public SelenideElement successAlert = $x("//p[contains(@class, 'alert-success')]");

}
