package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriendPage extends Utils{
    private By _friendEmailField = By.id("FriendEmail");
    private By _personalMessageField = By.id("PersonalMessage");
    private By _sendEmailButton = By.name("send-email");
    private By _actualMsg = By.className("result");

    public void verifyUserShouldAbleToReferProductToFriend(){
        String expectedMsg = "Your message has been sent.";

        waitForUrlToBe("https://demo.nopcommerce.com/productemailafriend/4", 20);
        // verified user is on correct page by using assertTrue method
        Assert.assertTrue(driver.getCurrentUrl().contains("productemailafriend/4"), "User is not on Email A Friend Page");
        //Fill the details and click on send email button
        typeText(_friendEmailField, "friend123@gmail.com");
        typeText(_personalMessageField, "This is a very nice deal with great price.");
        clickOnElement(_sendEmailButton);
        // verified email sent successfully by using assertEqual method
        Assert.assertEquals(getTextFromElement(_actualMsg), expectedMsg, "Email a friend unsuccessful");
    }
}
