package baseTest;

import com.github.javafaker.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import libs.WebElements;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public Registration2Page registration2Page;
    public Registration3Page registration3Page;
    public MyAccount myAccount;
    public String browser;
    public String patchToScreenshot;

    public BaseTest(String browser) {
        this.browser = browser;
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        switch (browser) {
            case "chrome":
                logger.info(browser + " is started");
                logger = Logger.getLogger(getClass());
                WebDriverManager.chromedriver().setup(); // download latest version of chromedriver
                webDriver = new ChromeDriver();
                logger.info(browser + " is started");
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file = new File("");
        patchToScreenshot = file.getAbsolutePath() + "\\resources\\screenshot" +
                this.getClass().getPackage().getName() + "\\" +
                this.getClass().getSimpleName() + "\\" +
                this.testName.getMethodName() + "-" + browser + ".png";

        initPages();
    }

    public void initPages(){
        mainPage = new MainPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        registration2Page = new Registration2Page(webDriver);
        registration3Page = new Registration3Page(webDriver);
        myAccount = new MyAccount(webDriver);
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit(); // close driver
    }
}
