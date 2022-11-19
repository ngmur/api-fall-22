package rest.films;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class NoDeserialization {
    private static final String BASE_URI = "https://ghibliapi.herokuapp.com/films";
    @Test

    public void getFilm_NoDeserialization_UseJsonPath(){
        RestAssured.baseURI = BASE_URI;
        String filmId = "2baf70d1-42bb-4437-b551-e5fed5a87abe";
        Response getResponse = RestAssured.given()
                .when()
                .pathParam("id",filmId)
                .get("/films/{id}");


        System.out.println(getResponse.jsonPath().getString("id"));
        System.out.println(getResponse.getStatusCode());


    }
}
