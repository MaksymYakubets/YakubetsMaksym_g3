package pagesSelenoid;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class RegPage extends MainPage {

    SelenideElement firstNameInput = $x("//input[@id='firstname']"),
            lastNameInput = $x("//input[@id='lastname']"),
            userNameInput = $x("//input[@id='userName']"),
            passwordInput = $x("//input[@id='password']"),
            registerButton = $x("//button[@id = 'register']"),
            backToLoginButton = $x("//button[@id='gotologin']"),
            reCaptcha = $x("//div[@class='recaptcha-checkbox-checkmark']");

    public RegPage openSignInPage() {
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        return this;
    }

    public RegPage inputFirstName(String firstName) {
        firstNameInput.val(firstName);
        return this;
    }

    public RegPage inputLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegPage inputUserName(String userName) {
        userNameInput.setValue(userName);
        return this;
    }

    public RegPage inputPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public RegPage clickRecaptcha() {
        reCaptcha.click();
        return this;
    }

    public RegPage clickRegister() {
        registerButton.click();
        return this;
    }

    public RegPage clickBackToLogin() {
        backToLoginButton.click();
        return this;
    }

    public RegPage recaptcha() {
        return this;
    }

}
