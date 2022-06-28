package pageelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TableTest {
    @Test
    public void tableTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
        PageWithTable pageWithTable = new PageWithTable(driver);
        int rows = pageWithTable.table1.getRowsCount();
        int colums = pageWithTable.table1.getColumnsCount();

        String textIn33 = pageWithTable.table1.getCell(3,3).getText();

        int rows2 = pageWithTable.table2.getRowsCount();
        int colums2 = pageWithTable.table2.getColumnsCount();

        String textIn332 = pageWithTable.table2.getCell(3,3).getText();
    }
}
