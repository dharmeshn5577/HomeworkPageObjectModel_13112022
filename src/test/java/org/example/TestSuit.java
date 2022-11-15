package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{

    // created objects of all created webpages classes so can use their property in this class
    Homepage homepage = new Homepage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();

    @Test       // used test annotation feature of TestNG to run multiple test cases in one class
    public void verifyUserShouldAbleToRegisterSuccessfully() {
        homepage.clickOnRegistrationButton();
        registrationPage.verifyUserIsOnRegistrationPage();
        registrationPage.enterRegistrationDetails();
        registrationResultPage.verifyUserIsOnRegistrationResultPage();
        registrationResultPage.verifyUserRegistrationIsCompleted();

//      waitForUrlToBe("http://omayo.blogspot.com/", 2);

    }
}
