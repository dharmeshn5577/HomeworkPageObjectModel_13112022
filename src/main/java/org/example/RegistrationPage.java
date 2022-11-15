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
//    used wait function to wait for URL to be open and verify URL by using assertTrue function
    waitForUrlToBe("https://demo.nopcommerce.com/register?returnUrl=%2F", 5);
    Assert.assertTrue(driver.getCurrentUrl().contains("register?returnUrl=%2F"), "User is not on registration page.");
}

    public void enterRegistrationDetails(){
//  by using inherit called clickElement,typeText and dropdown list methods from Utils class
    clickElement(_selectGenderMale);
    typeText(_firstName, "Ram");
    typeText(_lastName, "Patel");
    selectFromDropDownList_ByIndex(_birthDay, 5);
    selectFromDropDownList_ByVisibleText(_birthMonth, "May");
    selectFromDropDownList_ByValue(_birthYear, "2011");
    typeText(_email, generateUniqueEmailID());
    typeText(_companyName, "Patel Trading Co. Ltd.");
    typeText(_password, "Abc#123");
    typeText(_confirmPassword, "Abc#123");
    clickElement(_registerButton);

    }
}
