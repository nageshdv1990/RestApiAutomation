
package chapter1;

        import com.tngtech.java.junit.dataprovider.*;
        import io.restassured.builder.RequestSpecBuilder;
        import io.restassured.builder.ResponseSpecBuilder;
        import io.restassured.http.ContentType;
        import io.restassured.specification.RequestSpecification;
        import io.restassured.specification.ResponseSpecification;
        import org.junit.BeforeClass;
        import org.junit.Test;
        import org.junit.runner.RunWith;

        import static io.restassured.RestAssured.*;
        import static org.hamcrest.Matchers.equalTo;

        @RunWith(DataProviderRunner.class)
public class OptimizingTests {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass
    public static void createRequestSpecification(){
        requestSpec = new RequestSpecBuilder().setBaseUri("http://api.zippopotam.us").build();

    }

    @BeforeClass
    public static void createResponseSpecification(){
        responseSpec =  new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }

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

        String placeName=
        given().
                spec(requestSpec).
                pathParam("countryCode", countryCode).pathParam("zipCode",zipCode).
                log().all().
        when().
                get("{countryCode}/{zipCode}").
        then().
                spec(responseSpec).
                log().body().
                assertThat().body("places[0].'place name'",equalTo(location)).
                and().
                extract().path("places[0].'place name'");
                //assertThat().contentType(ContentType.JSON).
                // assertThat().statusCode(200).

        System.out.println(placeName);
    }
}
