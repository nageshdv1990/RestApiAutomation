

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
        import org.junit.AfterClass;
        import org.junit.BeforeClass;
      //  import org.junit.Test;
        import org.junit.runner.RunWith;
       // import org.testng.annotations.AfterClass;
        import org.testng.annotations.*;


        import static io.restassured.RestAssured.*;
        import static org.hamcrest.Matchers.equalTo;
        import org.testng.annotations.Test;

//@RunWith(DataProviderRunner.class)
public class TestNg {


   /* @DataProvider
    public static Object[][] zipCodesAndPlaces(){
        return new  Object[][]{
                {"us","90210","Beverly Hills"},
                {"us","12345","Schenectady"},
                {"ca","B2R","Waverley"}
        };

    }*/

    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before Every test method");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("After every test method");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After class");
    }

    @BeforeTest
    public static  void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public static void afterTest(){
        System.out.println("After Test");
    }

    /*@Test
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

    }*/

    @Test(priority=10)
    public void dummyTestForTestng1(){
        System.out.println("Dummy Test 1");
    }

    @Test(priority = 1)
    public void dummyTestForTestng2(){
        System.out.println("Dummy Test 2");
    }

    @Test(priority = 6)
    public void dummyTestForTestng3(){
        System.out.println("Dummy Test 3");
    }
}
