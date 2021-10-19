package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class WebElements {

    WebDriver webDriver;
    Logger logger;

    public WebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public WebElements() {

    }

    /**
     * Method input text
     *
     * @param element
     * @param text
     */
    public void inputText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted");
        } catch (Exception e) {
            logger.error("Can't work with element " + element);
            Assert.fail("Can't work with element " + element);
        }
    }

    /**
     * Method click element button
     *
     * @param element
     */
    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked " + element);
        } catch (Exception e) {
            logger.error("Can't work with element " + element);
            Assert.fail("Can't work with element " + element);
        }
    }

    public void clickRadioButton(WebElement element,String text){
        try{
            boolean status = element.isDisplayed();
            if (status){
                logger.info("Checkbox is initially checked");
            }else{
                logger.info("Element was clicked " + element);
            }
        } catch (Exception e){
            logger.error("Can't work with element " + element);
        }
    }

    public boolean isElementPresent(String text) {
        try {
            return webDriver.findElement(By.xpath(text)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectValueInDropDown(WebElement element,String value){
        try{
            Select optionsFromDropDown = new Select(element);
            optionsFromDropDown.selectByValue(value);
            logger.info("Was selected by value " + value);
        } catch (Exception e){
            logger.error("Can't work with element " + element) ;
        }
    }

    public void selectTextInDropDownByText(WebElement element, String text){
        try{
            Select optionsFromDropDown = new Select(element);
            optionsFromDropDown.selectByVisibleText(text);
            logger.info("Was selected us DropDown by" + text);
        } catch (Exception e){
            logger.error("Can't work with element" + element);
        }
    }

    public void checkTitle(String exTitle) {
        try {
            assertThat("Title not matched", webDriver.getTitle(), is(exTitle));
        } catch (Exception e) {
            logger.error("Can't find title " + exTitle);
            Assert.fail("Can't find title " + exTitle);
        }
    }

    public void checkTitleInElement(String xpath, String text) {
        try {
            String textFromElement = webDriver.findElement(By.xpath(xpath)).getText();
            assertThat("Text in element not matched", textFromElement, is(text));
        } catch (Exception e) {
            logger.error("Can't check text in element " + text);
            Assert.fail("Can't check text in element " + text);
        }
    }

    public void checkAC(String message, boolean actualRes, boolean expectedRes) {
       assertThat(message, actualRes, is(expectedRes));
    }

}