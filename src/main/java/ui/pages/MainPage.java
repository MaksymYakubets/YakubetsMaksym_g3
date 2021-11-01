package ui.pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import libs.WebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class MainPage {

    WebDriver webDriver;
    Logger logger;
    WebElements webElements;
    Faker faker;

    @FindBy(xpath = "//button[@id='login']")
    public WebElement loginButton;

    public MainPage goToLogin(){
        webElements.clickOnElement(loginButton);
        return this;
    }

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webElements = new WebElements(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method open url
     *
     * @param url
     * */
    @Step("Open Url: {url}")
    public void openUrl(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened: " + url);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Page can't opened: " + url);
            Assert.fail("Page can't opened: " + url);
        }
    }

    @Step("Get button text: {element.getText()}")
    public String buttonText(WebElement element){
        try {
            logger.info("button text:  " + element.getText());
            return element.getText();
        } catch (Exception e) {
            logger.error("There is no button " + element + " or text in it");
            return "There is no button " + element + " or text in it";
        }
    }

    @Step("Check is Element Present: {element.isDisplayed()}")
    public boolean isElementPresent(WebElement element) {
        try {
            logger.info("Element is present: " + element.getText() + "//" + element);
            return element.isDisplayed();
        } catch (Exception e) {
            logger.error("Element is not present: " + element);
            return false;
        }
    }
}
