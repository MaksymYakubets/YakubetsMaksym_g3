package ui.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@id='userName']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='login']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@id='newUser']")
    public WebElement newUserButton;

    @FindBy(xpath = "//button[@id = 'submit'][text()='Log Out']")
    public WebElement logoutButton;

    @FindBy(xpath = "//*[@id='userName-value']")
    public WebElement userNameValue;

    @FindBy(xpath = "//*[@id='userForm']/div[1]/h2")
    public WebElement welcomeText1;

    @FindBy(xpath = "//*[@id='userForm']/div[1]/h5")
    public WebElement welcomeText2;

    @FindBy(xpath = "//div[@class='login-wrapper']//p")
    public WebElement loginError;


    @Step("Input FAKE username: {userName}")
    public LoginPage inputUserName(String userName) {
        webElements.inputText(userNameInput, userName);
        return this;
    }

    @Step("Input FAKE password: {password}")
    public LoginPage inputPassword(String password) {
        webElements.inputText(passwordInput, password);
        return this;
    }

    @Step("Click To Login")
    public LoginPage clickToLogin() {
        webElements.clickOnElement(loginButton);
        return this;
    }

    public LoginPage clickNewUser() {
        webElements.clickOnElement(newUserButton);
        return this;
    }

    public LoginPage clickLogout() {
        webElements.clickOnElement(logoutButton);
        return this;
    }

    @Step("getWelcomeText")
    public String getWelcomeText() {
        logger.info("Welcome text is: " + welcomeText1.getText() + welcomeText2.getText());
        return (welcomeText1.getText() + welcomeText2.getText());
    }

    public String checkUserName() {
        return userNameValue.getText();
    }

}
