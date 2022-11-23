package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class DriverManager extends Utils {

    public void openBrowser() {
        // set driver path for Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        // assign value to driver varible as a chrome driver to perform task in Chrome browser
        driver = new ChromeDriver();
        // use inbuilt manage method to manage something, here we have to manage windows, so I have used inbuilt window method
        // and I want to do maximize the window, so I also used inbuilt maximize method
        driver.manage().window().maximize();
        // used implicitWait timeout feature to instruct webDriver to wait till 2 seconds before sending test case fail exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // used get method with driver to navigate to the website
        driver.get("https://demo.nopcommerce.com/");
//        driver.get("http://omayo.blogspot.com/");

    }

    public void closeBrowser(){

        driver.quit();  // used inbuilt quit method to close the tab(s) of browser opened by ChromeDriver
    }

}
