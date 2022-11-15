package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils{

    private By _registrationCompletedMessage = By.className("result");


    public void verifyUserIsOnRegistrationResultPage() {
        waitForUrlToBe("https://demo.nopcommerce.com/registerresult/1?returnUrl=/", 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("registerresult/1?returnUrl=/"), "User is not on registration result page.");
    }

    public void verifyUserRegistrationIsCompleted(){
        getTextElement(_registrationCompletedMessage);
    }
}
