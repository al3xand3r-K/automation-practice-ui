package tests;

import base.BaseTest;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import domain.User;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.AllureSelenideListener;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.close;

public class AuthTest extends BaseTest {
    private Faker f = new Faker();
    private User registeredUser = new User("qatest2278@gmail.com", "78qa22");

    @BeforeClass
    public void addListener(){
        SelenideLogger.addListener("allure", new AllureSelenideListener());
    }

    @AfterMethod
    public void cleanUp() {
        close();
    }

    @Test
    @Description("Can sign up")
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

    @Test
    @Description("Can sign in as a registered user")
    public void canSignInAsRegisteredUser() {
        new LoginPage()
            .open()
            .loginAs(registeredUser)
            .myWishlistsBtn.shouldBe(visible);
    }

    @Test
    @Description("Can't sign in using unincorrect credentials")
    public void cantSignInWithIncorrectCredentials() {
        User user = new User("incorrect@email.com", "wrong pass");
        new LoginPage()
                .open()
                .loginAs(user)
                .errorMsg("Authentication failed.").shouldBe(visible);
    }

    @Test
    @Description("Can request a reset password link")
    public void canResetPassword() {
        new LoginPage()
                .open()
                .restorePassword(registeredUser.getEmail())
                .successAlert.shouldBe(visible);
    }
}
