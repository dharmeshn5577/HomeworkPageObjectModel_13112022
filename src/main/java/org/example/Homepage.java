package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Homepage extends Utils {

    // created variable of inbuilt class By and make it private to limit
    // the access to in this class only
    private By _registerButton = By.className("ico-register");
    private By _electronicsCategory = By.xpath(
            "//ul[@class=\"top-menu notmobile\"]//a[@href=\"/electronics\"]");
    private By _selectCurrency = By.id("customerCurrency");
    private By _voteButton = By.id("vote-poll-1");
    private By _facebook = By.xpath("//a[contains(@href, 'facebook')]");
    private By _appleMacBookPro13Inch = By.xpath(
            "//div[@class=\"picture\"]/a[contains(@href, 'apple')]");
    private By _detailsNewRelease = By.xpath(
            "//a[contains(@href, \"release\") and contains(@class, \"read\")]");
    private By _computersCategory = By.cssSelector("ul.top-menu.notmobile a[href=\"/computers\"]");
    private By _desktopsSubCategory = By.cssSelector("ul.top-menu.notmobile a[href=\"/desktops\"]");
    private By _searchBoxField = By.cssSelector("input[type=text]");
    private By _searchButton = By.cssSelector("button[type=submit]");
    FacebookPage facebookPage = new FacebookPage();

    public void clickOnRegistrationButton() {
        clickOnElement(_registerButton);
    }

    public void clickOnElectronicsCategory() {
        clickOnElement(_electronicsCategory);
    }

    public void verifyAllProductsHaveUSDollarCurrencySymbolWhenUSDollarSelected() {
        selectFromDropDownList_ByVisibleText(_selectCurrency, "US Dollar");
        List<WebElement> productsPrice = driver.findElements(By.xpath("//span[@class=\"price actual-price\"]"));
//        System.out.println("Total listed products: " + productsPrice.size());
        for (WebElement element : productsPrice) {
//            System.out.println(element.getText());
            Assert.assertTrue(element.getText().contains("$"));
        }
    }
        public void verifyAllProductsHaveEuroCurrencySymbolWhenEuroSelected() {
            selectFromDropDownList_ByVisibleText(_selectCurrency, "Euro");
            List<WebElement> productsPrice = driver.findElements(By.xpath("//span[@class=\"price actual-price\"]"));
            for (WebElement element : productsPrice) {
                Assert.assertTrue(element.getText().contains("€"));
            }
    }

    public void verifyAlertPopUpForVoteButton(){
        clickOnElement(_voteButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        if(wait.until(ExpectedConditions.alertIsPresent())==null)
            System.out.println("Alert is not pop up.");
        else {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    public void userShouldNavigateToFacebookPage(){
        //Click on facebook icon
        clickOnElement(_facebook);
        //To handle multiple tabs used method getWindowHandles, and return type is String, so Using Set fix the return type
        Set<String> windows = driver.getWindowHandles();
        // To jump from one to another tab used Iterator inbuilt class in selenium, and return type is String
        Iterator<String> iterator = windows.iterator();
        // To switch between parent and child tabs used next() method
        String parent = iterator.next();
        String child = iterator.next();
        // To go on particular tab used switchTo() inbuilt class in selenium
        driver.switchTo().window(child);
        //Click on cookies allowance button
        facebookPage.userClickOnCookiesPreferenceButton();
        //Close current open facebook tab
        driver.close();
        //Switch to main tab
        driver.switchTo().window(parent);
    }

    public void navigateToAppleMacBookPro13InchProductPage(){
        clickOnElement(_appleMacBookPro13Inch);
    }

    public void navigateToNewReleasePage(){
        clickOnElement(_detailsNewRelease);
    }

    public void navigateToDesktopsSubCategoryPage(){
        moveToElement(_computersCategory);
        waitForElementToBeVisible(_desktopsSubCategory, 5);
        moveToElementAndClick(_desktopsSubCategory);
    }

    public void captureAndVerifyTextColorIsChangesAfterHover(){
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(_computersCategory);
        // Created a hover action using the Actions object
        Action mouseHoverOnElement = builder.moveToElement(element).build();

        String expectedBeforeHoverCategoryTextColor_hex = LoadProperty.getProperty
                ("BeforeHoverCategoryTextColor_hex");
        // Capture desired CSS key value before performing action
        String beforeHoverCSSKeyValue = element.getCssValue("color");
//      System.out.println(beforeHoverCSSKeyValue);
        // Convert color's rgba value into hex value
        String actualBeforeHoverCSSKeyValue_hex = Color.fromString(beforeHoverCSSKeyValue).asHex();
        Assert.assertEquals(actualBeforeHoverCSSKeyValue_hex, expectedBeforeHoverCategoryTextColor_hex,
                "Before mouse hover category text color is not as expected");
        System.out.println("Before Hover Color: " +actualBeforeHoverCSSKeyValue_hex);

        // Used the inbuilt perform() method to execute the Action tasks
        mouseHoverOnElement.perform();

        String expectedAfterHoverCategoryTextColor_hex = LoadProperty.getProperty
                ("AfterHoverCategoryTextColor_hex");
        // Capture desired CSS key value after performing action
        String afterHoverCSSKeyValue = element.getCssValue("color");
//      System.out.println(afterHoverCSSKeyValue);
        String actualAfterHoverCSSKeyValue_hex = Color.fromString(afterHoverCSSKeyValue).asHex();
        Assert.assertEquals(actualAfterHoverCSSKeyValue_hex, expectedAfterHoverCategoryTextColor_hex,
                "After mouse hover category text color is not as expected");
        System.out.println("After Hover Color: " +actualAfterHoverCSSKeyValue_hex);
        Assert.assertNotEquals(actualBeforeHoverCSSKeyValue_hex, actualAfterHoverCSSKeyValue_hex,
                "Text color is not changed after mouse hover");

    }

    public void verifyUserShouldAbleToSearch(){
        moveToElementAndClick(_searchBoxField);
        moveToElementAndTypeText(_searchBoxField, LoadProperty.getProperty("SearchText"));
        waitForElementToBeClickable(_searchBoxField, 10);
        moveToElementAndClick(_searchButton);
    }
}
