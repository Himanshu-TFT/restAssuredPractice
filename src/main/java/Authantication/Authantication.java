package Authantication;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import javax.swing.*;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Authantication
{
    //Basic authentication
   @Test
    public void testAuthantication1(){
       given().auth().basic("postman","password")
               .when().get("https://postman-echo.com/basic-auth")
               .then()
               .statusCode(200)
               .body("authenticated",equalTo(true))
               .log().all();
   }

    //Digest authentication
    @Test
    public void testAuthantication2(){
        given().auth().digest("postman","password")
                .when().get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    //preemptive authentication
    @Test
    public void testAuthantication3(){
        given().auth().preemptive().basic("postman","password")
                .when().get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    //bearer token authentication
    @Test
    public void testAuthentication4(){
       String token="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";
       given().header("Authorization","Bearer "+token)
               .when().get("https://api.github.com/user/repos")
               .then()
               .statusCode(200)
               .log().all();
    }

    //OAuth1 authentication
    @Test
    public  void testOAuth1Authentication5(){
//       given().auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate")
//               .when().get("url")
//               .then().statusCode(200)
//               .log().all();
    }

    //OAuth2 authentication
    @Test
    public  void testOAuth2Authentication6(){
        //       given().auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate")
//               .when().get("url")
//               .then().statusCode(200)
//               .log().all();
    }

    //API key authentication
    @Test
    public void testAuthentication(){
       given().when().then();
    }


}
