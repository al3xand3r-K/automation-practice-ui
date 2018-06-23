package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class PasswordRestorePage {
    @Step("Open Password Restore Page")
    public PasswordRestorePage open() {
        Selenide.open("?controller=password");
        return this;
    }

    public SelenideElement successAlert = $x("//p[contains(@class, 'alert-success')]");
}
