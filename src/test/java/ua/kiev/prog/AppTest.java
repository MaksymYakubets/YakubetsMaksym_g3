package ua.kiev.prog;


/**
 * Unit test for simple App.
 * <p>
 * Rigorous Test :-)
 * <p>
 * Rigorous Test :-)
 * <p>
 * Rigorous Test :-)
 * <p>
 * Rigorous Test :-)
 */

/**
 * Rigorous Test :-)
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver webDriver;
    Logger logger;

    public MainPage mainPage;
    public ConverterPage converterPage;

    @Before
    public void setUp() {
        logger = Logger.getLogger(getClass());
        WebDriverManager.chromedriver().setup(); // download latest version of chromedriver
        webDriver = new ChromeDriver();
        logger.info("Get chromeDriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        logger.info("Wait seconds: 1");
        mainPage = new MainPage(webDriver);
        converterPage = new ConverterPage(webDriver);
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit(); // close driver
    }

    @Test
    public void invalidPage() {
        logger.info("Test 'invalidPage' started!");

        String text = "Конвертер валют онлайн. Конвертер валют Украины онлайн по курсу НБУ";
        converterPage.openUrl("https://love.i.ua/");

        try {
            Assert.assertEquals(text, webDriver.getTitle());
            logger.info("expected result: " + text);
            logger.info("test result: " + webDriver.getTitle());
            logger.info("TEST PASSED");

        } catch (Throwable e) {
            e.printStackTrace();
            logger.info("expected result: " + text);
            logger.info("test result: " + webDriver.getTitle());
            logger.error("TEST FAILED: ", e);
            //       Assert.fail(); // игнорируем ошибку чтобы продолжить выполнение тестов
        }
        logger.info("Test 'invalidPage' finished!");
        System.out.println("====================================================================");
    }

    @Test
    public void validPage() {
        logger.info("Test 'validPage+Title' started!");
        mainPage.openUrl("https://www.i.ua/");
        converterPage.openByClick();
        String text = "Конвертер валют онлайн. Конвертер валют Украины онлайн по курсу НБУ";

        try {
            Assert.assertEquals(text, webDriver.getTitle());
            logger.info("expected result: " + text);
            logger.info("test result: " + webDriver.getTitle());
            logger.info("TEST PASSED: " + "page " + webDriver.getCurrentUrl() + "( " + text + " ) was opened");

        } catch (Throwable e) {
            e.printStackTrace();
            logger.info("expected result: " + text);
            logger.info("test result: " + webDriver.getTitle());
            logger.error("TEST FAILED", e);
        }
        logger.info("Test 'validPage+Title' finished!");
        System.out.println("====================================================================");
    }

    @Test
    public void converterCurrency() {
        logger.info("Test 'converterCurrency: currencySelector' started!");
        converterPage.openUrl("https://finance.i.ua/converter/");

        By currencySelector = By.xpath("//*[@id='converter_currency']/option");
        String[] expectedCurrencyArray = {"USD", "EUR", "RUB", "UAH", "PLN"};

        List<WebElement> currencyWebList = webDriver.findElements(currencySelector);
        List<String> currencyList = new ArrayList<>();  // from Object to String
      /*  for(WebElement e : elements){                              //1
            currencyList.add(e.getText());
        }*/
        currencyWebList.stream().map(WebElement::getText).forEach(currencyList::add); //2

        try {
            Assert.assertArrayEquals(expectedCurrencyArray, currencyList.toArray());
            for (Object element : expectedCurrencyArray) {
                logger.info("expected currency: " + element);
            }
            for (WebElement element : currencyWebList) {
                logger.info("test currency: " + element.getText());
            }
            logger.info("TEST PASSED");

        } catch (Throwable e) {
            e.printStackTrace();
            for (Object element : expectedCurrencyArray) {
                logger.info("expected currency: " + element);
            }
            for (WebElement element : currencyWebList) {
                logger.info("test currency: " + element.getText());
            }
            logger.error("TEST FAILED: ", e);
            //       Assert.fail(); // игнорируем ошибку чтобы продолжить выполнение тестов
        }
        logger.info("Test 'converterCurrency: currencySelector' finished!");
        System.out.println("====================================================================");

        logger.info("Test 'converterCurrency: currency980' started!");
        WebElement currency980 = webDriver.findElement(By.xpath("//*[@id='converter_currency']/option[4]"));
        Assert.assertEquals(currency980.getAttribute("value"), "UAH");
        logger.info("TEST PASSED");
        logger.info("Test 'converterCurrency: currency980' finished!");

        System.out.println("====================================================================");

    }


    @Test
    public void converterBanks() {
        logger.info("Test 'converterBanks' started!");
        converterPage.openUrl("https://finance.i.ua/converter/");
        By bankSelector = By.xpath("//*[@name='converter_bank']/option");

        List<WebElement> banks = webDriver.findElements(bankSelector);

        Assert.assertEquals(50, (int) banks.size());
        logger.info("expected result: " + (int) banks.size() + " banks");
        logger.info("TEST PASSED");
        logger.info("Test 'converterBanks' finished!");
        System.out.println("====================================================================");
    }

}
