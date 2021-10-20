package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStore extends MainPage {
    public BookStore(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//button[@id = 'submit'][text()='Log out']")
    public WebElement logoutButton;

    @Step("Click to logout")
    public BookStore clickLogout(){
        webElements.clickOnElement(logoutButton);
        return this;
    }


}
