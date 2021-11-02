package selenideTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pagesSelenide.*;

import java.util.HashMap;
import java.util.Map;

@Listeners({ScreenShooter.class, TextReport.class })
@Report
public class BaseTest {

    public Faker faker = new Faker();

    public SignInPage signInPage = new SignInPage();
    public RegistrationPage registrationPage = new RegistrationPage();
    public MyAccountPage myAccountPage = new MyAccountPage();
    public MainPage mainPage = new MainPage();
    public ProductPage productPage = new ProductPage();

    public void setUpBrowser(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        // 1 - Allow, 2- Block, 0 - default
        prefs.put("profile.default_content_seetting_values.notification", 1);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("disable-infobars");
        options.addArguments("--window-size=1920,1080");
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().browserVersion("94").setup();
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.baseUrl = "http://automationpractice.com";
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
        Configuration.reopenBrowserOnFail = true;
        setUpBrowser();
        Selenide.open(Configuration.baseUrl);
    }

    @AfterClass
    public void tearDown(){
        // Selenide.closeWebDriver();
        WebDriverRunner.getWebDriver().quit();
    }
}
