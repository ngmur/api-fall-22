package rest.films;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.Films;

public class JacksonDeSerialization {
    private static final String BASE_URI = "https://ghibliapi.herokuapp.com/films";

    @Test
    void getFilm_JacksonDeserialization() throws JsonProcessingException{
        RestAssured.baseURI  = BASE_URI;
        String filmId = "2baf70d1-42bb-4437-b551-e5fed5a87abe";

        Response getResponse = RestAssured.given()
                .when()
                .pathParam("id",filmId)
                .get("/films/{id}");
        ObjectMapper objectMapper = new ObjectMapper();
        Films film = objectMapper.readValue(getResponse.asString(),Films.class);
        System.out.println(getResponse.getStatusCode());
        System.out.println(film.toString());
    }
    @Test
    void postFilm_JacksonSerialization() throws JsonProcessingException{
        Films films = new Films();
        films.setTitle("House of the Dragon");
        films.setOriginalTitle("HOTD");
        films.setOriginalTitleRomanised("Tenkū no shiro Rapyuta");
        films.setDescription("Castle in the Sky");
        films.setDirector("Hayao Miyazaki");
        films.setProducer("Isao Takahata");
        films.setReleaseDate("1986");
        films.setRunningTime("124");
        films.setRtScore("95");
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonFilm = objectMapper.writeValueAsString(films);
        System.out.println(films);

        RestAssured.baseURI = BASE_URI;
        Response postResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonFilm)
                .post("/films");

        System.out.println(postResponse.getStatusCode());
        System.out.println(postResponse.asString());

    }
}
