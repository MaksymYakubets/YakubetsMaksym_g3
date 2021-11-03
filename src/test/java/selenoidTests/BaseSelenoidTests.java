package selenoidTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import libs.Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pagesSelenide.*;
import pagesSelenoid.*;
import pagesSelenoid.MainPage;

import java.util.HashMap;
import java.util.Map;

@Listeners({ScreenShooter.class, TextReport.class})
@Report
public class BaseSelenoidTests {
    public Faker faker = new Faker();

    public MainPage mainPage = new MainPage();
    public RegPage regPage = new RegPage();
    public LoginPage loginPage = new LoginPage();
    public MyProfile myProfile = new MyProfile();
    public BookStore booksPage = new BookStore();
    public Utils utils = new Utils();

    public void setUpBrowser() {
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
    public void setUp() {
        final String RUN_TYPE = "remote";
        switch (RUN_TYPE) {
            case ("local"):
                WebDriverManager.chromedriver().browserVersion("94").setup();
                Configuration.browser = "chrome";
                Configuration.timeout = 10000;
                Configuration.baseUrl = "https://demoqa.com/login";
                Configuration.screenshots = true;
                Configuration.savePageSource = true;
                Configuration.reopenBrowserOnFail = true;
                setUpBrowser();
                Selenide.open(Configuration.baseUrl);
                break;
            case ("remote"):
                Configuration.remote = "http://localhost:4444/wd/hub";
                Configuration.browserSize = "1920x1080";
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "94.0");
                capabilities.setCapability("platform", "LINUX");
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);
                capabilities.setCapability("enableLog", true);
                Configuration.browserCapabilities = capabilities;
                Selenide.open("https://demoqa.com/login");
                break;
        }
    }


    @AfterClass
    public void tearDown() {
        // Selenide.closeWebDriver();
        WebDriverRunner.getWebDriver().quit();
    }
}
