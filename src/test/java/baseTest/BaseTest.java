package baseTest;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import libs.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import ui.pages.*;

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

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
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
     /*   JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("document.body.style.zoom = '75%'");*/
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
    public void tearDownDriver() {
        if (webDriver != null)
            utils.screenShot(patchToScreenshot, webDriver);
        webDriver.quit(); // close driver
    }

}
