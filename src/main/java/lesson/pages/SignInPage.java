package lesson.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends MainPage{

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = " //a[@class='login']")
    public WebElement signInLink;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement loginInput;

    @FindBy(id = "SubmitCreate")
    public WebElement submitButtonCreate;

     public void clickSignIn() {
        webElements.clickOnElement(signInLink);

    }

    public SignInPage inputEmailCreate(String email) {
        webElements.inputText(loginInput, email);
        return this;
    }

    public SignInPage submitButtonCreate() {
        webElements.clickOnElement(submitButtonCreate);
        return this;
    }
}
