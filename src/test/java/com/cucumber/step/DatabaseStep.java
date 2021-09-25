package com.cucumber.step;

import com.cucumber.database.domain.User;
import com.cucumber.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseStep {

    @Autowired
    UserRepository userRepository;

    User user = new User();
}
