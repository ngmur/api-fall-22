package utils;



import io.restassured.response.Response;



import pojos.Posts;
import pojos.User;
import rest.users.BaseClass;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


public class RestClientBDD extends BaseClass {

     RestClient restClient = new RestClient();
    // Date date = new Date();


     public void createUserValidateCreated() {

          User user = new User();
          user.setName("Victor vi");
          user.setEmail("vivi@gmail.com");
          user.setGender("male");
          user.setStatus("active");

          String jsonUser = gson.toJson(user);

          Response postResponse = restClient.createUser(token,jsonUser);

         assumeTrue(postResponse.getStatusCode() == 201);


     }

     public int getUserIdFromTestAccount(){

          Response getResponse = restClient.getUserUsingQueryParamName("Victor vi",token);

          assumeTrue(getResponse.getStatusCode()==200);
         ArrayList ids = (ArrayList) getResponse.jsonPath().getList("id");

          return (int) ids.get(0);
     }



    public void createPostUsingUserId(String title,String body){
    Posts post = new Posts(title,body);
    System.out.println(post.toString());
    String jsonPost = gson.toJson(post);
    Response postResponse = restClient.createPostForUser(jsonPost,getUserIdFromTestAccount(),token);

    assumeTrue(postResponse.getStatusCode()==201);

}
    public void validatePostWithTitleAndBodyIsCreated(String title,String body){
            Response getResponse = restClient.getPostsOfUser(getUserIdFromTestAccount(),token);

        String getJson = getResponse.asString().replace("[","").replace("]","");

        System.out.println(getJson);
        Posts getPost = gson.fromJson(getJson,Posts.class);

        assertAll(
                () -> assertEquals(getUserIdFromTestAccount()+"",getPost.getUserId()),
                () -> assertEquals(title,getPost.getTitle()),
                () -> assertEquals(body,getPost.getBody())
                );


    }

}