package selenideTests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import dataProviders.RegistrationPageDataProvider;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pagesSelenide.MyAccountPage;

@Listeners({ScreenShooter.class, TextReport.class})
@Report
public class RegistrationTests extends BaseTest {

    @Test(dataProvider = "registrationNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void testCreateNewAccount(Account userAccount) {
        signInPage
                .clickSignIn()
                .inputEmailCreate(userAccount.getEmail())
                .submitButtonCreate();
        registrationPage.registrationNewUser(userAccount);
        registrationPage.clickSubmitAccount();
        myAccountPage.titleRegisteredAccount.shouldHave(Condition.visible);
        Assert.assertEquals(myAccountPage.getAccountName(),
                userAccount.getFirstCustomerName() + " " + userAccount.getLastCustomerName());


    }

    @Test
    public void findProduct() {
        mainPage.getProduct("Blouse").clickOnProduct("Blouse");
    }
}
