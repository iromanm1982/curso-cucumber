package com.cucumber.builders.data;

import com.cucumber.enums.Gender;
import com.cucumber.models.User;
import com.cucumber.util.RandomNumberGenerator;

public class UserBuilder {

    private User user;

    private UserBuilder() {
        user = User.builder().build();
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder but() {
        return withDefaultInfo();
    }

    public UserBuilder withDefaultInfo() {
        this.user = User.builder()
                .firstName("Miku")
                .lastName("Muerte")
                .email("miku@catmail.com")
                .gender(Gender.FEMALE)
                .country("Australia")
                .birthDay("4")
                .birthMonth("April")
                .birthYear("2015")
                .phone(RandomNumberGenerator.get())
                .password("A_x?213213")
                .passwordConfirmation("A_x?213213")
                .build();
        return this;
    }

    public User build() {
        return this.user;
    }

    public UserBuilder withoutEmail() {
        user.setEmail("");
        return this;
    }

    public UserBuilder withoutBithDay() {
        user.setBirthDay("");
        return this;
    }
}
