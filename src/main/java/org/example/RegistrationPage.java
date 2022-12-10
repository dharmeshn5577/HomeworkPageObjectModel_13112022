package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationPage extends Utils{

    // created variables of inbuilt class By and make it private to limit the access to in this class only

    private By _selectGenderMale = By.id("gender-male");
    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");
    private By _birthDay = By.name("DateOfBirthDay");
    private By _birthMonth = By.name("DateOfBirthMonth");
    private By _birthYear = By.name("DateOfBirthYear");
    private By _email = By.id("Email");
    private By _companyName = By.id("Company");
    private By _optInOutNewsletter = By.id("Newsletter");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.id("register-button");


public void verifyUserIsOnRegistrationPage(){
//    used explicit wait to wait for URL to be open
    waitForUrlToBe("https://demo.nopcommerce.com/register?returnUrl=%2F", 5);
    // verified user is on correct page by using assertTrue method
    Assert.assertTrue(driver.getCurrentUrl().contains("register?returnUrl=%2F"), "User is not on registration page.");
}

    public void enterRegistrationDetailsAndClickOnRegisterButton(){
//  by using inherit called clickElement,typeText and dropdown list methods from Utils class
    clickOnElement(_selectGenderMale);
    typeText(_firstName, LoadProp.getProperty("FirstName"));
    typeText(_lastName, LoadProp.getProperty("LastName"));
    selectFromDropDownList_ByValue(_birthDay, LoadProp.getProperty("DOBDay"));
    selectFromDropDownList_ByVisibleText(_birthMonth, LoadProp.getProperty("DOBMonth"));
    selectFromDropDownList_ByValue(_birthYear, LoadProp.getProperty("DOBYear"));
    typeText(_email, LoadProp.getProperty("EmailLP")+getTimeStamp()+ LoadProp.getProperty("EmailDP"));
    typeText(_companyName, LoadProp.getProperty("CompanyName"));
    typeText(_password, LoadProp.getProperty("Password"));
    typeText(_confirmPassword, LoadProp.getProperty("ConfirmPassword"));
    clickOnElement(_registerButton);

    }
}
