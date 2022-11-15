package org.example;

import org.openqa.selenium.By;

public class Homepage extends Utils{

    // created variable of inbuilt class By and make it private to limit the access to in this class only
    private By _registerButton = By.className("ico-register");


    public void clickOnRegistrationButton(){
        clickElement(_registerButton);  // by using inherit called clickElement method from Utils class
    }
}
