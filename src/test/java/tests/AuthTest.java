package tests;

import base.BaseTest;
import com.codeborne.selenide.Configuration;
import domain.User;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;

public class AuthTest extends BaseTest {

    @Test(enabled = false)
    public void canSignUpAsValidUser() {
        User user = new User("John", "Doe",
                            genEmail(), "78qa22",
                            "514 S. Magnolia St.", "Orlando", "Florida", "32806",
                            "16546546549");
        new LoginPage()
            .open()
            .signUpAs(user)
            .myWishlistsBtn.shouldBe(visible);
    }

    @Test
    public void canSignInAsRegisteredUser() {
        User user = new User("qatest2278@gmail.com", "78qa22");
        new LoginPage()
            .open()
            .loginAs(user)
            .myWishlistsBtn.shouldBe(visible);
    }

}
