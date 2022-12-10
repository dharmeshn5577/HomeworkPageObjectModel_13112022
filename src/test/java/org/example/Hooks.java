package org.example;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BasePage {

    DriverManager driverManager = new DriverManager();


    @Before     // used BeforeMethod TestNG function to run this method before running every method
    public void setUp() {
        driverManager.openBrowser();    // openBrowser method called from DriverManager class
    }


    @After   // used AfterMethod TestNG function to run this method after running every method
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            byte[] source = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(source, "image/jpg/png", "screenshot");
        }
        driverManager.closeBrowser();   // closeBrowser method called from DriverManager class
    }
}

