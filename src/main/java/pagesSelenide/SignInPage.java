package pagesSelenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {
    public final SelenideElement
            signInLink = $x("//a[@class='login']"),
            loginInput = $x("//input[@id='email_create']"),
            submitButtonCreate = $(By.id("SubmitCreate"));

    @Step("Click on SignIn page")
    public SignInPage clickSignIn() {
        signInLink.click();
        return this;
    }

    @Step("Input email")
    public SignInPage inputEmailCreate(String email) {
        loginInput.setValue(email);
        return this;
    }

    @Step("Click Submit to start registration")
    public SignInPage submitButtonCreate() {
        submitButtonCreate.click();
        return this;
    }
}
