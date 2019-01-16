import dogsmanager.model.Dog;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SystemRESTTest {
    public static final String BASE_URI = "http://127.0.0.1:8181/dogs";

    @Test
    public void verifyGetByIdRequest() throws Exception {
        Dog[] arrayOfDogs = given()
                .when()
                .get(BASE_URI + "allDogs")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().body().as(Dog[].class);

        Dog actualDog = given().baseUri(BASE_URI + arrayOfDogs[0].getId())
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().body().as(Dog.class);

        Assert.assertEquals("Get request works incorrectly",
                actualDog, arrayOfDogs[0]);
    }
}

