package com.cucumber.pageobject;

import com.cucumber.enums.Gender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpService {

    @Autowired
    private SignUpPageObject signUpPageObject;

    @Autowired
    private WebDriver driver;

    @Autowired
    private WebDriverWait webDriverWait;

    public void navegar(String url) {
        this.driver.get(url);
    }
    public void writeFirstName(String firstname) {
        this.webDriverWait.until(ExpectedConditions.visibilityOf( this.signUpPageObject.getFirstNameTextbox()));
        this.signUpPageObject.getFirstNameTextbox().sendKeys(firstname);
    }

    public void writeLastName(String lastname) {
        this.signUpPageObject.getLastNameTextbox().sendKeys(lastname);
    }
    public void writeEmail(String email) {
        this.signUpPageObject.getEmailTextBox().sendKeys(email);
    }

    public void writePhone(String telefono) {
        this.signUpPageObject.getPhoneTextBox().sendKeys(telefono);
    }

    private void selectMale() {
        this.signUpPageObject.getSelectMale().click();
    }
    private void selectFemale() {
        this.signUpPageObject.getSelectFemale().click();
    }

    public void selectCountry(String country) {
        new Select(this.signUpPageObject.getCountries()).selectByValue(country);
    }
    public void selectBirthDay(String dia) {
        new Select(this.signUpPageObject.getBirthDay()).selectByValue(dia);
    }
    public void selectBirthMonth(String mes) {
        new Select(this.signUpPageObject.getBirthMonth()).selectByValue(mes);
    }

    public void selectBirthYear(String anyo) {
        new Select(this.signUpPageObject.getBirthYear()).selectByValue(anyo);
    }

    public void writePassword(String password) {
        this.signUpPageObject.getPassword().sendKeys(password);
    }
    public void writePassordConfirmation(String password) {
        this.signUpPageObject.getPasswordConfirmation().sendKeys(password);
    }

    public void selectGender(Gender gender) {
        if(gender == Gender.FEMALE){
            selectFemale();
        } else {
            selectMale();
        }
    }
    public void clickOnSubmit() {
        this.signUpPageObject.getSubmitButton().click();
    }
}
