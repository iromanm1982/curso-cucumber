package com.cucumber.config;

import com.cucumber.enums.Browser;
import com.cucumber.util.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.net.MalformedURLException;
import java.time.Duration;

@Configuration
@ComponentScan(basePackages = "com.cucumber")
@PropertySource("classpath:/application-${environment:dev}.properties")
public class DriverConfig {

    @Value("${driver.type}")
    private Browser driverType;

    @Value("${element.wait.timeout.seconds}")
    private int webDriverTimeOut;

    @Autowired
    private DriverFactory driverFactory;

    @Scope("cucumber-glue")
    @Bean(destroyMethod = "quit")
    public WebDriver webDriver() throws MalformedURLException {
       // System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/linux/geckodriver");
        return driverFactory.get(driverType);
    }

    @Bean
    public WebDriverWait waitFor() throws MalformedURLException {
     //   return new WebDriverWait(webDriver(), Duration.ofSeconds(webDriverTimeOut));
        return new WebDriverWait(webDriver(), 1000l);
    }
}
