package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchResultPage extends Utils {
    private By _productTitles = By.cssSelector("h2.product-title");
    private By _noResult = By.cssSelector("div.no-result");

    public void navigateToSearchResultPageAndVerifyReslutShowsAccordingly() {
//        String searchResultPageUrl = "https://demo.nopcommerce.com/search?q=" + LoadProperty.getProperty("SearchText");
        waitForUrlToBe("https://demo.nopcommerce.com/search?q=" + LoadProp.getProperty("SearchText"), 20);
//        String searchResultPageUrlContains = "search?q=" + LoadProperty.getProperty("SearchText");
        Assert.assertTrue(driver.getCurrentUrl().contains("search?q=" + LoadProp.getProperty("SearchText")),
                "User is not on search result page");

//        boolean noItemsPresent;

            boolean noResultMsg = driver.findElement(_noResult).isDisplayed();
            if (noResultMsg){
            System.out.println(driver.findElement(_noResult).getText());
        } else {
        waitForElementToBeVisible(_productTitles, 10);
        List<WebElement> productTitles = driver.findElements(_productTitles);
            for (WebElement element : productTitles) {
//            System.out.println(element.getText());
                Assert.assertTrue(element.getText().contains(LoadProp.getProperty("SearchText")),
                        "Please start your search keyword with CAPITAL letter.");
            }
        }
    }
}