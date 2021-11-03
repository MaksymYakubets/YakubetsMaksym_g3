/*
package baseTest;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import libs.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pagesSelenoid.*;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public MainPage mainPage;
    public RegPage regPage;
    public LoginPage loginPage;
    public MyProfile myProfile;
    public BookStore booksPage;
    public Utils utils = new Utils();
    public Faker  faker  = new Faker();
    public String patchToScreenshot;

    public BaseTest() {
    }

    @Parameters("browserName")
    @BeforeMethod
    @Step("Set up browser options {browser}")
    public void setUp(@Optional("chrome")  String browser) {
        if (browser.toLowerCase().equals("chrome")) {
            logger.info(browser + " will be started");
            WebDriverManager.chromedriver().setup(); // download latest version of chromedriver
            webDriver = new ChromeDriver();
            logger.info(browser + " is started");

        } else if (browser.toLowerCase().equals("firefox")) {
            logger.info(browser + " will be started");
            File fileDriver = new File("drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", fileDriver.getAbsolutePath());
            webDriver = new FirefoxDriver();
            logger.info(browser + " is started");
        }

        webDriver.manage().window().maximize();
     */
/*   JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("document.body.style.zoom = '75%'");*//*

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file = new File("");
        patchToScreenshot = file.getAbsolutePath() + "\\resources\\screenshot" + "-" +
                this.getClass().getPackage().getName() + "\\" +
                this.getClass().getSimpleName() + ".png";

        initPages();
    }

    public void initPages() {
        mainPage = new MainPage(webDriver);
        regPage = new RegPage(webDriver);
        myProfile = new MyProfile(webDriver);
        loginPage = new LoginPage(webDriver);
        booksPage = new BookStore(webDriver);
    }


    @AfterMethod
    @Step("Tear down browser {browser}")
    public void tearDownDriver() {
        if (webDriver != null)
            screenshot();
            utils.screenShot(patchToScreenshot, webDriver);
        webDriver.quit(); // close driver
    }

    @Attachment(value = "screenshot", type = "image.png")
    public byte[] screenshot(){
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
}*/
