package ua.kiev.prog;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    WebDriver webDriver ;
    Logger logger;

    @Test
    public void googleTest() throws InterruptedException {
        logger = Logger.getLogger(getClass());
        File fileChromeDriver = new File ("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://www.selenium.dev/");
        Thread.sleep(5000);
        webDriver.quit();

    }
}
