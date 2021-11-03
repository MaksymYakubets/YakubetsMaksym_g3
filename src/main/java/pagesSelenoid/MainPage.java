package pagesSelenoid;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import static com.codeborne.selenide.Selenide.$x;


public class MainPage {

    public final SelenideElement loginButton = $x("//button[@id='login']");

    @Step("Click Login button")
    public MainPage goToLogin() {
        loginButton.click();
        return this;
    }

    @Step("Open Url: {url}")
    public void openUrl(String url) {
        try {
            Selenide.open(url);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Page can't opened: " + url);
        }
    }

    @Step("Get button text: {element.getText()}")
    public String buttonText(SelenideElement element) {
        try {
           return element.getText();
        } catch (Exception e) {
            return "There is no button " + element + " or text in it";
        }
    }

    @Step("Check is Element Present: {element.isDisplayed()}")
    public boolean isElementPresent(SelenideElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
