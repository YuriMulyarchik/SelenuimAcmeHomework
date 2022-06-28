package pageobject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pageobject.helpers.Locators.getLocator;

public class HomePage extends PageBase{

//    private static By successMessage = By.cssSelector(".notice.success");




    private By homeLink = By.className("general-0");
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean successMessageIsVisible() throws Exception {
        return driver.findElement(getLocator("HomePage.successMessage")).isDisplayed();
    }

    public void homePageEnter() {
        driver.findElement(homeLink).click();
    }

    public void getUrl(String URL) {
        driver.get(URL);
    }

    public boolean hasOpened() {
        return super.hasOpened(driver, "Online Store | My Store1");
    }

}
