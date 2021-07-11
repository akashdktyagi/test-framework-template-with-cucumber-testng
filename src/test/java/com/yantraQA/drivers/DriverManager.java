package com.yantraQA.drivers;

import com.yantraQA.config.CoreConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface DriverManager {
    CoreConfig config = ConfigFactory.create(CoreConfig.class);
    public WebDriver getDriver();
}
