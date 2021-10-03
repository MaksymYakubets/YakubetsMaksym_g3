package ua.kiev.prog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConverterPage extends MainPage {

    public ConverterPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[contains(text(),'Конвертер валют')]")
    private WebElement converterLink;

    public void openByClick() {
        converterLink.click();
    }

}
