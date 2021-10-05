package ua.kiev.prog;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import libs.WebElements;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class RegistrationTests {

    private WebDriver webDriver;
    Logger logger;
    WebElements webElement;
    Faker faker;

    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public Registration2Page registration2Page;
    public Registration3Page registration3Page;
    public MyAccount myAccount;

    @Before
    public void setUp() {
        logger = Logger.getLogger(getClass());
        WebDriverManager.chromedriver().setup(); // download latest version of chromedriver
        webDriver = new ChromeDriver();
        webElement = new WebElements(webDriver);
        logger.info("Get chromeDriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Wait seconds: 10");
        logger.info("browser was opened");

        mainPage = new MainPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        registration2Page = new Registration2Page(webDriver);
        registration3Page = new Registration3Page(webDriver);
        myAccount = new MyAccount(webDriver);
        Faker faker = new Faker();
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit(); // close driver
    }

    private final String EMAIL = "RERAcVV1521@gmail.com";
    private final String FIRST_NAME = faker.name().firstName();
    private final String LAST_NAME = faker.name().lastName();
    private final String PASSWORD = faker.internet().password(8,12);
    private final String STREET = faker.address().streetName();
    private final String CITY = faker.address().cityName();
    private final int STATE1 = 32;
    private final String STATE2 = "Alabama";
    private final String POST_CODE = "12345";
    private final String MOBILE_PHONE = String.valueOf(faker.phoneNumber());
    private final String COUNTRY = "-";
    private final String ERROR_1_JS = "return document.getElementsByClassName('alert-danger')[0].children[1].getElementsByTagName('li')[0].innerText;";
    private final String ERROR_2_JS = "return document.getElementsByClassName('alert-danger')[0].children[1].getElementsByTagName('li')[1].innerText;";
    private final String ERROR_3_JS = "return document.getElementsByClassName('alert-danger')[0].children[1].getElementsByTagName('li')[2].innerText;";


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
        Wait.sleep(3000);
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
     * Country not Checked
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
//                .selectState(STATE1)
                .inputCountry(COUNTRY)
//                .inputPostCode(POST_CODE)
                .inputMobilePhone(MOBILE_PHONE)
                .inputAlias(EMAIL)
                .clickSubmitAccount();

        Assert.assertEquals("There are 3 errors",
                registration3Page.errorsTitle.getText());
        logger.info("Error title: " + registration3Page.errorsTitle.getText());
        Assert.assertEquals("id_country is required.", registration3Page.errorText(ERROR_1_JS, "1st "));
        Assert.assertEquals("Country cannot be loaded with address->id_country", registration3Page.errorText(ERROR_2_JS, "2nd "));
        Assert.assertEquals("Country is invalid", registration3Page.errorText(ERROR_3_JS, "3rd "));

        Wait.sleep(3000);


    }

    /**
     * State not Checked
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


        Assert.assertEquals("There is 1 error", registration3Page.errorsTitle.getText());
        logger.info("Error title: " + registration3Page.errorsTitle.getText());


        Assert.assertEquals("This country requires you to choose a State.", registration3Page.errorText(ERROR_1_JS, "1st "));
        Wait.sleep(3000);

    }

}