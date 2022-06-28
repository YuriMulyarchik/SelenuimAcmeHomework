package pageobject;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.pagefactory.HomePage;
import pageobject.pagefactory.LoginPage;

public class PFTest extends TestBase{
    @Test
    public void successfulLoginTest() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        loginPage.attemptLogin("ttttt@mail.ru", "123456");

        Assert.assertTrue(homePage.successMessageIsVisible(), "Login was unsuccessful");

    }

    @Test
    public void unsuccessfulLoginTest() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.attemptLogin("ttttt@mail.ru", "123");

        Assert.assertTrue(loginPage.loginErrorMessageIsVisible(), "loginErrorMessage is invisible");

    }
}
