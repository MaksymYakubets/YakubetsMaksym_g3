package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends MainPage {

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInLink;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement loginInput;

    @FindBy(id = "SubmitCreate")
    public WebElement submitButtonCreate;

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
    ////div[@class='account_creation']//p[4]//input[@type='text']
    public WebElement addressInput;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInput;

    @FindBy(xpath = "//select[@id='id_state']")
    public By.ByXPath stateSelect;


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

    /**
     * Method open SignIn page
     */
    public void clickSignIn() {
        signInLink.click();
    }

    /**
     * Method click to SignIn page
     */
    public void openSignInPage() {
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    /**
     * Method input email
     *
     * @param email
     */
    public void inputEmailCreate(String email) {
        webElements.inputText(loginInput, email);
    }

    public void submitButtonCreate() {
        webElements.clickOnElement(submitButtonCreate);
    }

    /**
     * Method inputCustomerFN
     *
     * @param firstName
     */
    public void inputCustomerFN(String firstName) {
        webElements.inputText(customerFistName, firstName);
    }

    /**
     * Method inputCustomerFN
     *
     * @param lastName
     */
    public void inputCustomerLN(String lastName) {
        webElements.inputText(customerLastName, lastName);
    }

    /**
     * Method inputCustomerFN
     *
     * @param email
     */
    public void inputEmail(String email) {
        webElements.inputText(emailInput, email);
    }

    /**
     * Method inputCustomerFN
     *
     * @param password
     */
    public void inputPassword(String password) {
        webElements.inputText(passwordInput, password);
    }

    /**
     * Method inputCustomerFN
     *
     * @param firstName
     */
    public void inputFirstName(String firstName) {
        webElements.inputText(firstNameInput, firstName);
    }

    /**
     * Method inputCustomerFN
     *
     * @param lastName
     */
    public void inputLastName(String lastName) {
        webElements.inputText(lastNameInput, lastName);
    }

    /**
     * Method inputCustomerFN
     *
     * @param street
     */
    public void inputAddress(String street) {
        webElements.inputText(addressInput, street);
    }

    /**
     * Method inputCustomerFN
     *
     * @param city
     */
    public void inputCity(String city) {
        webElements.inputText(cityInput, city);
    }

    /**
     * Method inputCustomerFN
     *
     * @param state
     */
    // public void selectState(int index) {                   // by index
    public void selectState(String state) {                   // by text
        Select select = new Select(webDriver.findElement(By.xpath("//select[@id='id_state']")));
        // select.selectByIndex(index);                       // by index
        select.selectByVisibleText(state);                    // by text
    }

    /**
     * Method inputCustomerFN
     *
     * @param postCode
     */
    public void inputPostCode(String postCode) {
        webElements.inputText(postCodeInput, postCode);
    }

    /**
     * Method inputCustomerFN
     *
     * @param phone
     */
    public void inputMobilePhone(String phone) {
        webElements.inputText(phoneMobileInput, phone);
    }

    /**
     * Method inputCustomerFN
     *
     * @param alias
     */
    public void inputAlias(String alias) {
        webElements.inputText(aliasInput, alias);
    }

    public void clickSubmitAccount() {
        webElements.clickOnElement(submitAccount);
    }
}