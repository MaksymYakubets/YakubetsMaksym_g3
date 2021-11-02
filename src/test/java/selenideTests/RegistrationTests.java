package selenideTests;


import com.codeborne.selenide.*;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import dataProviders.RegistrationPageDataProvider;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pagesSelenide.MyAccountPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Listeners({ScreenShooter.class, TextReport.class})
@Report
public class RegistrationTests extends BaseTest {

    public  final String ITEM_1 = "Blouse";
    public  final String ITEM_2 = "Printed Chiffon Dress";
    public  final String ITEM_3 = "Printed Summer Dress";

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
        Selenide.open(Configuration.baseUrl);
        mainPage.getProduct(ITEM_1).clickOnProduct(ITEM_1);
        productPage.productName.shouldHave(Condition.visible); //1
        Assert.assertEquals(ITEM_1, productPage.productName.getText()); //2
    }

    @Test
    public void findWrongPrice() {
        Selenide.open(Configuration.baseUrl);
        mainPage.getProduct(ITEM_2).clickOnProduct(ITEM_2);
        productPage.price.shouldNotHave(Condition.text("$20.50")); //1
        Assert.assertNotEquals(productPage.getPrice(),"$20.50"); //2
        Assert.assertNotEquals(productPage.productCondition.innerText(),"Used");//3

    }

    @Test
    public void itemCondition() {
        Selenide.open(Configuration.baseUrl);
        mainPage.getProduct(ITEM_3).clickOnProduct(ITEM_3);
        assertThat("Item condition is Used", productPage.isItemUsed(), is(false));

    }

    @Test
    public void addToCard() {
        Selenide.open(Configuration.baseUrl);
        mainPage.getProduct(ITEM_1).clickOnProduct(ITEM_1);
        productPage.buttonAddToCard.shouldHave(Condition.visible).click();
        productPage.layerCart.shouldHave().innerText().contains("Product successfully added to your shopping cart");
     }

     @Test
    public void checkCount(){
         Selenide.open(Configuration.baseUrl);
         mainPage.products.filter(Condition.text(ITEM_3)).shouldHave(CollectionCondition.sizeLessThan(3));
        }
}
