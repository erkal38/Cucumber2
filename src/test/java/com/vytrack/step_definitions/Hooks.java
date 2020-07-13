package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {
    @Before
    public void setUp(){
        System.out.println("\tthis is coming from Before");

    }

    @Before("@db")// if we have @db annotation on the feature file
    public void setUpDb(){
        System.out.println("\tconnecting the db");
    }

    @After("@db")
    public void closeDb(){
        System.out.println("\tdisconnecting from database");

    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }
}
