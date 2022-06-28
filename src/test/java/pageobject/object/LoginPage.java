package pageobject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class LoginPage extends PageBase {
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");

    private By logoutButton = By.cssSelector("#box-account > div > ul > li:nth-child(4) > a");
    private By errorMessage = By.cssSelector(".notice.errors");


    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void attemptLogin(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public boolean loginErrorMessageIsVisible() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean logoutButtonIsVisible() {

            return driver.findElement(logoutButton).isDisplayed();
     }

    public boolean hasOpened() {
        return super.hasOpened(driver, "Online Store | My Store1");
    }


}
