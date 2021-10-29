package com.webstore.ui.maps;

import org.openqa.selenium.By;

public class LoginMap {

    public By signIn() {
        return By.cssSelector(".login");
    }

    public By signInEmailField() { return By.cssSelector("#email");}

    public By passwordField() { return By.cssSelector("#passwd");}

    public By signInButton() { return By.cssSelector("#SubmitLogin");}

    public By signUpEmailField() { return By.cssSelector("#email_create");}

    public By createAnAccountButton() { return By.cssSelector("#SubmitCreate");}

    public By genderRadioButton() { return By.cssSelector("#id_gender1");}

    public By firstNameField() { return By.cssSelector("#customer_firstname");}

    public By lastNameField() { return By.cssSelector("#customer_lastname");}

    public By addressField() { return By.cssSelector("#address1");}

    public By cityField() { return By.cssSelector("#city");}

    public By selectState() { return By.cssSelector("#id_state");}

    public By postCodeField() { return By.cssSelector("#postcode");}

    public By mobilePhoneField() { return By.cssSelector("#phone_mobile");}

    public By submitAccountButton() { return By.cssSelector("#submitAccount");}
}
