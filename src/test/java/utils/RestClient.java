package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import pojos.User;

public class RestClient {

    public  Response createUser(String bearerToken,String jsonBody){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", bearerToken)
                .accept(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("/users");


    }

    public  Response getUser(String bearerToken , String userId ){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer " + bearerToken)
                .accept(ContentType.JSON)
                .when()
                .get("/users");

    }
    public Response putUser(String bearerToken,String userId,String jsonBody){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization",bearerToken)
                .accept(ContentType.JSON)
                .body(jsonBody)
                .when()
                .pathParam("userId",userId)
                .put("/users/{userId}");
    }

    public Response deleteUser(String bearerToken,String userId){
        return RestAssured
                .given()
                .headers("Authorization",bearerToken)
                .when()
                .pathParam("userId",userId)
                .delete("/users/{userId}");


    }

    public Response getUserUsingQueryParamName(String userName,String bearerToken){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer " + bearerToken)
                .accept(ContentType.JSON)
                .when()
                .get("/users?name="+ userName);
    }



    public Response createPostForUser(String postBody,int userId,String bearerToken){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer "+bearerToken)
                .accept(ContentType.JSON)
                .body(postBody)
                .when()
                .pathParam("userId",userId)
                .post("/users/{userId}/posts");
    }

    public Response getPostsOfUser(int userId,String bearerToken){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer " + bearerToken)
                .accept(ContentType.JSON)
                .when()
                .pathParam("userId",userId)
                .get("/users/{userId}/posts");
    }
}
