package pages;

import com.codeborne.selenide.Selenide;
import base.BasePage;
import domain.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends BasePage {

    public LoginPage open() {
        Selenide.open("/?controller=authentication&back=my-account");
        return this;
    }

    public MyAccountPage loginAs(User user) {
        $("#email").setValue( user.getEmail() );
        $("#passwd").setValue( user.getPassword() );
        $("#SubmitLogin").click();
        return page(MyAccountPage.class);
    }

    public MyAccountPage signUpAs(User user) {
        $("#email_create").setValue( user.getEmail() );
        $("SubmitCreate").click();
        $("#firstname").setValue( user.getFirstName() );
        $("#lastname").setValue(( user.getLastName()) );
        $("#passwd").setValue( user.getPassword() );
        $("#address1").setValue( user.getAddress() );
        $("#id_state").selectOption( user.getState() );
        $("#phone_mobile").setValue( user.getMobilePhone() );
        return page(MyAccountPage.class);
    }

}