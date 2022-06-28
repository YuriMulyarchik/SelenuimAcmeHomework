package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.staticpo.HomePage;
import pageobject.staticpo.LoginPage;

public class SPOTest {
    @Test
    public static void successfulLoginTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");

        LoginPage.attemptLogin(driver,"ttttt@mail.ru", "123456");

        Assert.assertTrue(HomePage.successMessageIsVisible(driver), "Login was unsuccessful");
        driver.quit();

    }

    @Test
    public static void unsuccessfulLoginTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");

        LoginPage.attemptLogin(driver,"ttttt@mail.ru", "123");

        Assert.assertTrue(LoginPage.loginErrorMessageIsVisible(driver), "loginErrorMessage is invisible");
        driver.quit();

    }
}
