package com.yantraQA.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class ChromeImpl implements DriverManager {
    private String execType;
    public ChromeImpl(String execType) {
        this.execType = execType;
    }

    @Override
    public WebDriver getDriver() {
        WebDriver driver = null;
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        LoggingPreferences prefs = new LoggingPreferences();
        prefs.enable(LogType.BROWSER, Level.ALL);
        prefs.enable(LogType.DRIVER, Level.ALL);
        prefs.enable(LogType.PERFORMANCE, Level.ALL);
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS,prefs);
        try {
            driver = (execType.equalsIgnoreCase("grid"))?
                    (new RemoteWebDriver(new URL(config.seleniumGridURL()),desiredCapabilities)):
                    (new ChromeDriver());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Assert.fail("MalformedURLException thrown, Grid URL is not correct");
        }
        return driver;
    }
}
