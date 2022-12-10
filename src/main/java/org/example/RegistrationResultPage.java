package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils{

    private By _registrationCompletedMessage = By.className("result");
    private By _continueButton = By.xpath("//a[contains(@class, 'continue')]");


    public void verifyUserIsOnRegistrationResultPage() {
        waitForUrlToBe("https://demo.nopcommerce.com/registerresult/1?returnUrl=/", 10);
        // verified user is on correct page by using assertTrue method
        Assert.assertTrue(driver.getCurrentUrl().contains("registerresult/1?returnUrl=/"),
                "User is not on registration result page.");
    }

    public void verifyUserRegistrationIsCompleted(){
        String expectedRegistrationMessage = "Your registration completed";
        Assert.assertEquals(getTextFromElement(_registrationCompletedMessage), expectedRegistrationMessage,
                "Registration Failed");
        clickOnElement(_continueButton);
    }
}
