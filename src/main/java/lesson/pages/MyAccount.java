package lesson.pages;

import io.qameta.allure.Severity;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends MainPage {
    public MyAccount(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@id='center_column']/h1")
    public WebElement titleRegisteredAccount;

    @FindBy(xpath = "//a[@class='account']/span")
    WebElement accountBtn;

    @Step("Check title")
    public String checkTitle() {
        return titleRegisteredAccount.getText();
    }

    @Step("Check title {actual}, {expected}")
    public boolean checkTitleTextOnPage(String title) {
        webElements.checkTitle(title);
        return true;
    }

    public void checkTitle(String message, boolean actual, boolean expected) {
        webElements.checkAC(message, actual, expected);
    }

    @Step("Get account name")
    public String getAccountName() {
        return accountBtn.getText();
    }

    public void getHeaderName(String text) {
        webElements.isElementPresent(text);
    }
}
