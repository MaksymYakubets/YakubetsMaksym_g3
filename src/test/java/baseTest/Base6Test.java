package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.Utils;
import libs.WebElements;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ui.pages.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class Base6Test{

        private WebDriver webDriver;
        Logger logger = Logger.getLogger(getClass());
        WebElements webElement;

        public MainPage mainPage;
        public RegPage regPage;
        public LoginPage loginPage;
        public MyProfile myProfile;
        public Utils utils = new Utils();

  //      public String browser;
        public String patchToScreenshot;

     /*   public Base6Test(String browser) {
            this.browser = browser;
        }*/

  /*      @Parameterized.Parameters
        public static Collection testData(){
            return Arrays.asList(new Object[][]{
                    {"chrome"},
                    {"firefox"}
            });
        }*/

        @Rule
        public TestName testName = new TestName();

        @Before
        public void setUp() {
            logger = Logger.getLogger(getClass());
            WebDriverManager.chromedriver().setup(); // download latest version of chromedriver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            webDriver = new ChromeDriver(options);
            webElement = new WebElements(webDriver);
            logger.info("Get chromeDriver");

            webDriver.manage().window().maximize();
            JavascriptExecutor executor = (JavascriptExecutor)webDriver;
            executor.executeScript("document.body.style.zoom = '1.75'");
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            File file = new File("");
            patchToScreenshot = file.getAbsolutePath() + "\\resources\\screenshot" + "-" +
                    this.getClass().getPackage().getName() + "\\" +
                    this.getClass().getSimpleName() + "\\" +
                    this.testName.getMethodName() + "-" + ".png";

            initPages();
        }

        public void initPages() {
            mainPage = new MainPage(webDriver);
            regPage = new RegPage(webDriver);
            myProfile = new MyProfile(webDriver);
            loginPage = new LoginPage(webDriver);
        }

        @After
        public void tearDown() {
            if (webDriver != null)
                utils.screenShot(patchToScreenshot, webDriver);
            webDriver.quit(); // close driver
        }
}
