package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class DriverManager extends Utils {
    public static final String USERNAME = LoadProp.getProperty("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = LoadProp.getProperty("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    String browserName = LoadProp.getProperty("BrowserName");
    //    String browserName = System.getProperty("browser");
    boolean runIncloud = Boolean.parseBoolean(LoadProp.getProperty("Cloud"));
    MutableCapabilities capabilities = new MutableCapabilities();

    //    String browserName = LoadProperty.getProperty("BrowserName");
    public void openBrowser() {
        // Running in cloud
        if (runIncloud) {
            System.out.println("Running in cloud");
            // Connect to cloud
            if (browserName.equalsIgnoreCase("Edge")) {
                // Connect with browserstack
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                browserstackOptions.put("buildName","Website build #5");
                capabilities.setCapability("bstack:options", browserstackOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

            } else if (browserName.equalsIgnoreCase("Firefox")) {
                ///connect with browserstack
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                browserstackOptions.put("buildName","Website build #5");
                capabilities.setCapability("bstack:options", browserstackOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            System.out.println("Running Locally");
            // Run in locally
            if (browserName.equalsIgnoreCase("Chrome")) {
                // set driver path for Chrome browser
                System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
                // assign value to driver varible as a chrome driver to perform task in Chrome browser
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/java/Drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/java/Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            } else {
                System.out.println("Your browser name is wrong or missing implementation for : " + browserName);
            }

        }

        // use inbuilt manage method to manage something, here we have to manage windows, so I have used inbuilt window method
        // and I want to do maximize the window, so I also used inbuilt maximize method
        driver.manage().window().maximize();
        // used implicitWait timeout feature to instruct webDriver to wait till 2 seconds before sending test case fail exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // used get method with driver to navigate to the website
        driver.get(LoadProp.getProperty("Homepage_url"));
//        driver.get("http://omayo.blogspot.com/");

    }

    public void closeBrowser() {

        driver.quit();  // used inbuilt quit method to close the tab(s) of browser opened by ChromeDriver
    }

}
