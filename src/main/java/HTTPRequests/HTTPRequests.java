package HTTPRequests;

import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import javax.swing.*;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class HTTPRequests {

    int id;

    @Test(priority = 1)
    public void test1() {
        given()
                .when().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200).body("page", equalTo(2))
                .log().all();
    }

    @Test(priority = 2)
    public void test2() {

        HashMap<String, String> data = new HashMap<>();
        data.put("name", "himanshu");
        data.put("job", "sdet");

        id = given().contentType("application/json").body(data)
                .when().post("https://reqres.in/api/users").jsonPath().getInt("id");
//                .then().statusCode(201)
//                .log().all();
        System.out.println("id= " + id);
    }

    @Test(priority = 3, dependsOnMethods = {"test2"})
    public void test3() {

        HashMap<String, String> data = new HashMap<>();
        data.put("name", "himanshu jadoun");
        data.put("job", "SDE");

        given().contentType("application/json").body(data)
                .when().put("https://reqres.in/api/users/" + id)
                .then().statusCode(200)
                .log().all();

    }

    @Test(priority = 4, dependsOnMethods = {"test2"})
    public void test4() {
        given().when().delete("https://reqres.in/api/users/" + id).then().statusCode(204).log().all();
    }
}
