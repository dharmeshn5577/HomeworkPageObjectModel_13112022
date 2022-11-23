package org.example;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Utils extends BasePage{

    // import SimpleDateFormat package to find timestamp in required format
    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }

    public static String generateUniqueEmailID(){
        return "abc" + getTimeStamp() + "@xyz.com";

    }
    // created static no return type with parameter clickElement method to perform click action
    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }

    // created static no return type typeText method with 2 parameter to fill data action in text field
    public static void typeText(By by, String textToFill){
        driver.findElement(by).sendKeys(textToFill);
    }

    // created static String return type getTextElement method to capture text action
    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    // created static, no return type, with parameter method to select from drop down list by using index
    // also used select class from selenium to perform selection action
    public static void selectFromDropDownList_ByIndex(By by, int indexNumber){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(indexNumber);
    }
    // created static, no return type, with parameter method to select from drop down list by using visible text
    // also used select class from selenium to perform selection action
    public static void selectFromDropDownList_ByVisibleText(By by, String visibleTextFieldData){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(visibleTextFieldData);
    }
    // created static, no return type, with parameter method to select from drop down list by using value
    // also used select class from selenium to perform selection action
    public static void selectFromDropDownList_ByValue(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    // created static, no return type, with parameter method for driver to wait until web element become clickable
    // also used WebDriverWait class from selenium for driver to wait and also explicit wait for driver to wait for web element
    public static void waitForElementToBeClickable(By by, int waitTimeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    // created static, no return type, with parameter method for driver to wait until web element become visible
    // also used WebDriverWait class from selenium for driver to wait and also explicit wait for driver to wait for web element
    public static void waitForElementToBeVisible(By by, int waitTimeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // created static, no return type, with parameter method for driver to wait until url load
    // also used WebDriverWait class from selenium for driver to wait and also explicit wait for driver to wait for url
    public static void waitForUrlToBe(String url, int waitTimeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void screenshotName( ITestResult result) {
       result.getName();

    }

    public static void captureScreenshot(String screenshotName){
        //Convert web driver object to TakeScreenshot
        TakesScreenshot screenshot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file
        File SourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File destinationFile = new File("src/Screenshots/"+ screenshotName + getTimeStamp()+".jpg");

        //Copy file at destination
        try {
            FileUtils.copyFile(SourceFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void alertIsPresent(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        if(wait.until(ExpectedConditions.alertIsPresent())==null)
//            System.out.println("Alert is not pop up.");
//        else
//    }
}
