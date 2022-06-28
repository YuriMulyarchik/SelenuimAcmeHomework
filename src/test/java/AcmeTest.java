import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import org.testng.annotations.*;
import pageobject.object.HomePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class AcmeTest {
    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    @BeforeMethod
    public void beforeTest() {
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }


    @Test
    public void deliveryInformationLinkTest() {

//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
        WebElement deliveryInformationLink = driver.findElement(By.cssSelector(".page-2>a"));
        deliveryInformationLink.click();
        driver.getTitle();
        Assert.assertEquals(driver.getTitle(), "Delivery Information | My Store1");
//        driver.quit();
    }


    @Test
    public void homeLinkTest() {

        homePage.getUrl("https://litecart.stqa.ru/en/");
        homePage.homePageEnter();
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store1");
//        driver.quit();
    }

    @Test
    public void termsAndConditionsLinkTest() {

//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
        WebElement termsAndConditionsLink = driver.findElement(By.className("page-4"));
        termsAndConditionsLink.click();
        Assert.assertEquals(driver.getTitle(), "Terms & Conditions | My Store1");
//        driver.quit();
    }


    @Test
    public void rubberDucksLinkTest() {

//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        rubberDucksLink.click();
        Assert.assertEquals(driver.getTitle(), "Rubber Ducks | My Store1");
//        driver.quit();
    }

    @Test
    public void subcategoriesLinkTest() {

//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();
        Assert.assertEquals(driver.getTitle(), "Subcategory | My Store1");
//        driver.quit();
    }

    @Test
    public void discountsLinkTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
        WebElement homeLink = driver.findElement(By.className("page-5"));
        homeLink.click();
        Assert.assertEquals(driver.getTitle(), "4 | My Store1");
//        driver.quit();
    }

    @Test
    public void saleStickerTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();

        WebElement yellowDuckLink = driver.findElement(By.cssSelector(".link[title='Yellow Duck']"));
        WebElement stickerLink = yellowDuckLink.findElement(By.cssSelector("[title='On Sale']"));

        boolean correctSticker;

        if (yellowDuckLink.getAttribute("title").equals("Yellow Duck") && stickerLink.getText().equals("SALE")) {
            correctSticker = true;
        } else {correctSticker = false;}

        Assert.assertTrue(correctSticker, "Yellow duck has an incorrect title");
//        driver.quit();
    }
    @Test
    public void newStickerTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();

        WebElement greenDuckLink = driver.findElement(By.cssSelector(".link[title='Green DucK']"));
        WebElement stickerLink = greenDuckLink.findElement(By.cssSelector(".sticker.new"));

        boolean correctSticker;

        if (greenDuckLink.getAttribute("title").equals("Green DucK") && stickerLink.getText().equals("NEW")) {
            correctSticker = true;
        } else {correctSticker = false;}

        Assert.assertTrue(correctSticker, "Green duck has an incorrect title");
//        driver.quit();
    }

    @Test
    public void nameSortTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();
        WebElement sortByNamesLink = driver.findElement(By.linkText("Name"));
        sortByNamesLink.click();


        List<WebElement> ducksList = driver.findElements(By.className("name"));

        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<String> sortedNamesList = new ArrayList<>();

        for (WebElement link: ducksList) {
            namesList.add(link.getText());
            sortedNamesList.add(link.getText());
        }

        Collections.sort(sortedNamesList);
        Assert.assertTrue(Objects.equals(namesList, sortedNamesList), "Duck list is not sorted by names!!");
//        driver.quit();

    }

    @Test
    public void priceSortTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();
        List<WebElement> ducksPricesList = driver.findElements(By.cssSelector(".price-wrapper > :not(s)"));

        ArrayList<String> pricesListInString = new ArrayList<>();

        for (WebElement link: ducksPricesList) {
            pricesListInString.add(link.getText());
        }

        ArrayList<Float> pricesListInFloat = new ArrayList<>();
        ArrayList<Float> sortedPricesListInFloat = new ArrayList<>();


        for (int i = 0; i < pricesListInString.size(); i++ ) {
            pricesListInFloat.add(Float.parseFloat(pricesListInString.get(i).replaceAll("[^\\d.]",
                    "")));
            sortedPricesListInFloat.add(Float.parseFloat(pricesListInString.get(i).replaceAll("[^\\d.]",
                    "")));
        }


       Collections.sort(sortedPricesListInFloat);
       Assert.assertTrue(Objects.equals(pricesListInFloat, sortedPricesListInFloat), "Prices " +
               "list is not sorted by price!!");
       driver.quit();

    }

}
