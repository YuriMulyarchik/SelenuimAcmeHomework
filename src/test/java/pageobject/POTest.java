package pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobject.helpers.Locators;
import pageobject.object.*;



public class POTest extends TestBase{



    @Test
    public void successfulLoginTest() throws Exception {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.attemptLogin("ttttt@mail.ru", "123456");

        Assert.assertTrue(homePage.successMessageIsVisible(), "Login was unsuccessful");

    }

    @Test
    public void unsuccessfulLoginTest() throws Exception {



        LoginPage loginPage = new LoginPage(driver);

        loginPage.attemptLogin("ttttt@mail.ru", "123");

        Assert.assertTrue(loginPage.loginErrorMessageIsVisible(), "Logged in with incorrect creds");

    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);


        loginPage.attemptLogin("ttttt@mail.ru", "123456");
        loginPage.clickLogoutButton();

        Assert.assertTrue(loginPage.logoutButtonIsVisible(), "Logout is incorrect");

    }

    @Test
    public void discountsAndPromotionsPageLinkTest() {

        driver.findElement(By.className("page-5")).click();

        DiscountsAndPromotionsPage discountsAndPromotionsPage = new DiscountsAndPromotionsPage(driver);
        Assert.assertTrue(discountsAndPromotionsPage.verifyDiscountsAndPromotionsPageTitle(),
                "PromotionsAndDiscountsPage has an incorrect title");
        driver.quit();
    }

    @Test
    public void discountsAndPromotionsPageInformationVisibilityTest() {

        driver.findElement(By.className("page-5")).click();

        DiscountsAndPromotionsPage discountsAndPromotionsPage = new DiscountsAndPromotionsPage(driver);

        Assert.assertTrue(discountsAndPromotionsPage.informationAboutPromotionsAndDiscountsMessageIsVisible(),
                "informationAboutPromotionsAndDiscountsMessage is invisible");

    }


    @Test
    public void discountsAndPromotionsPageNoPromotionsTextTest() {

        driver.findElement(By.className("page-5")).click();

        DiscountsAndPromotionsPage discountsAndPromotionsPage = new DiscountsAndPromotionsPage(driver);

        Assert.assertTrue(discountsAndPromotionsPage.verifyNoPromotionsAndDiscountsMessage(),
                "DiscountsAndPromotionsPageNoPromotions text is incorrect");

    }

    @Test
    public void termsAndConditionsPageLinkTest() {

        driver.findElement(By.className("page-4")).click();

        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(driver);
        Assert.assertTrue(termsAndConditionsPage.verifyTermsAndConditionsPageTitle(),
                "TermsAndConditionsPage has an incorrect title");

    }

    @Test
    public void termsAndConditionsPageSubtitlesVisibilityTest() {

        driver.findElement(By.className("page-4")).click();

        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(termsAndConditionsPage.subtitleOneIsVisible(), "subtitle one is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleTwoIsVisible(), "subtitle two is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleThreeIsVisible(),"subtitle three is invisible");
        softAssert.assertAll();

    }

    @Test
    public void termsAndConditionsPageSubtitlesInformationVisibilityTest() {

        driver.findElement(By.className("page-4")).click();
        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(termsAndConditionsPage.subtitleOneInformationIsVisible(), "subtitle one is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleTwoInformationIsVisible(), "subtitle two is invisible");
        softAssert.assertTrue(termsAndConditionsPage.subtitleThreeInformationIsVisible(),"subtitle three is invisible");
        softAssert.assertAll();

    }

    @Test
    public void termsAndConditionsPageSubtitlesVerifySubtitlesTextTest() {

        driver.findElement(By.className("page-4")).click();
        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(termsAndConditionsPage.verifySubtitleOneText(), "subtitle one text is incorrect");
        softAssert.assertTrue(termsAndConditionsPage.verifySubtitleTwoText(), "subtitle two text is incorrect");
        softAssert.assertTrue(termsAndConditionsPage.verifySubtitleThreeText(),"subtitle three text is incorrect");
        softAssert.assertAll();

    }

    @Test
    public void deliveryInformationPageLinkTest() {

        driver.findElement(By.cssSelector(".page-2>a")).click();

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(driver);

        Assert.assertTrue(deliveryInformationPage.verifyDeliveryInformationPageTitle(),
                "DeliveryInformationPage has an incorrect title");

    }

    @Test
    public void deliveryInformationPageSubtitlesVisibilityTest() {

        driver.findElement(By.cssSelector(".page-2>a")).click();

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(deliveryInformationPage.subtitleOneIsVisible(), "subtitle one is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleTwoIsVisible(), "subtitle two is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleThreeIsVisible(),"subtitle three is invisible");
        softAssert.assertAll();

    }

    @Test
    public void deliveryInformationPageSubtitlesInformationVisibilityTest() {

        driver.findElement(By.cssSelector(".page-2>a")).click();

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(deliveryInformationPage.subtitleOneInformationIsVisible(), "subtitle one is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleTwoInformationIsVisible(), "subtitle two is invisible");
        softAssert.assertTrue(deliveryInformationPage.subtitleThreeInformationIsVisible(),"subtitle three is invisible");
        softAssert.assertAll();

    }

    @Test
    public void deliveryInformationPageVerifySubtitlesTextTest() {

        driver.findElement(By.cssSelector(".page-2>a")).click();

        DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(deliveryInformationPage.verifySubtitleOneText(), "subtitle one text is incorrect");
        softAssert.assertTrue(deliveryInformationPage.verifySubtitleTwoText(), "subtitle two text is incorrect");
        softAssert.assertTrue(deliveryInformationPage.verifySubtitleThreeText(),"subtitle three text is incorrect");
        softAssert.assertAll();

    }

    @Test
    public void rubberDucksPageLinkTest() {

        driver.findElement(By.className("category-1")).click();
        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);

        Assert.assertTrue(rubberDucksPage.verifyRubberDucksPageTitle(),
                "DeliveryInformationPage has an incorrect title");

    }

    @Test
    public void rubberDucksPageContainsGoodsTest() {

        driver.findElement(By.className("category-1")).click();
        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);
        Assert.assertTrue(rubberDucksPage.verifyRubberDucksPageContainsGoods(), "RubberDucksPageContains hasn't" +
                "goods");

    }


    @Test
    public void rubberDucksPageSubcategoriesLinkTest() {

        driver.findElement(By.className("category-1")).click();
        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);
        rubberDucksPage.goToSubcategoryPage();
        Assert.assertEquals(driver.getTitle(), "Subcategory | My Store1");

    }

    @Test
    public void rubberDucksPageSubcategoriesSortingByNamesTest() {

        driver.findElement(By.className("category-1")).click();
        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);
        rubberDucksPage.goToSubcategoryPage();

    }

//    @Test
//    public void VtegorTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
//        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
//        Actions builder = new Actions(driver);
//        builder.moveToElement(rubberDucksLink).perform();
//        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
//        subcategoriesLink.click();
//
//        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(driver);
//
//        SoftAssert softAssert = new SoftAssert();
//
//        softAssert.assertTrue(subcategoriesPage.verifyDuckSticker("Green DucK","NEW"),"Green Duck " +
//                "has an incorrect sticker");
//        softAssert.assertTrue(subcategoriesPage.verifyDuckSticker("Yellow Duck","SALE"),"Yellow Duck" +
//                "has an incorrect sticker");
//        softAssert.assertAll();
//        driver.quit();
//
//    }

    @Test
    public void yellowDuckSaleStickerTest() {

        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(driver);

        subcategoriesPage.verifyYellowDuckSticker();
        Assert.assertTrue(subcategoriesPage.verifyYellowDuckSticker(), "Yellow Duck has an incorrect sticker");

    }

    @Test
    public void greenDuckSaleStickerTest() {

        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(driver);

        Assert.assertTrue(subcategoriesPage.verifyGreenDuckSticker(), "Green Duck has an incorrect sticker");

    }

    @Test
    public void sortingByNamesTest() {

        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(driver);

        subcategoriesPage.clickSortByNamesButton();
        Assert.assertTrue(subcategoriesPage.sortByNames(), "Duck list is not sorted by names!!");

    }

    @Test
    public void sortingByPricesTest() {

        WebElement rubberDucksLink = driver.findElement(By.className("category-1"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoriesLink = driver.findElement(By.className("category-2"));
        subcategoriesLink.click();

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(driver);
        subcategoriesPage.clickSortByPriceButton();

        Assert.assertTrue(subcategoriesPage.sortByPrices(), "Duck list is not sorted by prices!!");

    }

    @Test
    public void homePageLoadedTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.attemptLogin("ttttt@mail.ru","123456");
        Assert.assertTrue(homePage.hasOpened(),"Home page isn't opened");
    }




}
