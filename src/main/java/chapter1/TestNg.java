

/*
* 1.Setup
* 2.Test Steps
* 3. Close
* TestNg will not have a main method
*
* */


package chapter1;

        import com.tngtech.java.junit.dataprovider.*;
        import io.restassured.http.ContentType;
        import org.junit.Test;
        import org.junit.runner.RunWith;


        import static io.restassured.RestAssured.*;
        import static org.hamcrest.Matchers.equalTo;
     //   import org.testng.annotations.Test;

@RunWith(DataProviderRunner.class)
public class TestNg {

    @DataProvider
    public static Object[][] zipCodesAndPlaces(){
        return new  Object[][]{
                {"us","90210","Beverly Hills"},
                {"us","12345","Schenectady"},
                {"ca","B2R","Waverley"}
        };

    }


    @Test
    @UseDataProvider("zipCodesAndPlaces")
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
