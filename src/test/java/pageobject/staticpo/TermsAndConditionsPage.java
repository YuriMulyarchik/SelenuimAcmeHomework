package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsAndConditionsPage {
    private By subtitleOne = By.cssSelector("div.content > h1");

    private By subtitleOneInformation = By.cssSelector("p:nth-child(2) > font");
    private By subtitleTwo = By.cssSelector("div.content > h2");

    private By subtitleTwoInformation = By.cssSelector("p:nth-child(4) > font");

    private By subtitleThree = By.cssSelector("div.content > h3");

    private By subtitleThreeInformation = By.cssSelector("p:nth-child(6) > font");

    private WebDriver driver;


    public TermsAndConditionsPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean subtitleOneIsVisible() {
        return driver.findElement(subtitleOne).isDisplayed();
    }
    public boolean subtitleTwoIsVisible() {
        return driver.findElement(subtitleTwo).isDisplayed();
    }
    public boolean subtitleThreeIsVisible() {
        return driver.findElement(subtitleThree).isDisplayed();
    }

    public boolean subtitleOneInformationIsVisible() {
        return driver.findElement(subtitleOneInformation).isDisplayed();
    }
    public boolean subtitleTwoInformationIsVisible() {
        return driver.findElement(subtitleTwoInformation).isDisplayed();
    }
    public boolean subtitleThreeInformationIsVisible() {
        return driver.findElement(subtitleThreeInformation).isDisplayed();
    }

    public String getSubtitleOneText(){
        String subtitleOneText =
                driver.findElement(subtitleOne).getText();
        return subtitleOneText;
    }

    public boolean verifySubtitleOneText() {
        String subtitleOneText = "Условия";
        return getSubtitleOneText().equals(subtitleOneText);
    }

    public String getSubtitleTwoText(){
        String subtitleTwoText =
                driver.findElement(subtitleTwo).getText();
        return subtitleTwoText;
    }

    public boolean verifySubtitleTwoText() {
        String subtitleTwoText = "Подзаголовок 2";
        return getSubtitleTwoText().equals(subtitleTwoText);
    }

    public String getSubtitleThreeText(){
        String subtitleThreeText =
                driver.findElement(subtitleThree).getText();
        return subtitleThreeText;
    }

    public boolean verifySubtitleThreeText() {
        String subtitleThreeText = "Подзаголовок 3";
        return getSubtitleThreeText().equals(subtitleThreeText);
    }

    public String getPageTitle(){
        String title = driver.getTitle();
        return title;
    }
    public boolean verifyTermsAndConditionsPageTitle() {
        String expectedPageTitle="Terms & Conditions | My Store1";
        return getPageTitle().equals(expectedPageTitle);
    }
}
