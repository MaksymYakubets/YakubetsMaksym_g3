package ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegPage extends MainPage {

    public RegPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='userName']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id = 'register']")
    public WebElement registerButton;

    @FindBy(xpath = "//button[@id='gotologin']")
    public WebElement backToLoginButton;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-checkmark']")
    //"//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']/div[@class='recaptcha-checkbox-checkmark']"
    ////*[@id='recaptcha-anchor']
    ////div[@class='recaptcha-checkbox-checkmark']
    public WebElement reCaptcha;


    /**
     * Method open SignIn page
     */
   /* public RegPage clickSignIn() {
        signInLink.click();
        return this;
    }*/

    /**
     * Method click to SignIn page
     */
    public RegPage openSignInPage() {
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        return this;
    }


    /**
     * Method input email
     *
     * @param firstName
     */


    public RegPage inputFirstName(String firstName) {
        webElements.inputText(firstNameInput, firstName);
        return this;
    }

    public RegPage inputLastName(String lastName) {
        webElements.inputText(lastNameInput, lastName);
        return this;
    }

    public RegPage inputUserName(String userName) {
        webElements.inputText(userNameInput, userName);
        return this;
    }

    public RegPage inputPassword(String password) {
        webElements.inputText(passwordInput, password);
        return this;
    }

    public RegPage clickRecaptcha() {
        webElements.clickOnElement(reCaptcha);
        return this;
    }

   public RegPage clickRegister() {
        webElements.clickOnElement(registerButton);
        return this;
    }

    public RegPage clickBackToLogin() {
        webElements.clickOnElement(backToLoginButton);
        return this;
    }

    public RegPage recaptcha(){
     return this;
    }

    public String errorText(String path, String errorClass) {
        try {
            String errorText = (String) ((JavascriptExecutor) webDriver).
                    executeScript(path);
            logger.info(errorClass + " text error: " + errorText);
            return errorText;
        } catch (Exception e) {
            logger.error(errorClass + "is optional, there is no ERROR");
            Assert.fail(errorClass + "is optional, there is no ERROR");
            return null;
        }
    }
}