package ParsingJSONReponseData;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class ParsingJSONResponseData {
    @Test(priority = 1)
    public void test1(){
        given().contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/users?page=2&id=8")
                .then().statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("data.id",equalTo(8))
                .log().body();
    }

    @Test(priority = 2)
    public void test2(){
        Response res= given().contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/users?page=2&id=8");

        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
        Assert.assertEquals(res.jsonPath().get("data.id").toString(),"8");
    }

    //JSON object class
    @Test
    public void test3(){
        String ids="";

        Response res= given().contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/users");

        JSONObject jo= new JSONObject(res.body().asString());
        for(int i=0; i<jo.getJSONArray("data").length(); i++){
            ids= jo.getJSONArray("data").getJSONObject(i).get("id").toString();
        }
        Assert.assertTrue(ids.contains("6"),"id 6 is present");
    }


    @Test
    public void test()
    {
        Response res = given().contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/users?page=2&id=8");
        int statusCode = res.statusCode();
        Assert.assertEquals(200, statusCode);
        JsonPath js = res.jsonPath();
        System.out.println(js.get("data.id").toString());
    }


}
