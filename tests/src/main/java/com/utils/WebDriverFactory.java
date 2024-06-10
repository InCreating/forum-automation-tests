package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserType) {
        if (browserType == null || browserType.isEmpty()) return null;
        switch (browserType.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "edge":
                return new EdgeDriver();
            default:
                return null;
        }
    }
}
