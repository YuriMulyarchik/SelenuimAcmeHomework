package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
//        Browsers browser = Browsers.valueOf(System.getProperty("chrome","chrome"));
//        switch (browser) {
//            case chrome: new ChromeDriver();break;
//            case firefox: new FirefoxDriver();break;
//            case opera: new OperaDriver();break;
//        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
