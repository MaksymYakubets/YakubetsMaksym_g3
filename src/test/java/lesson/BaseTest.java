package lesson;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import libs.Utils;
import libs.WebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import lesson.pages.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    private WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
//    WebElements webElement;

    public MainPage mainPage;
    public SignInPage signInPage;
    public RegistrationPage registrationPage;
    public Registration2Page registration2Page;
    public Registration3Page registration3Page;
    public MyAccount myAccount;
    public Utils utils = new Utils();

    public String browser;
    public String patchToScreenshot;
    private Object SignInPage;

    public BaseTest() {

    }

    @Parameters("browserName")
    @BeforeClass(alwaysRun = true)
    @Step("Set up browser options {browser}")
    public void setUp(@Optional("chrome") String browser) {
         if (browser.toLowerCase().equals("chrome")) {
            logger.info(browser + " will be started");
            WebDriverManager.chromedriver().setup(); // download latest version of chromedriver
             ChromeOptions options = new ChromeOptions();
             options.addArguments("--disable-notifications");
             options.addArguments("disable-informs");
             webDriver = new ChromeDriver(options);
        //     webElement = new WebElements(webDriver);
            logger.info(browser + " is started");

        } else if (browser.toLowerCase().equals("firefox")) {
            logger.info(browser + " will be started");
            File fileDriver = new File("drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", fileDriver.getAbsolutePath());
            webDriver = new FirefoxDriver();
            logger.info(browser + " is started");
        }


        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file = new File("");
        patchToScreenshot = file.getAbsolutePath() + "\\resources\\screenshot" + "-" +
                this.getClass().getPackage().getName() + "\\" +
                this.getClass().getSimpleName() + "\\" + ".png";

        initPages();
    }

    public void initPages() {
        mainPage = new MainPage(webDriver);
        signInPage = new SignInPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        registration2Page = new Registration2Page(webDriver);
        registration3Page = new Registration3Page(webDriver);
        myAccount = new MyAccount(webDriver);
        System.out.println("initPage is done");
    }

    @AfterClass
    @Step("Tear down browser {browser}")
    public void tearDown() {
        if (webDriver != null)
            utils.screenShot(patchToScreenshot, webDriver);
        webDriver.quit(); // close driver
    }
}
