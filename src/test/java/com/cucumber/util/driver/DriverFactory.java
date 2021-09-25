package com.cucumber.util.driver;

import com.cucumber.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URI;

@Component
public class DriverFactory {

    private  String path = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/%s";

    @Value("${grid.url}")
    private  String gridUrl;

    @Value("${remote.execution}")
    private  boolean remoteExecution;

    public  WebDriver get(Browser browser) throws MalformedURLException {

        if(remoteExecution){
            return getRemoteWebDriver(browser);
        }
        if(Browser.FIREFOX == browser) {
        //    System.setProperty("webdriver.gecko.driver",  String.format(path, "geckodriver") );
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }

        if(Browser.CHROME == browser) {
        //    System.setProperty("webdriver.chrome.driver", String.format(path, "chromedriver"));
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        if(Browser.IE == browser) {
            System.setProperty("webdriver.gecko.driver", String.format(path, "ie"));
            return new FirefoxDriver();
        }

        throw  new IllegalArgumentException("Driver not found" + browser);
    }

    private  RemoteWebDriver getRemoteWebDriver(Browser browser) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser.name());
        return  new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);
    }
}
