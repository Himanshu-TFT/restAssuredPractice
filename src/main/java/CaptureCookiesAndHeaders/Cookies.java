package CaptureCookiesAndHeaders;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Cookies {

    //validating cookie value
    @Test
    public void test1(){
    given()
            .when().get("https://www.google.com/")
            .then().cookie("AEC","Ae3NU9NTyD2Xy31iug5lRvGuzaaRNwNB_Jigr0EECeXvDIikfi80sorauws")
            .log().all();
    }

    //fetching cookie value
    @Test
    public void test2(){
        Response res =
                given()
                .when().get("https://www.google.com/");
        String cookie_value = res.getCookie("AEC");
        System.out.println(cookie_value);
    }

    //fetching values of all cookies
    @Test
    public void test3(){
        Response res =
                given()
                        .when().get("https://www.google.com/");

        Map<String,String> cookies_values = res.getCookies();

        for(Map.Entry<String,String> cookie : cookies_values.entrySet())
        {
            System.out.println(cookie.getKey() + "=" + cookie.getValue());
        }

    }
}
