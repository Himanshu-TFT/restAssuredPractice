package CaptureCookiesAndHeaders;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import javax.swing.*;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Header {

    //validate header content
    @Test
    public void test1() {
        given()
                .when().get("https://www.google.com/")
                .then().header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Content-Encoding", "gzip")
                .log().body();
    }

    //fetch header value
    @Test
    public void test2(){

       Response res= given()
                .when().get("https://www.google.com/");
       String headerValue= res.getHeader("Content-Type");
        System.out.println(headerValue);
    }

    //fetch all header values
    @Test
    public void test3(){
        Response res= given()
                .when().get("https://www.google.com/");

        Headers myHeaders= res.getHeaders();
        for(io.restassured.http.Header hd: myHeaders){
            System.out.println(hd.getName()+" = "+hd.getValue());
        }

    }

}

