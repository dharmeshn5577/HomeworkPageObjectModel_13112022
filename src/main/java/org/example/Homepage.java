package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Homepage extends Utils {

    // created variable of inbuilt class By and make it private to limit the access to in this class only
    private By _registerButton = By.className("ico-register");
    private By _electronicsCategory = By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/electronics\"]");
    private By _selectCurrency = By.id("customerCurrency");
    private By _voteButton = By.id("vote-poll-1");
    private By _facebook = By.xpath("//a[contains(@href, 'facebook')]");
    private By _appleMacBookPro13Inch = By.xpath("//div[@class=\"picture\"]/a[contains(@href, 'apple')]");
   private By _detailsNewRelease = By.xpath("//a[contains(@href, \"release\") and contains(@class, \"read\")]");

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
}
