package pages;

import com.codeborne.selenide.Selenide;
import base.BasePage;
import com.codeborne.selenide.SelenideElement;
import domain.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends BasePage {
    public LoginPage open() {
        Selenide.open("?controller=authentication&back=my-account");
        return this;
    }

    public SelenideElement signInBtn = $("#SubmitLogin");

    public MyAccountPage loginAs(User user) {
        $("#email").setValue( user.getEmail() );
        $("#passwd").setValue( user.getPassword() );
        $("#SubmitLogin").click();
        return page(MyAccountPage.class);
    }

    public MyAccountPage signUpAs(User user) {
        $("#email_create").setValue( user.getEmail() );
        $("#SubmitCreate").click();
        $("#customer_firstname").setValue( user.getFirstName() );
        $("#customer_lastname").setValue(( user.getLastName()) );
        $("#passwd").setValue( user.getPassword() );
        $("#address1").setValue( user.getAddress() );
        $("#city").setValue( user.getCity() );
        $("#id_state").selectOption( user.getState() );
        $("#postcode").setValue( user.getZip() );
        $("#phone_mobile").setValue( user.getMobilePhone() );
        $("#submitAccount").click();
        return page(MyAccountPage.class);
    }

    public PasswordRestorePage restorePassword(String email) {
        $x("//p[contains(@class, 'lost_password form-group')]/a").click();
        $("#email").setValue( email )
                .submit();
        return page(PasswordRestorePage.class);
    }

}