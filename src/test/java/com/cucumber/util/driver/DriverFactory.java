package com.cucumber.util.driver;

import com.cucumber.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static String path = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/%s";

    public static WebDriver get(Browser browser) {
        if(Browser.FIREFOX == browser) {
            System.setProperty("webdriver.gecko.driver",  String.format(path, "geckodriver") );
            return new FirefoxDriver();
        }

        if(Browser.CHROME == browser) {
            System.setProperty("webdriver.chrome.driver", String.format(path, "chromedriver"));
            return new FirefoxDriver();
        }

        if(Browser.IE == browser) {
            System.setProperty("webdriver.gecko.driver", String.format(path, "ie"));
            return new FirefoxDriver();
        }

        throw  new IllegalArgumentException("Driver not found" + browser);
    }
}
