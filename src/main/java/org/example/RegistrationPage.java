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

    public void enterRegistrationDetails(){
//  by using inherit called clickElement,typeText and dropdown list methods from Utils class
    clickOnElement(_selectGenderMale);
    typeText(_firstName, LoadProperty.getProperty("FirstName"));
    typeText(_lastName, LoadProperty.getProperty("LastName"));
    selectFromDropDownList_ByValue(_birthDay, LoadProperty.getProperty("DOBDay"));
    selectFromDropDownList_ByVisibleText(_birthMonth, LoadProperty.getProperty("DOBMonth"));
    selectFromDropDownList_ByValue(_birthYear, LoadProperty.getProperty("DOBYear"));
    typeText(_email, LoadProperty.getProperty("EmailLP")+getTimeStamp()+LoadProperty.getProperty("EmailDP"));
    typeText(_companyName, LoadProperty.getProperty("CompanyName"));
    typeText(_password, LoadProperty.getProperty("Password"));
    typeText(_confirmPassword, LoadProperty.getProperty("ConfirmPassword"));
    clickOnElement(_registerButton);

    }
}
