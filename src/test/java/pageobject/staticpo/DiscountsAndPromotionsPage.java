package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiscountsAndPromotionsPage {

    private By informationAboutDiscountsAndPromotionsMessage = By.cssSelector("div.middle > div.content");


    private WebDriver driver;


    public DiscountsAndPromotionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean informationAboutPromotionsAndDiscountsMessageIsVisible() {
        return driver.findElement(informationAboutDiscountsAndPromotionsMessage).isDisplayed();
    }

    public String getNoPromotionsAndDiscountsMessageText(){
        String NoPromotionsAndDiscountsMessageText =
                driver.findElement(informationAboutDiscountsAndPromotionsMessage).getText();
        return NoPromotionsAndDiscountsMessageText;
    }

    public boolean verifyNoPromotionsAndDiscountsMessage() {
        String noDiscountsAndPromotionsText = "Скидок пока нет.\n" +
                "Следите за рассылкой по электронной почте";
        return getNoPromotionsAndDiscountsMessageText().equals(noDiscountsAndPromotionsText);
    }

    public String getPageTitle(){
        String title = driver.getTitle();
        return title;
    }
    public boolean verifyDiscountsAndPromotionsPageTitle() {
        String expectedPageTitle="4 | My Store1";
        return getPageTitle().equals(expectedPageTitle);
    }

}



