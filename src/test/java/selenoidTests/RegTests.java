package selenoidTests;

import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Listeners({ScreenShooter.class, TextReport.class})
@Report
public class RegTests extends BaseSelenoidTests {
    Faker faker = new Faker();

    private final String USER_NAME = "QA_AUTO";
    private final String PASSWORD = "Lesson(#6)";

    @Test
    public void validLoginTest() {
 //       mainPage.openUrl("https://demoqa.com/login");
        loginPage
                .inputUserName(USER_NAME)
                .inputPassword(PASSWORD)
                .clickToLogin();
        Assert.assertEquals(USER_NAME, loginPage.checkUserName());
    }

    @Step("Invalid Fake Login test")
    @Test
    public void invalidFakeLogin() {
  //      mainPage.openUrl("https://demoqa.com/login");
        loginPage
                .inputUserName(faker.funnyName().name())
                .inputPassword(faker.internet()
                        .password(10, 14, true, true))
                .clickToLogin();

        Assert.assertEquals("Invalid username or password!", loginPage.loginError.getText());
        String result = loginPage.loginError.getText();
        System.out.println("Test passed");

    }

    @Ignore
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

    @Ignore
    @Test
    public void validLoginLogoutTest() {
        mainPage.openUrl("https://demoqa.com/login");
        loginPage
                .inputUserName(USER_NAME)
                .inputPassword(PASSWORD)
                .clickToLogin();
        ua.prog.kiev.Wait.sleep(5000);
        myProfile.clickLogout();
        Assert.assertEquals("Welcome,Login in Book Store", loginPage.getWelcomeText());
        System.out.println("Test passed");

    }

    @Ignore
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
