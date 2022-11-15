package org.example;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest extends Utils{

    // created object of DriverManager class so can use its property in this class
    DriverManager driverManager = new DriverManager();

    @BeforeMethod       // used BeforeMethod TestNG function to run this method before running every method
    public void startBrowser(){
    driverManager.openBrowser();    // openBrowser method called from DriverManager class
    }


    @AfterMethod    // used AfterMethod TestNG function to run this method after running every method
    public void quitBrowser(){
        driverManager.closeBrowser();   // closeBrowser method called from DriverManager class
    }
}
