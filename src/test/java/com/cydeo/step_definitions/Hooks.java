package com.cydeo.step_definitions;

import com.cydeo.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    // we can set up hook classes that hook classes that contains
    // method that run before each scenario and after each scenario
    // or even when we learn tags
    // we can run certain code before and after each scenario and after each scenario that tagged with a certain tag


    @Before("@ui")
    public void setUpDriver(){
        System.out.println("THis is FROM @Before inside hooks class");
        //set up implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

    @After("@ui")
    public void tearDown(Scenario scenario){

        // check if scenario is failed or not
        if (scenario.isFailed()){
            // this is how we take screenshot in selenium
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte [] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "whatever name you want");
        }


        System.out.println("THIS IS FROM @After inside hooks class");
        //
        Driver.closeBrowser();

    }

}
