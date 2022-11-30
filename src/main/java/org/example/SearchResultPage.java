package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends Utils {
    private By _productTitles = By.cssSelector("h2.product-title");

    public void navigateToSearchResultPageAndVerifyReslutShowsAccordingly() {
        waitForUrlToBe("https://demo.nopcommerce.com/search?q=Nike", 20);
        Assert.assertTrue(driver.getCurrentUrl().contains("search?q="),
                "User is not on search result page");
        List<WebElement> productTitles = driver.findElements(_productTitles);
        List<String> productTitlesList = new ArrayList<>();
        boolean containsSearchStr = productTitlesList.stream().anyMatch("search_value"::equalsIgnoreCase);

        for (WebElement element : productTitles) {
//            System.out.println(element.getText());
            Assert.assertTrue(element.getText().contains(LoadProperty.getProperty("SearchText")));
        }
    }
}
