package org.example;

import org.testng.Assert;

public class DesktopsPage extends Utils{

    public void verifyUserNavigateToDesktopsPage(){
    waitForUrlToBe("https://demo.nopcommerce.com/desktops", 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("desktops"),
                "User is not on desktops page");
    }
}
