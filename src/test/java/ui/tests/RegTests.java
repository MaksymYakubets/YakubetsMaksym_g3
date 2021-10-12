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

import static org.hamcrest.CoreMatchers.is;

public class RegTests extends Base6Test {
    Faker faker = new Faker();

    private final String USER_NAME = "QA_AUTO";
    private final String PASSWORD = "Lesson(#6)";

    @Test
    public void validLogin1Test() {
        mainPage.openUrl("https://demoqa.com/login");
        loginPage
                .inputUserName(USER_NAME)
                .inputPassword(PASSWORD)
                .clickToLogin();
        Assert.assertEquals(USER_NAME, loginPage.checkUserName());
        System.out.println("Test passed");
    }

    @Test
    public void validLogin2Test() {
        mainPage.openUrl("https://demoqa.com/login");
        loginPage
                .inputUserName(USER_NAME)
                .inputPassword(PASSWORD)
                .clickToLogin();
        Assert.assertThat("Button is displayed in Page: ",
                myProfile.logoutButton.isDisplayed(), is(true));
        Assert.assertEquals("Log out", myProfile.buttonText(myProfile.logoutButton));
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
}
