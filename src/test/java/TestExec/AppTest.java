package TestExec;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        // File fileChromeDriver = new File("./drivers/chromedriver.exe");
        // System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());

        //ChromeOptions options = new ChromeOptions();
        // options.addArguments("--disable-web-security");

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
    public void titelTest() {
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
        //   ((JavascriptExecutor) webDriver).executeScript("arguments[0].click():", ele); // гугл сказал что работает, но там какие-то приколы с скрытыми елементами
        Wait.sleep(5000);

        webDriver.navigate().back();
        System.out.println("Title главной страницы = " + webDriver.getTitle());

    }

      /*  @Test
        public void SendKeys () {
        }*/

}








     /*   String exTitle = webDriver.findElement(By.xpath("//div[@class='text-center']/h1")).getText();
        Assert.assertEquals("Selenium automates browsers. That's it!", exTitle);
        webDriver.findElement(By.xpath("//div[@class='selenium-button-container']/a[@href='/documentation/webdriver/']")).click();
        String exTittleWD = webDriver.findElement(By.xpath("//div[@class='td-content']/h1")).getText();
        Assert.assertEquals("WebDriver", exTittleWD);
        webDriver.findElement(By.xpath("//div[@class='selenium-button-container']/a")).click();
        String exTittleSponsor = webDriver.findElement(By.xpath("//div[@class='text-center']/h1")).getText();
        Assert.assertEquals("Sponsors", exTittleSponsor);*/




