package com.cucumber.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class PageBase {

    protected WebDriver webDriver;

    @Autowired
    public PageBase(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);

    }
}
