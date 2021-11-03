package pagesSelenoid;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class BookStore extends MainPage {
    public SelenideElement logoutButton = $x("//button[@id = 'submit'][text()='Log out']");

    @Step("Click to logout")
    public BookStore clickLogout(){
        logoutButton.click();
        return this;
    }


}
