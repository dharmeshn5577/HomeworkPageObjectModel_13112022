package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public static void clickElement(By by){
        driver.findElement(by).click();
    }

    // created static no return type typeText method with 2 parameter to fill data action in text field
    public static void typeText(By by, String textToFill){
        driver.findElement(by).sendKeys(textToFill);
    }

    // created static String return type getTextElement method to capture text action
    public static String getTextElement(By by){
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
}
