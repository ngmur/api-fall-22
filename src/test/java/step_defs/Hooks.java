package step_defs;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import utils.ConfigReader;

public class Hooks {
    private static final String apiHost = ConfigReader.getProperty("apiHost");
    private static final String apiVersion = ConfigReader.getProperty("apiVersion");
    @Before
    public void baseUrlSetup() {

        RestAssured.baseURI = apiHost + apiVersion;
    }

}
