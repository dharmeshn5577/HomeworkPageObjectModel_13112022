package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ElectronicsPage extends Utils{

        private By _cameraAndPhoto = By.xpath("//div[@class=\"item-grid\"]//a[1]");
    public void clickOnCameraAndPhotoSubCategory(){
    waitForUrlToBe("https://demo.nopcommerce.com/electronics", 5);
    Assert.assertTrue(driver.getCurrentUrl().contains("electronics"));
    clickOnElement(_cameraAndPhoto);
    }
}
