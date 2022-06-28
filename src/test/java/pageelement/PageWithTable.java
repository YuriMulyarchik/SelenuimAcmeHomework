package pageelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageWithTable {
    public Table table1;
    public Table table2;

    private By table1Locator = By.id("table1");
    private By table2Locator = By.id("table2");

    private WebDriver driver;
    public PageWithTable(WebDriver driver) {
        this.driver = driver;
        table1 = new Table(driver.findElement(table1Locator));
        table2 = new Table(driver.findElement(table2Locator));
    }
}
