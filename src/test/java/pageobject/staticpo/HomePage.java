package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private static By successMessage = By.cssSelector(".notice.success");


    private static By homeLink = By.className("general-0");


    public static boolean successMessageIsVisible(WebDriver driver) {
        return driver.findElement(successMessage).isDisplayed();
    }


}
