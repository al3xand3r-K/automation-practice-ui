package pages;

import base.BasePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MyAccountPage extends BasePage {
    public MyAccountPage open() {
        Selenide.open("?controller=my-account");
        return this;
    }

    public SelenideElement myWishlistsBtn = $x("//span[text()='My wishlists']");
    public SelenideElement signOutBtn = $x("//a[@class='logout']/..");

    public SelenideElement errorMsg(String msg) {
        return $x("//ol/li[text()='" + msg + "']");
    }

    public LoginPage signOut() {
        signOutBtn.click();
        return page(LoginPage.class);
    }

}
