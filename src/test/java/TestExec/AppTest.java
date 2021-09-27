package TestExec;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver webDriver;
    Logger logger;

    @Before
    public void setUp() {
        logger = Logger.getLogger(getClass());
        WebDriverManager.chromedriver().setup(); // download latest version of chromedriver

        /* File fileChromeDriver = new File("./drivers/chromedriver.exe");
         System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());*/

        webDriver = new ChromeDriver();
        logger.info("Get chromeDriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Wait seconds: 10");
        webDriver.get("https://rozetka.com.ua/");
        logger.info("browser was opened");
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit(); // close driver
    }

    @Test
    public void titleTest() {
        logger.info("Start: titleTest");
        By fatMenu = By.xpath("//*[@id='fat-menu']");
        By menuList = By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/rz-header-fat-menu/fat-menu/div/ul");
        By premium = By.xpath("//*[name()='use' and contains(@href,'#icon-prem')]");


        String exTitle = webDriver.findElement(fatMenu).getText();
        System.out.println("Title элемента = " + exTitle);
        Assert.assertEquals("Каталог", exTitle);

        List<WebElement> menuItemList = webDriver.findElements(menuList);

        for (WebElement element : menuItemList) {
            System.out.println(element.getAttribute("innerText"));
            Assert.assertTrue(element.getAttribute("innerText").contains("Ноутбуки и компьютеры"));
            System.out.println("Елемент списка с атрибутом \"Ноутбуки и компьютеры\" найден");
        }

        webDriver.findElement(premium).click();
        Wait.sleep(5000);
        webDriver.navigate().back();
        System.out.println("Title главной страницы = " + webDriver.getTitle());

        logger.info("Finish: titleTest");
    }

    @Test
    public void keysTest() {
        logger.info("Start: keysTest");
        By searchInput = By.xpath("//input[@name = 'search']");
        String text = "iphone 13 pro max";

        webDriver.findElement(searchInput).isEnabled();
        webDriver.findElement(searchInput).sendKeys("iphone 13 pro max" + Keys.ENTER);
        // Wait.sleep(3000);
        WebElement searchResult = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(searchInput));
        logger.info("Finish: keysTest");
    }

}











