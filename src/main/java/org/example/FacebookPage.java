package org.example;


import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Iterator;

public class FacebookPage extends Utils{

    private By _facebookCookies = By.xpath("//div[@role='dialog']//div[1]/div[contains(@class, 'x1ypdohk') and contains(@aria-label, 'cookies')]");

    public void userClickOnCookiesPreferenceButton(){
        waitForUrlToBe("https://www.facebook.com/nopCommerce", 5);
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
        clickOnElement(_facebookCookies);

    }
}
