package pageobject.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    private By successMessage = By.cssSelector(".notice.success");


    private By homeLink = By.className("general-0");
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage assertThatSuccessMessageIsVisible() {
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed(), "Login was unsuccessful");

        return this;
    }
//
//    public void homePageEnter() {
//        driver.findElement(homeLink).click();
//    }
//
//    public void getUrl(String URL) {
//        driver.get(URL);
//    }

}
