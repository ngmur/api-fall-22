package rest.users;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.User;
import utils.RestClient;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class CRUDTest extends BaseClass {
RestClient restClient = new RestClient();

    public void getUser_givenValidResponse_okStatusCode() {
        User user = new User();
        user.setName(faker.name().fullName());
        user.setEmail(user.getName().toLowerCase(Locale.ROOT).trim().replace(" ", "") + "@gmail.com");
        user.setGender("female");
        user.setStatus("active");

        System.out.println(gson.toJson(user));

        Response postResponse = restClient.createUser(token, gson.toJson(user));
       // Assumptions.assumeTrue(201 == postResponse.getStatusCode());

        System.out.println(postResponse.asString());

        User userPost = gson.fromJson(postResponse.asString(), User.class);

        Response getResponse = restClient.getUser(token, userPost.getId());
        System.out.println(userPost.getId());


        assertAll(

                () -> assertEquals(200,getResponse.getStatusCode()),
                () -> assertTrue(getResponse.asString().contains(user.getName())),
                () ->  assertTrue(getResponse.asString().contains(user.getEmail()))

        );

    }



    @Test
    public void createUser_givenValidResponse_createdStatusCode(){
        User user = new User();
        user.setName(faker.name().fullName());
        user.setEmail(user.getName().toLowerCase(Locale.ROOT).trim().replace(" ", "") + "@gmail.com");
        user.setGender("female");
        user.setStatus("active");

        System.out.println(gson.toJson(user));

        Response postResponse = restClient.createUser(token,gson.toJson(user));
       // Assumptions.assumeTrue(201 == postResponse.getStatusCode());
        System.out.println(postResponse.asString());

        assertAll(

                () -> assertEquals(201,postResponse.getStatusCode()),
                () -> assertTrue(postResponse.asString().contains(user.getName())),
                () ->  assertTrue(postResponse.asString().contains(user.getEmail()))

        );



    }

}
