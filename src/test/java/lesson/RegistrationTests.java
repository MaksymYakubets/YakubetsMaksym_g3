package lesson;

import dataProviders.RegistrationPageDataProvider;
import lesson.BaseTest;
import lesson.pages.SignInPage;
import com.github.javafaker.Faker;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {
    Faker faker = new Faker();

    private final String EMAIL = faker.internet().emailAddress();
    private final String GENDER = "Mr.";
    private final String FIRST_NAME = faker.name().firstName();
    private final String LAST_NAME = faker.name().lastName();
    private final String PASSWORD = faker.internet().password(8, 12);
    ;
    private final String DAY = "7";
    private final String MONTH = "8";
    private final String YEAR = "1985";
    private final String STREET = faker.address().streetName();
    private final String CITY = faker.address().cityName();
    private final int STATE1 = 32;
    private final String STATE2 = "Alabama";
    private final String POST_CODE = faker.number().digits(5);
    private final String MOBILE_PHONE = faker.number().digits(10);
    private final String COUNTRY = "United States";
    private final String ERROR_1_JS = "return document.getElementsByClassName('alert-danger')[0].children[1].getElementsByTagName('li')[0].innerText;";
    private final String ERROR_2_JS = "return document.getElementsByClassName('alert-danger')[0].children[1].getElementsByTagName('li')[1].innerText;";
    private final String ERROR_3_JS = "return document.getElementsByClassName('alert-danger')[0].children[1].getElementsByTagName('li')[2].innerText;";



    @Test(dataProvider = "registrationNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void testCreateNewAccount(Account userAccount) {
        mainPage.openUrl("http://automationpractice.com/");
        signInPage.clickSignIn();
        signInPage
                .inputEmailCreate(EMAIL)
                .submitButtonCreate();
        registration3Page.registrationNewUser(userAccount).clickSubmitAccount();
        Assert.assertEquals(myAccount.getAccountName(),
                userAccount.getFirstCustomerName() + " " + userAccount.getLastCustomerName());
    }

}