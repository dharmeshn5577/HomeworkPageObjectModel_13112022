package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class AppleMacBookPro13InchPage extends Utils{
    private By _emailAFriend = By.xpath("//div[@class=\"email-a-friend\"]");

    public void verifyUserShouldAbleToEmailAFriend() {
        waitForUrlToBe("https://demo.nopcommerce.com/apple-macbook-pro-13-inch", 15);
        Assert.assertTrue(driver.getCurrentUrl().contains("apple-macbook-pro-13-inch"), "User is not on Apple MacBook 13 Inch product page");
        //Click on Email A Friend button
        clickOnElement(_emailAFriend);
    }
}
