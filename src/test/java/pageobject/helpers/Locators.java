package pageobject.helpers;

import org.openqa.selenium.By;

import java.io.InputStream;
import java.util.Properties;
import java.io.IOException;

public class Locators {
    private static Properties locators;
    static {
        locators = new Properties();
//        InputStream is = Locators.class.getResourceAsStream("/locators.properties");

        InputStream is = Locators.class.getResourceAsStream("E:\\GitHub\\SelenuimHomework\\src\\test\\java\\resources\\locators.properties");

        try {
            locators.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Could not read from locators.properties file\n" + e.getMessage());
        }
    }
    public static By getLocator(String element) throws Exception {
        String locator = locators.getProperty(element);
        String[] substrings = locator.split("=", 2);
        LocatorTypes locatorType = LocatorTypes.valueOf(substrings[0]);
        String selector = substrings[1];
        switch (locatorType) {
            case id:
                return By.id(selector);
            case css:
                return By.cssSelector(selector);
            case xpath:
                return By.xpath(selector);
            case name:
                return By.name(selector);
            default:
                throw new Exception("No such locator type");

        }
    }

}
