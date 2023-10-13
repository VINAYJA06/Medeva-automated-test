package com.factory;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;

public class WebDriverFactory {

    public static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    public void init_driver(String browser) throws IOException {
        ChromeOptions optionsChrome = new ChromeOptions();
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        EdgeOptions optionsEdge = new EdgeOptions();

        switch (browser) {
            case "chrome":
                optionsChrome.addArguments("--start-maximized");
                localDriver.set(new ChromeDriver(optionsChrome));
                break;

            case "firefox":
                optionsFirefox.addArguments("--start-maximized");
                localDriver.set(new FirefoxDriver(optionsFirefox));
                break;

            case "edge":
                optionsEdge.addArguments("--start-maximized");
                localDriver.set(new EdgeDriver(optionsEdge));
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
