package ua.prog.kiev;

import baseTest.BaseTest;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import libs.WebElements;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class RegistrationTests extends BaseTest {
    Faker faker = new Faker();

    private final String EMAIL = faker.internet().emailAddress();
    private final String FIRST_NAME = faker.name().firstName();
    private final String LAST_NAME = faker.name().lastName();
    private final String PASSWORD =  faker.internet().password(8,12);;
    private final String STREET = faker.address().streetName();
    private final String CITY = faker.address().cityName();
    private final int STATE1 = 32;
    private final String STATE2 = "Alabama";
    private final String POST_CODE = faker.number().digits(5);
    private final String MOBILE_PHONE = faker.number().digits(10);
    private final String COUNTRY = "USA";
    private final String ERROR_1_JS = "return document.getElementsByClassName('alert-danger')[0].children[1].getElementsByTagName('li')[0].innerText;";
    private final String ERROR_2_JS = "return document.getElementsByClassName('alert-danger')[0].children[1].getElementsByTagName('li')[1].innerText;";
    private final String ERROR_3_JS = "return document.getElementsByClassName('alert-danger')[0].children[1].getElementsByTagName('li')[2].innerText;";

    public RegistrationTests(String browser) {
        super(browser);
    }


    @Ignore
    @Test
    public void registrationTest() {
        mainPage.openUrl("http://automationpractice.com/");
        registrationPage.openSignInPage();
        registrationPage.inputEmailCreate(EMAIL);
        registrationPage.submitButtonCreate();
        registrationPage.inputCustomerFN(FIRST_NAME);
        registrationPage.inputCustomerLN(LAST_NAME);
        registrationPage.inputEmail(EMAIL);
        registrationPage.inputPassword(PASSWORD);
        registrationPage.inputFirstName(FIRST_NAME);
        registrationPage.inputLastName(LAST_NAME);
        registrationPage.inputAddress(STREET);
        registrationPage.inputCity(CITY);
        //   registrationPage.selectState(STATE);
        registrationPage.selectState(STATE2);
        registrationPage.inputPostCode(POST_CODE);
        registrationPage.inputMobilePhone(MOBILE_PHONE);
        registrationPage.inputAlias(EMAIL);
        registrationPage.clickSubmitAccount();
        Wait.sleep(1000);
        Assert.assertEquals("MY ACCOUNT",
                myAccount.checkTitle());
        myAccount.checkTitle("Title",
                myAccount.checkTitleTextOnPage("My account - My Store"), true);
    }

    @Ignore
    @Test
    public void registrationTest2() {
        mainPage.openUrl("http://automationpractice.com/");
        registration2Page
                .openSignInPage()
                .inputEmailCreate(EMAIL)
                .submitButtonCreate()
                .inputCustomerFN(FIRST_NAME)
                .inputCustomerLN(LAST_NAME)
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputAddress(STREET)
                .inputCity(CITY)
                .selectState(STATE1)
                .inputCountry(COUNTRY)
                .inputPostCode(POST_CODE)
                .inputMobilePhone(MOBILE_PHONE)
                .inputAlias(EMAIL)
                .clickSubmitAccount();
        Assert.assertEquals("MY ACCOUNT",
                myAccount.checkTitle());
        myAccount.checkTitle("Title",
                myAccount.checkTitleTextOnPage("My account - My Store"), true);

    }

    /**
     * Country not selected
     */

    @Test
    public void registrationTest3() {
        mainPage.openUrl("http://automationpractice.com/");
        registration3Page
                .openSignInPage()
                .inputEmailCreate(EMAIL)
                .submitButtonCreate()
                .inputCustomerFN(FIRST_NAME)
                .inputCustomerLN(LAST_NAME)
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputAddress(STREET)
                .inputCity(CITY)
                .selectState(STATE2)
                .selectCountry(COUNTRY)
                .inputPostCode(POST_CODE)
                .inputMobilePhone(MOBILE_PHONE)
                .inputAlias(EMAIL)
                .clickSubmitAccount();

        Assert.assertEquals("There are 3 errors",
                registration3Page.errorsTitle());
  //      logger.info("Error title: " + registration3Page.errorsTitle());

        Assert.assertEquals("id_country is required.", registration3Page.errorText(ERROR_1_JS, "1st "));
        Assert.assertEquals("Country cannot be loaded with address->id_country", registration3Page.errorText(ERROR_2_JS, "2nd "));
        Assert.assertEquals("Country is invalid", registration3Page.errorText(ERROR_3_JS, "3rd "));
   //     logger.info("Test passed");
        System.out.println("Test passed");
        Wait.sleep(2000);
    }

    /**
     * State not selected
     */

    @Test
    public void registrationTest4() {
        mainPage.openUrl("http://automationpractice.com/");
        registration3Page
                .openSignInPage()
                .inputEmailCreate(EMAIL)
                .submitButtonCreate()
                .inputCustomerFN(FIRST_NAME)
                .inputCustomerLN(LAST_NAME)
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputAddress(STREET)
                .inputCity(CITY)
//                .selectState(STATE1)
//                .inputCountry(COUNTRY)    // default USA
                .inputPostCode(POST_CODE)
                .inputMobilePhone(MOBILE_PHONE)
                .inputAlias(EMAIL)
                .clickSubmitAccount();

        Assert.assertEquals("There is 1 error", registration3Page.errorsTitle());
  //      logger.info("Error title: " + registration3Page.errorsTitle());

        Assert.assertEquals("This country requires you to choose a State.", registration3Page.errorText(ERROR_1_JS, "1st "));
   //     logger.info("Test passed");
        Wait.sleep(3000);
        System.out.println("Test passed");

    }

}