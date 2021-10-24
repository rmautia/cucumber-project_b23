package com.cydeo.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * We need a utility class with method
 * to get WebDriver object with all the settings needed
 * by passing browsername
 *
 * WebdriverFactory.get("chrome") ==>> webdriver object with chrome driver
 * WebdriverFactory.get("firefox") ==>> webdriver object with firefox driver
 */

public class WebdriverFactory {

    public static WebDriver getDriver(String browserName){

        WebDriver driver ;

        switch (browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
                // Other browsers omitted
            default:
                driver = null;
                System.out.println("UNKOWN BROWSER TYPE!!!"+ browserName);
        }

        driver.manage().window().maximize();


        return driver;
    }
}
