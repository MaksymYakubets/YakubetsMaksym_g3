package ui.tests;

import baseTest.Base6Test;
import baseTest.BaseTest;
import com.github.javafaker.Faker;
import libs.WebElements;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.prog.kiev.Wait;
import ui.pages.LoginPage;

import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;

public class RegTests extends Base6Test {
    Faker faker = new Faker();

    private final String USER_NAME = "QA_AUTO";
    private final String PASSWORD = "Lesson(#6)";

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

        Assert.assertThat("Button is displayed in Page: ",
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
        Assert.assertThat("USER_name Input is : ",
                loginPage.isElementPresent(loginPage.userNameInput), is(false));
        System.out.println("Test passed");
    }
}
