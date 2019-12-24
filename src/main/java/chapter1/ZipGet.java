package chapter1;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//import org.testng.annotations.Test;



public class ZipGet {
    @Test
    public void requestUsZipcode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {
                given().
                        log().all().
                when().
                get("http://api.zippopotam.us/us/90210").
                then().
                        log().body().
                        assertThat().body("places[0].'place name'", equalTo("Beverly Hills")).//gpath is used to identify the element and hamcrest matcher validates (equalTo, hasItem, hasSize, not(equalTo(X))
                        assertThat().statusCode(200).
                        assertThat().contentType(ContentType.JSON);
       // System.out.println(get("http://api.zippopotam.us/us/90210"));

    }

}
