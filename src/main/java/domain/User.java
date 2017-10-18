package domain;

import lombok.Data;

@Data
public class User {
    String firstName;
    String lastName;
    String email;
    String password;
    String address;
    String city;
    String state;
    String zip;
    String mobilePhone;

    public User(String firstName, String lastName, String email, String password, String address, String city, String state, String zip, String mobilePhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.mobilePhone = mobilePhone;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
