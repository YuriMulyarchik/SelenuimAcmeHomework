package pageobject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;


public class RubberDucksPage {

    private By goods = By.cssSelector(".link[title*='Duc']");
    private By subcategoryLink = By.cssSelector(".link[title='Subcategory']");
    private By unnamedLink = By.cssSelector(".categories > li:nth-child(1) > a");
    private By ducksPrices = By.cssSelector(".price-wrapper > :not(s)");
    private By ducksNames = By.className("name");

    private WebDriver driver;


    public RubberDucksPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getPageTitle(){
        String title = driver.getTitle();
        return title;
    }
    public boolean verifyRubberDucksPageTitle() {
        String expectedPageTitle="Rubber Ducks | My Store1";
        return getPageTitle().contains(expectedPageTitle);
    }

    public boolean verifyRubberDucksPageContainsGoods() {
        List<WebElement> ducksPricesList = driver.findElements(goods);

        if (!ducksPricesList.isEmpty()) {
         return true;   
        } else return false;
    }

    public void goToSubcategoryPage() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.className("category-1"))).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();
    }



}
