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
    private By _itemBoxesfield = By.className("product-item");

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
        Assert.assertTrue(driver.getCurrentUrl().contains("camera-photo"),
                "User is not on camera and photo page");
//        ArrayList<WebElement> addToCartButton = new ArrayList<WebElement>();
//        List<WebElement> buttons = driver.findElements(By.className("buttons"));
//        System.out.println("Total listed products: " + buttons.size());
//
//        for (WebElement element : buttons) {
//            System.out.println(element.getText());
//
//            Iterator iterator = addToCartButton.iterator();
//            while (iterator.hasNext()){
//                SoftAssert softAssert = new SoftAssert();
//                softAssert.assertTrue(element.getText().contains("ADD TO CART") ,
//                ""+getTextFromElement(_addToCartButton) + "This item does not have add to cart button");


        List<String> noAddToCartButtonProducts = new ArrayList<String>();

        List<WebElement> webElementList = driver.findElements(_itemBoxesfield);
        System.out.println(webElementList.size());
        int count = 0;
        for (WebElement element : webElementList) {
            if (element.getText().contains("ADD TO CART")) {
                count++;
            } else {
                noAddToCartButtonProducts.add("No add to cart Button:" + element.findElement(_productTitles).getText());
            }
        }
        Assert.assertEquals(count, webElementList.size(),
                "One or more products missing add to card button\n" + noAddToCartButtonProducts);

    }

}