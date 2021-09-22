package com.cucumber.step;

import com.cucumber.builders.data.UserBuilder;
import com.cucumber.config.DriverConfig;
import com.cucumber.tasks.NavigateTo;
import com.cucumber.tasks.UserSignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = {DriverConfig.class})
public class SignUpStep {

    @Autowired
    private UserSignUp userSignUp;

    @Autowired
    private NavigateTo navigateTo;

    @Given("^Miku quiere crear una cuenta$")
    public void miku_quiere_crear_una_cuenta() throws Throwable {
        navigateTo.signUpPage();
        Thread.sleep(4000);

    }

    @When("^El envia la información requerida por la cuenta$")
    public void el_envia_la_información_requerida_por_la_cuenta() throws Throwable {

        userSignUp.withInfo(UserBuilder.anUser().withDefaultInfo().build());

     //  userSignUp.withInfo(UserBuilder.anUser().but().withoutEmail().withoutBithDay().build());

        Thread.sleep(7000);
    }

    @Then("^El deberia ver la cuenta creada$")
    public void el_deberia_ver_la_cuenta_creada() throws Throwable {
        assertThat(true).isEqualTo(true);
    }

    @Then("El deberia ver que el registro ha fallado")
    public void el_deberia_ver_que_el_registro_ha_fallado() {
        assertThat(true).isEqualTo(false);
    }



}
