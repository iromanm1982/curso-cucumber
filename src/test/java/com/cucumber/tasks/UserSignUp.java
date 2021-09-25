package com.cucumber.tasks;

import com.cucumber.enums.Gender;
import com.cucumber.models.User;
import com.cucumber.pageobject.SignUpService;
import com.cucumber.util.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class UserSignUp {

    @Autowired
    private SignUpService signUpService;

    public void withInfo(User user) {
        signUpService.writeFirstName(user.getFirstName());
        signUpService.writeLastName(user.getLastName());
        signUpService.writeEmail(user.getEmail());
        signUpService.selectGender(user.getGender());
        signUpService.selectCountry(user.getCountry());
        signUpService.selectBirthDay(user.getBirthDay());
        signUpService.selectBirthMonth(user.getBirthMonth());
        signUpService.selectBirthYear(user.getBirthYear());
        signUpService.writePassword(user.getPassword());
        signUpService.writePassordConfirmation(user.getPasswordConfirmation());
        // signUpService.clickOnSubmit();

    }
}
