package ui.tests;

import baseTest.BaseTest;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegTests extends BaseTest {
    Faker faker = new Faker();

    private final String USER_NAME = "QA_AUTO";
    private final String PASSWORD = "Lesson(#6)";

/*
    @Test
    public void tegTest() {
        mainPage.openUrl("https://demoqa.com/register");
        regPage
                .inputFirstName(faker.name().firstName())
                .inputLastName(faker.name().lastName())
                .inputUserName(faker.name().username())
                .inputPassword(faker.internet()
                        .password(10,14,true,true));
        WebDriverWait(, 10).until(EC.frame_to_be_available_and_switch_to_it((By.CSS_SELECTOR,"iframe[name^='a-'][src^='https://www.google.com/recaptcha/api2/anchor?']")))
        WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']/div[@class='recaptcha-checkbox-checkmark']"))).click()

    }*/



    @Test
    public void validLoginTest() {
        mainPage.openUrl("https://demoqa.com/login");
        loginPage
                .inputUserName(USER_NAME)
                .inputPassword(PASSWORD)
                .clickToLogin();
        Assert.assertEquals(USER_NAME, loginPage.checkUserName());
    }

    @Test
    public void validLoginFromBookStoreTest() {
        mainPage.openUrl("https://demoqa.com/books");
        mainPage.goToLogin();
        loginPage
                .inputUserName(USER_NAME)
                .inputPassword(PASSWORD)
                .clickToLogin();

        assertThat("Button is displayed in Page: ",
                booksPage.isElementPresent(booksPage.logoutButton), is(true));
        Assert.assertEquals("Log out", booksPage.buttonText(booksPage.logoutButton));
        System.out.println("Test passed");
    }

    @Test
    public void validLoginLogoutTest() {
        mainPage.openUrl("https://demoqa.com/login");
        loginPage
                .inputUserName(USER_NAME)
                .inputPassword(PASSWORD)
                .clickToLogin();

        myProfile.clickLogout();
        Assert.assertEquals("Welcome,Login in Book Store", loginPage.getWelcomeText());
        System.out.println("Test passed");

    }

    @Test
    public void invalidFakeLogin() {
        mainPage.openUrl("https://demoqa.com/login");
        loginPage
                .inputUserName(faker.funnyName().name())
                .inputPassword(faker.internet()
                        .password(10, 14, true, true))
                .clickToLogin();

        Assert.assertEquals("Invalid username or password!", loginPage.loginError.getText());
        System.out.println("Test passed");

    }

    @Test
    public void invalidSecondLogin() {
        mainPage.openUrl("https://demoqa.com/login");
        loginPage
                .inputUserName(USER_NAME)
                .inputPassword(PASSWORD)
                .clickToLogin();

        loginPage.openUrl("https://demoqa.com/login");
        assertThat("USER_name Input is : ",
                loginPage.isElementPresent(loginPage.userNameInput), is(false));
        System.out.println("Test passed");
    }
}
