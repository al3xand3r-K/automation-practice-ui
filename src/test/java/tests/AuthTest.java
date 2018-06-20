package tests;

import base.BaseTest;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import domain.User;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;

public class AuthTest extends BaseTest {

    private Faker f = new Faker();
    private User registeredUser;

    @Test(enabled = false)
    public void canSignUpAsValidUser() {
        User user = new User(f.name().firstName(), f.name().lastName(),
                f.internet().emailAddress(), f.internet().password(),
                f.address().streetAddress(), f.address().city(), f.address().state(), f.address().zipCode(),
                f.phoneNumber().cellPhone());

        new LoginPage()
            .open()
            .signUpAs(user)
            .myWishlistsBtn.shouldBe(visible);

        registeredUser = user;
    }

    @Test
    public void canSignInAsRegisteredUser() {
        new LoginPage()
            .open()
            .loginAs(registeredUser)
            .myWishlistsBtn.shouldBe(visible);
    }

}
