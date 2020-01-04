package chapter1;

import com.tngtech.java.junit.dataprovider.*;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class ParameterizedTests {

    @DataProvider
    public static Object[][] zipCodesAndPlaces(){
        return new  Object[][]{
                {"us","90210","Beverly Hills"},
                {"us","12345","Schenectady"},
                {"ca","B2R","Waverley"}
        };

    }

    @UseDataProvider("zipCodesAndPlaces")
    @Test
    public void parameterizedTests_positiveTests_expected200(String countryCode, String zipCode, String location) {
            given().
                pathParam("countryCode", countryCode).pathParam("zipCode",zipCode).
                log().all().
            when().
                get("http://api.zippopotam.us/{countryCode}/{zipCode}").
            then().
                log().body().
                assertThat().contentType(ContentType.JSON).
                assertThat().statusCode(200).
                assertThat().body("places[0].'place name'",equalTo(location));

    }
}
