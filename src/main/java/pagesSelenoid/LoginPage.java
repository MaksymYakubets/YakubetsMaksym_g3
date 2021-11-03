package pagesSelenoid;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends MainPage {

    public SelenideElement userNameInput = $x("//input[@id='userName']");
    SelenideElement passwordInput = $x("//input[@id='password']");
    SelenideElement loginButton = $x("//button[@id='login']");
    SelenideElement newUserButton = $x("//button[@id='newUser']");
    SelenideElement logoutButton = $x("//button[@id = 'submit'][text()='Log Out']");
    SelenideElement userNameValue = $x("//*[@id='userName-value']");
    SelenideElement welcomeText1 = $x("//*[@id='userForm']/div[1]/h2");
    SelenideElement welcomeText2 = $x("//*[@id='userForm']/div[1]/h5");
    public SelenideElement loginError = $x("//div[@class='login-wrapper']//p");


    @Step("Input username: {userName}")
    public LoginPage inputUserName(String userName) {
        userNameInput.setValue(userName);
        return this;
    }

    @Step("Input password: {password}")
    public LoginPage inputPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Click To Login")
    public LoginPage clickToLogin() {
        loginButton.click();
        return this;
    }

    public LoginPage clickNewUser() {
        newUserButton.click();
        return this;
    }

    public LoginPage clickLogout() {
        logoutButton.click();
        return this;
    }

    @Step("getWelcomeText")
    public String getWelcomeText() {
        return (welcomeText1.getText() + welcomeText2.getText());
    }

    public String checkUserName() {
        return userNameValue.getText();
    }

}
