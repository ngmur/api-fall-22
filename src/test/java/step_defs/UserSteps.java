package step_defs;

import io.cucumber.java.en.Given;

import utils.RestClientBDD;

public class UserSteps {

    RestClientBDD restClientBDD = new RestClientBDD();
    @Given("User creates a new user")
    public void user_creates_a_new_user() {
        restClientBDD.createUserValidateCreated();
    }


}
