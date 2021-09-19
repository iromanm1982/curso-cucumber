package com.cucumber.util.reporting;

import com.cucumber.enums.TakeScreenshotConditions;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class PhotographerHook {

    @Autowired
    private WebDriver webDriver;

    @Value("${take.screenshot.condition:NONE}")
    private TakeScreenshotConditions takeScreenshotCondition;

    @After
    public void takeScreenshootAfterScenario(Scenario scenario) {
        if (TakeScreenshotConditions.END_OF_SCENARIO == takeScreenshotCondition)
            takeScreenshoot(scenario);
    }

    @AfterStep
    public void takeScreenshootAfterEveryStep(Scenario scenario) {
        if (TakeScreenshotConditions.EVERY_STEP == takeScreenshotCondition)
            takeScreenshoot(scenario);
    }

    @After
    public void takeScreenshootAfterFailed(Scenario scenario) {
        if (scenario.isFailed() && TakeScreenshotConditions.FAILING_SCENARIO == takeScreenshotCondition)
            takeScreenshoot(scenario);
    }

    public void takeScreenshoot(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screenshoot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshoot, "image/png", UUID.randomUUID().toString());
            }
        } catch (WebDriverException ex) {
            System.out.println("error al tomar pantallazo" + ex.getMessage());
        }
    }
}
