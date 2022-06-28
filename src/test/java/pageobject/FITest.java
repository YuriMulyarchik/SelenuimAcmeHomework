package pageobject;

import org.testng.annotations.Test;

import pageobject.flow.LoginPage;

public class FITest extends TestBase{

    @Test
    public void successfulLoginTest() {

        LoginPage loginPage = new LoginPage(driver);


        loginPage
                .loginWithCorrectCreds()
                .assertThatSuccessMessageIsVisible();

    }

    @Test
    public void unsuccessfulLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .loginWithIncorrectCreds()
                .assertThatLoginErrorMessageIsVisible();

    }
}
