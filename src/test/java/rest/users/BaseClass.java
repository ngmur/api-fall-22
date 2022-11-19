package rest.users;

import com.github.javafaker.Faker;
import com.google.gson.Gson;


import io.cucumber.java.Before;
import io.restassured.RestAssured;
import utils.ConfigReader;

public abstract class BaseClass {
    private static final String apiHost = ConfigReader.getProperty("apiHost");
    private static final String apiVersion = ConfigReader.getProperty("apiVersion");
    public static final String token = ConfigReader.getProperty("token");
    public static final Faker faker = new Faker();

    public static final Gson gson = new Gson();

 @Before
    public void baseUrlSetup() {

        RestAssured.baseURI = apiHost + apiVersion;
    }



}