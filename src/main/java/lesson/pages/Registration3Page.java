package lesson.pages;

import model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Registration3Page extends MainPage {
    public Registration3Page(WebDriver webDriver) {
        super(webDriver);
    }

  /*  @FindBy(xpath = "//a[@class='login']")
    public WebElement signInLink;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement loginInput;

    @FindBy(id = "SubmitCreate")
    public WebElement submitButtonCreate;*/

    @FindBy(xpath = "//div[@class='radio-inline'][1]")
    WebElement genderMr;

    @FindBy(xpath = "//div[@class='radio-inline'][2]")
    WebElement genderMrs;

    @FindBy(id = "days")
    WebElement daysDropDown;

    @FindBy(id = "months")
    WebElement monthsDropDown;

    @FindBy(id = "years")
    WebElement yearsDropDown;

    @FindBy(id = "customer_firstname")
    public WebElement customerFistName;

    @FindBy(name = "customer_lastname")
    public WebElement customerLastName;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;

    @FindBy(name = "passwd")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//div[@class='account_creation']//p[4]//input[@type='text']")
    public WebElement addressInput;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInput;

    @FindBy(xpath = "//select[@id='id_state']")
    public WebElement stateSelect;

    @FindBy(xpath = "//input[@id='postcode']")
    public WebElement postCodeInput;

    @FindBy(xpath = "//select[@id='id_country']")
    public WebElement idCountry;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    public WebElement phoneMobileInput;

    @FindBy(xpath = "//input[@id='alias']")
    public WebElement aliasInput;


    @FindBy(xpath = "//button[@id='submitAccount']")
    public WebElement submitAccount;

    @FindBy(xpath = "//div[@id='center_column']/h1")
    public WebElement titleRegisteredAccount;

    @FindBy(xpath = "//div[@class='alert alert-danger']/p")
    public WebElement errorsTitle;



    /**
     * Method click to SignIn page
     */
    public Registration3Page openSignInPage() {
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        return this;
    }




    /*public Registration3Page inputEmailCreate(String email) {
        webElements.inputText(loginInput, email);
        return this;
    }

    public Registration3Page submitButtonCreate() {
        webElements.clickOnElement(submitButtonCreate);
        return this;
    }*/

    public Registration3Page selectGender(String gender){
        if (gender.equals("Mr.")) {
            webElements.clickRadioButton(genderMr,gender);
        } else {
            webElements.clickRadioButton(genderMrs,gender);
        }
        return this;
    }

    public Registration3Page inputCustomerFN(String firstName) {
        webElements.inputText(customerFistName, firstName);
        return this;
    }

    public Registration3Page inputCustomerLN(String lastName) {
        webElements.inputText(customerLastName, lastName);
        return this;
    }

    public Registration3Page inputEmail(String email) {
        webElements.inputText(emailInput, email);
        return this;
    }

    public Registration3Page inputPassword(String password) {
        webElements.inputText(passwordInput, password);
        return this;
    }

    public Registration3Page selectBirthDay(String day){
        webElements.selectValueInDropDown(daysDropDown, day);
        return this;
    }

    public Registration3Page selectMonth(String month){
        webElements.selectValueInDropDown(monthsDropDown, month);
        return this;
    }

    public Registration3Page selectYear(String year){
        webElements.selectValueInDropDown(yearsDropDown, year);
        return this;
    }


    public Registration3Page inputFirstName(String firstName) {
        webElements.inputText(firstNameInput, firstName);
        return this;
    }

    public Registration3Page inputLastName(String lastName) {
        webElements.inputText(lastNameInput, lastName);
        return this;
    }

    public Registration3Page inputAddress(String street) {
        webElements.inputText(addressInput, street);
        return this;
    }

    public Registration3Page inputCity(String city) {
        webElements.inputText(cityInput, city);
        return this;
    }

    public Registration3Page selectState(String text) {
        webElements.selectTextInDropDownByText(stateSelect, text);
        return this;
    }

    public Registration3Page selectCountry (String  text){
        webElements.selectTextInDropDownByText(idCountry, text);
        return this;
    }


    public Registration3Page inputPostCode(String postCode) {
        webElements.inputText(postCodeInput, postCode);
        return this;
    }

    public Registration3Page inputCountry(String country) {
        Select select = new Select(webDriver.findElement(By.xpath("//select[@id='id_country']")));
        select.selectByVisibleText(country);
        return this;
    }

    public Registration3Page inputMobilePhone(String phone) {
        webElements.inputText(phoneMobileInput, phone);
        return this;
    }

    public Registration3Page inputAlias(String alias) {
        webElements.inputText(aliasInput, alias);
        return this;
    }

    public Registration3Page clickSubmitAccount() {
        webElements.clickOnElement(submitAccount);
        return this;
    }

    public Registration3Page registrationNewUser(Account account){
        selectGender(account.getGender());
        inputCustomerFN(account.getFirstCustomerName());
        inputCustomerLN(account.getLastCustomerName());
        inputEmail(account.getEmail());
        inputPassword(account.getPassword());
        selectBirthDay(account.getDay());
        selectMonth(account.getMonth());
        selectYear(account.getYear());
        inputFirstName(account.getFirstName());
        inputLastName(account.getLastName());
        inputAddress(account.getAddress1());
        inputCity(account.getCity());
        selectState(account.getState());
        inputPostCode(account.getPostCode());
        selectCountry(account.getCountry());
        inputMobilePhone(account.getPhoneMobile());
        inputAlias(account.getAlias());
        return this;
    }

    public String errorsTitle() {
        return errorsTitle.getText();
    }

    public String errorText(String path, String errorClass) {
        try {
            String errorText = (String) ((JavascriptExecutor) webDriver).
                    executeScript(path);
            logger.info(errorClass + " text error: " + errorText);
            return errorText;
        } catch (Exception e) {
            logger.error(errorClass + "is optional, there is no ERROR");
            Assert.fail(errorClass + "is optional, there is no ERROR");
            return null;
        }
    }
}