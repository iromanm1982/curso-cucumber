package com.cucumber.pageobject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SignUpPageObject extends PageBase {

    private WebDriver driver;

    @Autowired
    public SignUpPageObject(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath =  "//input[@ng-model='FirstName']" )
    private WebElement firstNameTextbox;


    @FindBy(xpath =  "//input[@ng-model='LastName']" )
    private WebElement lastNameTextbox;

    @FindBy(xpath = "//input[@type='email']" )
    private WebElement emailTextBox;

    @FindBy(xpath = "//input[@type='tel']" )
    private WebElement phoneTextBox;

    @FindBy(xpath = "//input[@value='Male']" )
    private WebElement selectMale;

    @FindBy(xpath = "//input[@value='FeMale']" )
    private WebElement selectFemale;

    @FindBy(id = "countries" )
    private WebElement countries;

    @FindBy(id = "yearbox" )
    private WebElement birthYear;

    @FindBy(xpath = "//select[@ng-model='monthbox']" )
    private WebElement birthMonth;

    @FindBy(id = "daybox" )
    private WebElement birthDay;

    @FindBy(id = "firstpassword" )
    private WebElement password;

    @FindBy(id = "secondpassword" )
    private WebElement passwordConfirmation;

    @FindBy(id = "submitbtn" )
    private WebElement submitButton;


}
