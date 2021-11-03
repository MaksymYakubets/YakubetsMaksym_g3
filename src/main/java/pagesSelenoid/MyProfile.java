package pagesSelenoid;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class MyProfile extends MainPage {

    SelenideElement logoutButton = $x("//button[@id = 'submit'][text()='Log out']"),
            deleteAllBooksButton = $x("//button[@id = 'submit'][text()='Delete All Books']"),
            deleteAccountButton = $x("//button[@id = 'submit'][text()='Delete Account']"),
            goToBookStoreButton = $x("//button[@id = 'submit'][text()='Go To Book Store']"),
            userNameValue = $x("//*[@id='userName-value']"),
            loginLinkButton = $x("//span[@class='text'][text()='Login']");

    public String checkUserName() {
        return userNameValue.getText();
    }

    @Step("Click to logout")
    public MyProfile clickLogout() {
        logoutButton.click();
        return this;
    }

    public MyProfile clickDeleteAllBooks() {
        deleteAccountButton.click();
        return this;
    }

    public MyProfile deleteAccount() {
        deleteAccountButton.click();
        return this;
    }

    public MyProfile goToBookStore() {
        goToBookStoreButton.click();
        return this;
    }

    @Step("Check is Element Present: {element.isDisplayed()}")
    public boolean isElementPresent(SelenideElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public MainPage goToLoginPageByLink() {
        loginLinkButton.click();
        return this;
    }

}
