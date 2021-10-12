package ui.pages;

import com.github.javafaker.Faker;
import libs.WebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainPage{
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



    public LoginPage inputUserName(String userName){
      /*  if(new WebElements().isElementPresent(logoutButton))
            logger.info("Can't login. c in");
        else*/
        webElements.inputText(userNameInput, userName);
        return this;
    }

    public LoginPage inputPassword(String password){
        /*if(new WebElements().isElementPresent(logoutButton))
            logger.info("Can't login. You are already logged in");
        else*/
        webElements.inputText(passwordInput, password);
        return this;
    }

    public LoginPage clickToLogin(){
        webElements.clickOnElement(loginButton);
        logger.info("You are successfully logged in");
        return this;
    }

    public LoginPage clickNewUser(){
        webElements.clickOnElement(newUserButton);
        return this;
    }

    public LoginPage clickLogout(){
        webElements.clickOnElement(logoutButton);
        return this;
    }

    public String getWelcomeText(){
        logger.info("Welcome text is: " + welcomeText1.getText()+welcomeText2.getText());
        return (welcomeText1.getText()+welcomeText2.getText());
    }

     public String checkUserName(){
        return userNameValue.getText();
    }

}
