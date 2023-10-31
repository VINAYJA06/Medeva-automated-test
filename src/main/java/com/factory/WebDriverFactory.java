package com.factory;

import com.helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    public static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    public void init_driver(String browser) {
        ChromeOptions optionsChrome = new ChromeOptions();
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        EdgeOptions optionsEdge = new EdgeOptions();

        switch (browser) {
            case "chrome":
                optionsChrome.addArguments("--start-maximized");
                localDriver.set(new ChromeDriver(optionsChrome));
                Helper.getLocalTime();
                break;

            case "firefox":
                optionsFirefox.addArguments("--start-maximized");
                localDriver.set(new FirefoxDriver(optionsFirefox));
                Helper.getLocalTime();
                break;

            case "edge":
                optionsEdge.addArguments("--start-maximized");
                localDriver.set(new EdgeDriver(optionsEdge));
                Helper.getLocalTime();
                break;

            case "All Browsers":
                optionsChrome.addArguments("--start-maximized");
                localDriver.set(new ChromeDriver(optionsChrome));
                localDriver.set(new FirefoxDriver(optionsFirefox));
                localDriver.set(new EdgeDriver(optionsEdge));
                break;
        }
    }

    public static WebDriver getDriver(){
        return localDriver.get();
    }
}
