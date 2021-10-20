package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfile extends MainPage {
    public MyProfile(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[@id = 'submit'][text()='Log out']")
    public WebElement logoutButton;

    @FindBy(xpath = "//button[@id = 'submit'][text()='Delete All Books']")
    public WebElement deleteAllBooksButton;

    @FindBy(xpath = "//button[@id = 'submit'][text()='Delete Account']")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//button[@id = 'submit'][text()='Go To Book Store']")
    public WebElement goToBookStoreButton;

    @FindBy(xpath = "//*[@id='userName-value']")
    public WebElement userNameValue;

    @FindBy(xpath = "//span[@class='text'][text()='Login']")
    public WebElement loginLinkButton;


    public String checkUserName(){
        logger.info("User name is: " + userNameValue.getText());
        return userNameValue.getText();
    }

    @Step("Click to logout")
    public MyProfile clickLogout(){
        webElements.clickOnElement(logoutButton);
        logger.info("You have successfully logout");
        return this;
    }

    public MyProfile clickDeleteAllBooks(){
        webElements.clickOnElement(deleteAccountButton);
        return this;
    }

    public  MyProfile deleteAccount(){
        webElements.clickOnElement(deleteAccountButton);
        return this;
    }

    public MyProfile goToBookStore(){
        webElements.clickOnElement(goToBookStoreButton);
        return this;
    }

    @Step("Check is Element Present: {element.isDisplayed()}")
    public boolean isElementPresent(WebElement element) {
        try {
            logger.info(element + " is displayed");
            return element.isDisplayed();
        } catch (Exception e) {
            logger.error(element + " is not displayed");
            return false;
        }
    }

    public MainPage goToLoginPageByLink(){
        webElements.clickOnElement(loginLinkButton);
        return this;
    }

/*    public boolean checkTitleTextOnPage(String title) {
        webElements.checkTitle(title);
        return true;
    }*/
    public void checkName(String message, boolean actual, boolean expected) {
        webElements.checkAC(message, actual, expected);
    }

}
