package pages;

import com.codeborne.selenide.Selenide;
import base.BasePage;
import com.codeborne.selenide.SelenideElement;
import domain.User;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends BasePage {
    @Step("Open Login Page")
    public LoginPage open() {
        Selenide.open("?controller=authentication&back=my-account");
        return this;
    }

    private SelenideElement emailFld_login = $("#email");
    private SelenideElement passwordFld_login = $("#passwd");
    private SelenideElement signInBtn_login = $("#SubmitLogin");
    private SelenideElement forgotPasswordLnk = $x("//p[contains(@class, 'lost_password form-group')]/a");

    private SelenideElement emailFld_signUp = $("#email_create");
    private SelenideElement createAccBtn = $("#SubmitCreate");
    private SelenideElement firstNameFld = $("#customer_firstname");
    private SelenideElement lastNameFld = $("#customer_lastname");
    private SelenideElement passwordFld_signUp = $("#passwd");
    private SelenideElement address1Fld = $("#address1");
    private SelenideElement cityFld = $("#city");
    private SelenideElement stateFld = $("#id_state");
    private SelenideElement zipFld = $("#postcode");
    private SelenideElement mobilePhoneFld = $("#phone_mobile");
    private SelenideElement registerBtn = $("#submitAccount");

    @Step("Sign in")
    public MyAccountPage loginAs(User user) {
        emailFld_login.setValue( user.getEmail() );
        passwordFld_login.setValue( user.getPassword() );
        signInBtn_login.click();
        return page(MyAccountPage.class);
    }

    @Step("Sign up")
    public MyAccountPage signUpAs(User user) {
        emailFld_signUp.setValue( user.getEmail() );
        createAccBtn.click();
        firstNameFld.setValue( user.getFirstName() );
        lastNameFld.setValue(( user.getLastName()) );
        passwordFld_signUp.setValue( user.getPassword() );
        address1Fld.setValue( user.getAddress() );
        cityFld.setValue( user.getCity() );
        stateFld.selectOption( user.getState() );
        zipFld.setValue( user.getZip() );
        mobilePhoneFld.setValue( user.getMobilePhone() );
        registerBtn.click();
        return page(MyAccountPage.class);
    }

    @Step("Restore password")
    public PasswordRestorePage restorePassword(String email) {
        forgotPasswordLnk.click();
        emailFld_login.setValue( email )
                .submit();
        return page(PasswordRestorePage.class);
    }
}