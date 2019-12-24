package chapter1;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostExample {
    @Test
    public void requestUsZipcode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {
        PojoForPost p1 = new PojoForPost();//Serialization
        given().
                log().all().
                contentType(ContentType.JSON).
                body(p1).
                log().all().
        when().
                post("https://64bc0f13-4f16-4863-ac35-526cc3267edf.mock.pstmn.io/createProfile").
        then().
                assertThat().statusCode(201).
                log().body();
    }

}
