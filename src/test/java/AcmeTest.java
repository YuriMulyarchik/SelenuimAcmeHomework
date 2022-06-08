import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class AcmeTest {

    @Test
    public void deliveryInformationLinkTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement deliveryInformationLink = driver.findElement(By.cssSelector(".page-2>a"));
        deliveryInformationLink.click();
        driver.getTitle();
        Assert.assertEquals(driver.getTitle(), "Delivery Information | My Store1");
        driver.quit();

    }

    @Test
    public void termsAndConditionsLinkTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement termsAndConditionsLink = driver.findElement(By.className("page-4"));
        termsAndConditionsLink.click();
        Assert.assertEquals(driver.getTitle(), "Terms & Conditions | My Store1");
        driver.quit();

    }


    @Test
    public void rubberDucksLinkTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        rubberDucksLink.click();
        Assert.assertEquals(driver.getTitle(), "Rubber Ducks | My Store1");
    }

    @Test
    public void saleLabelTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();

        List<WebElement> ducksList = driver.findElements(By.className("name"));
        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<String> sortedNamesList = new ArrayList<>();


        for (WebElement link: ducksList) {
            namesList.add(link.getText());
            sortedNamesList.add(link.getText());

        }

        Collections.sort(sortedNamesList);




        Assert.assertTrue(Objects.equals(namesList, sortedNamesList), "Duck list is not sorted by names!!");






    }

    @Test
    public void nameSortTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();
        WebElement sortByNamesLink = driver.findElement(By.className("category-1"));
        builder.moveToElement(sortByNamesLink).perform();


        List<WebElement> ducksList = driver.findElements(By.className("name"));
        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<String> sortedNamesList = new ArrayList<>();

        for (WebElement link: ducksList) {
            namesList.add(link.getText());
            sortedNamesList.add(link.getText());

        }

        Collections.sort(sortedNamesList);

        Assert.assertTrue(Objects.equals(namesList, sortedNamesList), "Duck list is not sorted by names!!");

    }

    @Test
    public void priceSortTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();

        List<WebElement> ducksList = driver.findElements(By.className("name"));
        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<String> sortedNamesList = new ArrayList<>();

        for (WebElement link: ducksList) {
            namesList.add(link.getText());
            sortedNamesList.add(link.getText());

        }

        Collections.sort(sortedNamesList);

        Assert.assertTrue(Objects.equals(namesList, sortedNamesList), "Duck list is not sorted by names!!");

    }





    @Test
    public void subcategoriesLinkTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();
        Assert.assertEquals(driver.getTitle(), "Subcategory | My Store1");
        driver.quit();

    }

    @Test
    public void homeLinkTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement homeLink = driver.findElement(By.className("general-0"));
        homeLink.click();
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store1");
        WebElement pic = driver.findElement(By.className("rslides1_on"));
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store1");
        driver.quit();

    }

    @Test
    public void discountsLinkTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement homeLink = driver.findElement(By.className("page-5"));
        homeLink.click();
        Assert.assertEquals(driver.getTitle(), "4 | My Store1");
        driver.quit();
    }

}
