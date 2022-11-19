package step_defs;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.RestClientBDD;

public class PostSteps {
    RestClientBDD restClientBDD = new RestClientBDD();


    @When("User creates a post with title {string} and body {string}")
    public void user_creates_a_post_with_title_and_body(String title, String body) {
    restClientBDD.createPostUsingUserId(title, body);
    }

    @Then("Check if post is created with title {string} and body {string}")
    public void check_if_post_is_created_with_title_and_body(String title, String body) {
    restClientBDD.validatePostWithTitleAndBodyIsCreated(title, body);
    }

}
