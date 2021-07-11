package com.yantraQA.drivers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.Locale;

public class DriverFactory {

    public static WebDriver createInstance(String browserName, String execType) {
        DriverManager driverManager=null;
        WebDriver driver=null;
        switch (browserName.trim().toLowerCase()){
            case "chrome":
                driverManager = new ChromeImpl(execType);
                driver = driverManager.getDriver();
                break;
            case "firefox":
                driverManager = new FirefoxImpl(execType);
                driver = driverManager.getDriver();
                break;
            default:
                Assert.fail("No Such Method Defined");
        }
        return driver;
    }
}
