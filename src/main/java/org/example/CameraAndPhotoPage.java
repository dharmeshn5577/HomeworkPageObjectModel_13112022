package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CameraAndPhotoPage extends Utils {

    private By _productTitles = By.xpath("//h2[@class=\"product-title\"]");
    private By _addToCartButton = By.xpath("//div[@class=\\\"item-box\\\"]//button[contains(@class, 'add-to-cart')]");
    public void getTitlesOfAllListedProducts() {
        waitForUrlToBe("https://demo.nopcommerce.com/camera-photo", 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("camera-photo"), "User is not on camera and photo page");

        List<WebElement> productTitles = driver.findElements(_productTitles);
        System.out.println("Total listed products: " + productTitles.size());
        for (WebElement element : productTitles) {
            System.out.println(element.getText());
        }
    }

    public void verifyAllProductsHaveAddToCartButton() {
        waitForUrlToBe("https://demo.nopcommerce.com/camera-photo", 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("camera-photo"), "User is not on camera and photo page");
        ArrayList<WebElement> addToCartButton = new ArrayList<WebElement>();
        List<WebElement> buttons = driver.findElements(By.className("buttons"));
        System.out.println("Total listed products: " + buttons.size());

        for (WebElement element : buttons) {
            System.out.println(element.getText());

            Iterator iterator = addToCartButton.iterator();
            while (iterator.hasNext()){
                SoftAssert softAssert = new SoftAssert();
                softAssert.assertTrue(element.getText().contains("ADD TO CART") , ""+getTextFromElement(_productTitles) + "This item does not have add to cart button");

            }
        }
    }
}
