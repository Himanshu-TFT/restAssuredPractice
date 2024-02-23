package WaysToCreatePOSTRequestBody;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class WaysToCeatePOSTRequestBody {

    //1) POST request body using hashmap
    //2) POST request body using Org.JSON
    //3) POST request body using POJO class
    //4) POST request body using external json file data

    @Test(priority = 1)
    public void test1(){
        HashMap map = new HashMap<>();
        map.put("name", "hexi");
        map.put("job","sdet");
        map.put("id","45");
        given().contentType("application/json").body(map).
                when().post("https://reqres.in/api/users")
                .then().statusCode(201)
                .body("name",equalTo("hexi"))
                .body("job",equalTo("sdet"))
                .header("Content-Type",equalTo("application/json; charset=utf-8"))
                .log().all();

    }

    @Test(priority = 2, dependsOnMethods = {"test1"})
    public void test2(){
        given()
                .when().delete("https://reqres.in/api/users/45")
                .then().statusCode(204).log().all();
    }

    //2) POST request body using Org.JSON
    @Test(priority = 3)
    public void test3(){
        JSONObject data = new JSONObject();
        data.put("name", "sam");
        data.put("job", "SDE");
        data.put("id","45");

        given().contentType("application/json").body(data.toString()).
                when().post("https://reqres.in/api/users")
                .then().statusCode(201)
                .body("name",equalTo("sam"))
                .body("job",equalTo("SDE"))
                .header("Content-Type",equalTo("application/json; charset=utf-8"))
                .log().all();

    }

    @Test(priority = 4, dependsOnMethods = {"test3"})
    public void test4(){
        given()
                .when().delete("https://reqres.in/api/users/45")
                .then().statusCode(204).log().all();
    }

    //3) POST request body using POJO(Pain Old java Object) class
    @Test(priority = 5)
    public void test5(){
       POJO_POST_request data = new POJO_POST_request();
       data.setName("himanshu");
       data.setJob("SDET");
       data.setId("45");

        given().contentType("application/json").body(data).
                when().post("https://reqres.in/api/users")
                .then().statusCode(201)
                .body("name",equalTo("himanshu"))
                .body("job",equalTo("SDET"))
                .header("Content-Type",equalTo("application/json; charset=utf-8"))
                .log().all();
    }

    @Test(priority = 6, dependsOnMethods = {"test5"})
    public void test6(){
        given()
                .when().delete("https://reqres.in/api/users/45")
                .then().statusCode(204).log().all();
    }

    //4) POST request body using external json file data
    @Test(priority = 7)
    public void test7() throws FileNotFoundException {
        File f= new File("C:\\Users\\Himanshu Jadoun\\Desktop\\java selenium\\RestAssuredTraining\\src\\main\\java\\WaysToCreatePOSTRequestBody\\Body.json");
        FileReader fr=new FileReader(f);
        JSONTokener jt= new JSONTokener(fr);
        JSONObject data= new JSONObject(jt);


        given().contentType("application/json").body(data.toString()).
                when().post("https://reqres.in/api/users")
                .then().statusCode(201)
                .body("name",equalTo("himanshu"))
                .body("job",equalTo("SDET"))
                .header("Content-Type",equalTo("application/json; charset=utf-8"))
                .log().all();
    }

    @Test(priority = 8, dependsOnMethods = {"test7"})
    public void test8(){
        given()
                .when().delete("https://reqres.in/api/users/45")
                .then().statusCode(204).log().all();
    }
}
