package com.yantraQA.stepdefs;

import com.google.inject.Inject;
import com.yantraQA.core.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Inject
    TestContext context;

    @Before
    public void setUp(Scenario s){
        context.setScenario(s);
    }

    @After
    public void cleanUp(){
        context.quitDriver();
    }

    @AfterStep
    public void afterEachStepTakeScreenShot(){
        TakesScreenshot scrnShot = (TakesScreenshot)context.getDriver();
        byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
        context.getScenario().attach(data,"image/png",context.getScenario().getName());
    }

}
