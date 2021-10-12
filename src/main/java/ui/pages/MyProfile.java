package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfile extends MainPage {
    public MyProfile(WebDriver webDriver) {
        super(webDriver);
    }
  /*  public MyProfile(WebDriver webDriver) {
        super(webDriver);
        if (!webDriver.getTitle().equals("Home Page of logged in user")) {
            throw new IllegalStateException("This is not Home Page of logged in user," +
                    " current page is: " + webDriver.getCurrentUrl());
        }
    }*/

    /**
     * Get message (h1 tag)
     *
     * @return String message text
     */
 /*   public String getMessageText() {
        return webDriver.findElement(messageBy).getText();
    }*/

    public MyProfile manageProfile() {
        // Page encapsulation to manage profile functionality
        return new MyProfile(webDriver );
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

    public boolean isElementPresent(WebElement element) {
        try {
            logger.info(element + " is displayed");
            return element.isDisplayed();
        } catch (Exception e) {
            logger.error(element + " is not displayed");
            return false;
        }
    }

    public String buttonText(WebElement element){
        try {
            logger.info("button text:  " + element.getText());
            return element.getText();
        } catch (Exception e) {
            logger.error("There is no button " + element + " or text in it");
            return "There is no button " + element + " or text in it";
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
