package rest.users;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;


import pojos.User;
import utils.RestClient;

import java.util.Locale;



public class Examples extends BaseClass {

    RestClient restClient = new RestClient();



    public void givenValidResponce_checkStatuscode() {

    restClient.getUser(token,"/users");
    }


    public void givenInvalidToken_checkSatusCode() {
        String payload = "{\n" +
                "        \"name\": \"Nikita Moore\",\n" +
                "        \"email\": \"nikim@yahoo.com\",\n" +
                "        \"gender\": \"female\",\n" +
                "        \"status\": \"active\"\n" +
                "    }";
        restClient.createUser(token,payload);

    }


    public void getUser_givenValidResponse_okStatusCode() {
        User user = new User();
        user.setName(faker.name().fullName());
        user.setEmail(user.getName().toLowerCase(Locale.ROOT).trim().replace(" ", "") + "@gmail.com");
        user.setGender("female");
        user.setStatus("active");

        System.out.println(gson.toJson(user));

        Response postResponse = restClient.createUser(token, gson.toJson(user));
      //  Assumptions.assumeTrue(201 == postResponse.getStatusCode());

        System.out.println(postResponse.asString());

       // int postUserId = postResponse.jsonPath().getInt("id");
        User userPost = gson.fromJson(postResponse.asString(), User.class);

        Response getResponse = restClient.getUser(token, user.getId());
       // User postUser = postResponse.as(new TypeRef<User>() {});
//        System.out.println(postUser.getName());
//        System.out.println(postUser.getEmail());
//        System.out.println(postUser.getStatus());
//        Response getResponse = restClient.getUser(token,postUserId+"");

//        assertAll(
//
//                () -> assertEquals(200,getResponse.getStatusCode()),
//                () -> assertTrue(getResponse.asString().contains(user.getName())),
//                () ->  assertTrue(getResponse.asString().contains(user.getEmail()))
//
//        );

    }




    public void createUser_givenValidResponse_createdStatusCode(){
        User user = new User();
        user.setName(faker.name().fullName());
        user.setEmail(user.getName().toLowerCase(Locale.ROOT).trim().replace(" ", "") + "@gmail.com");
        user.setGender("female");
        user.setStatus("active");

        System.out.println(gson.toJson(user));

        Response postResponse = restClient.createUser(token,gson.toJson(user));

        System.out.println(postResponse.asString());

//        assertAll(
//
//                () -> assertEquals(200,postResponse.getStatusCode()),
//                () -> assertTrue(postResponse.asString().contains(user.getName())),
//                () ->  assertTrue(postResponse.asString().contains(user.getEmail()))
//
//        );



    }

    public void serializationAndDeserializationUsingJackson() throws JsonProcessingException {
        User user = new User();
        user.setName(faker.name().fullName());
        user.setEmail(user.getName().toLowerCase(Locale.ROOT).trim().replace(" ", "") + "@gmail.com");
        user.setGender("female");
        user.setStatus("active");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(user);
        System.out.println(jsonBody);

        Response postResponse = restClient.createUser(token, jsonBody);
        User postUser = objectMapper.readValue(postResponse.asString(),User.class);
        System.out.println(postUser.toString());

}
}
