package com.AutoTrader.step_definitions;

import com.AutoTrader.utilities.ConfigurationReader;
import com.AutoTrader.utilities.MyDriver;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Driver;


public class Hook {

    @Before
    public void setup(){

        System.out.println("##############################");
        System.out.println("Test setup!");
        MyDriver.get().manage().window().maximize();
        MyDriver.get().get(ConfigurationReader.getProperty("url"));

    }

    @After
    public void teardown(Scenario scenario){
        //if test failed - do this
        if(scenario.isFailed()){
            System.out.println("Test failed!");
            byte[] screenshot = ((TakesScreenshot)MyDriver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }else{
            System.out.println("Cleanup!");
            System.out.println("Test completed!");
        }

        System.out.println("##############################");
        //After every test we gonna close browser
        MyDriver.close();
    }
}
