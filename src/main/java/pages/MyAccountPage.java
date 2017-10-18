package pages;

import base.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class MyAccountPage extends BasePage {

    public SelenideElement myWishlistsBtn = $(xpath("//span[text()='My wishlists']"));

}
