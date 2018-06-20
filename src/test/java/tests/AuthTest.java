package tests;

import base.BaseTest;
import com.github.javafaker.Faker;
import domain.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.close;

public class AuthTest extends BaseTest {
    private Faker f = new Faker();
    private User registeredUser = new User("qatest2278@gmail.com", "78qa22");

    @AfterMethod
    public void cleanUp() {
        close();
    }

    @Test(priority = 1)
    public void canSignUpAsValidUser() {
        User user = new User(f.name().firstName(), f.name().lastName(),
                f.internet().emailAddress(), f.internet().password(),
                f.address().streetAddress(), f.address().city(), f.address().state(), f.numerify("#####"),
                f.numerify("#-###-###-###"));

        new LoginPage()
            .open()
            .signUpAs(user)
            .myWishlistsBtn.shouldBe(visible);
    }

    @Test(priority = 2)
    public void canSignInAsRegisteredUser() {
        new LoginPage()
            .open()
            .loginAs(registeredUser)
            .myWishlistsBtn.shouldBe(visible);
    }

    @Test(priority = 3)
    public void canSignInWithIncorrectCredentials() {
        User user = new User("incorrect@email.com", "wrong pass");
        new LoginPage()
                .open()
                .loginAs(user)
                .errorMsg("Authentication failed.").shouldBe(visible);
    }

    @Test(priority = 4)
    public void canResetPassword() {
        new LoginPage()
                .open()
                .restorePassword(registeredUser.getEmail())
                .successAlert.shouldBe(visible);
    }
}
