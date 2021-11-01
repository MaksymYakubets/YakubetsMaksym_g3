package pagesSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MyAccountPage {
    public final SelenideElement
            titleRegisteredAccount = $x("//div[@id='center_column']/h1"),
            accountBtn = $x("//a[@class='account']/span");

    @Step("Get account name")
    public String getAccountName() {
        return accountBtn.getText();
    }

    public void getHeaderName(String text) {
        titleRegisteredAccount.shouldHave(Condition.exactText(text));
    }

}
