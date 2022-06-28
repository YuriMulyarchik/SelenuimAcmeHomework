package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class SubcategoriesPage {

    private By sortByNamesButton = By.xpath("//*[@id='box-category']/nav/*[1]");

    private By sortByPriceButton = By.xpath("//*[@id='box-category']/nav/*[2]");

    private By yellowDuckLink = By.cssSelector(".link[title='Yellow Duck']");

    private By greenDuckLink = By.cssSelector(".link[title='Green DucK']");

    private By saleStickerLink = By.cssSelector("[title='On Sale']");

    private By newStickerLink = By.cssSelector(".sticker.new");

    private By  prices = By.cssSelector(".price-wrapper > :not(s)");


    private WebDriver driver;

    public SubcategoriesPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickSortByNamesButton() {
        driver.findElement(sortByNamesButton).click();
    }

    public void clickSortByPriceButton() {
        driver.findElement(sortByPriceButton).click();
    }

    public boolean verifyDuckSticker(String title, String expectedSticker) {


        WebElement DuckLink = driver.findElement(By.cssSelector(".link[title='"+title+"']"));
        WebElement StickerLink = driver.findElement(By.xpath("//a[@class='link' and @title='"+title+"']/div/div"));
        System.out.println(StickerLink.getText());
        System.out.println(DuckLink.getAttribute("title"));
        if (DuckLink.getAttribute("title").equals(title) && StickerLink.getText().equals(expectedSticker)) {
            return true;
        } else return false;
    }

    public boolean verifyYellowDuckSticker() {


        WebElement DuckLink = driver.findElement(yellowDuckLink);
        WebElement StickerLink = driver.findElement(saleStickerLink);
        if (DuckLink.getAttribute("title").equals("Yellow Duck") && StickerLink.getText().equals("SALE")) {
            return true;
        } else return false;
    }

    public boolean verifyGreenDuckSticker() {


        WebElement DuckLink = driver.findElement(greenDuckLink);
        WebElement StickerLink = driver.findElement(newStickerLink);
        if (DuckLink.getAttribute("title").equals("Green DucK") && StickerLink.getText().equals("NEW")) {
            return true;
        } else return false;
    }


    public boolean sortByNames() {

        WebElement sortByNamesLink = driver.findElement(sortByNamesButton);
        sortByNamesLink.click();


        List<WebElement> ducksList = driver.findElements(By.className("name"));

        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<String> sortedNamesList = new ArrayList<>();

        for (WebElement link: ducksList) {
            namesList.add(link.getText());
            sortedNamesList.add(link.getText());
        }

        Collections.sort(sortedNamesList);
        if (Objects.equals(namesList, sortedNamesList)) {
            return true;
        } else return false;

    }

    public boolean sortByPrices() {

        List<WebElement> ducksPricesList = driver.findElements(prices);

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

        if (Objects.equals(pricesListInFloat, sortedPricesListInFloat)) {
            return true;
        } else return false;


    }


}


