package com.yantraQA.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class FirefoxImpl implements DriverManager {
    private String execType;
    public FirefoxImpl(String execType) {
        this.execType = execType;
    }

    @Override
    public WebDriver getDriver() {
        WebDriver driver = null;
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        desiredCapabilities.merge(options);
        desiredCapabilities.setBrowserName("firefox");
        try {
            driver = (execType.equalsIgnoreCase("grid"))?
                    (new RemoteWebDriver(new URL(config.seleniumGridURL()),desiredCapabilities)):
                    (new FirefoxDriver());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Assert.fail("MalformedURLException thrown, Grid URL is not correct");
        }
        return driver;
    }
}
