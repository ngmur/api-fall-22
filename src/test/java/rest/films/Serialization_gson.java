package rest.films;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.Films;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Serialization_gson {

    private static final String BASE_URI = "https://ghibliapi.herokuapp.com";

    @Test
            public void create_film_serialization(){
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
        films.setPeople(new String[]{"Toru Hara", "Isao Takahata", "Hayao Miyazaki"});
        films.setSpecies(new String[]{"Hara", "Takahata", "Miyazaki"});
        films.setLocations(new String[]{"Toru", "Isao", "Hayao"});
        films.setVehicles(new String[]{"Tor", "Isa", "Hay"});
        films.setUrl("https://ghibliapi.herokuapp.com/films/2baf70d1-42bb-4437-b551-e5fed5a87abe");

        Gson gson = new Gson();
        String jsonFilm = gson.toJson(films);
        System.out.println(films);
        RestAssured.baseURI = BASE_URI;
        Response postResponse =RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", BASE_URI)
                .accept(ContentType.JSON)
                .body(films)
                .when()
                .post("/films");

        System.out.println(postResponse.getBody().asPrettyString());

    assertEquals(201,postResponse.getStatusCode());

    }

@Test
    public void get_films_deserialization(){

        RestAssured.baseURI = BASE_URI;
        String filmId = "2baf70d1-42bb-4437-b551-e5fed5a87abe";
    Response getResponse =
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization",BASE_URI)
                .accept(ContentType.JSON)
                .when()
                .pathParam("id",filmId)
                .get("/films/{id}");

    Gson gson = new Gson();
    Films films = gson.fromJson(getResponse.asString(),Films.class);
    System.out.println(getResponse.getStatusCode());
    System.out.println(films.toString());
    }
}










