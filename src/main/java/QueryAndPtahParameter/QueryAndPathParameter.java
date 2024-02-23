package QueryAndPtahParameter;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import javax.swing.*;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class QueryAndPathParameter {

    String api="https://reqres.in/api/users?page=2&id=8";
    @Test
    public void test1(){
        given().pathParam("mypath","users")
                .queryParam("page",2)
                .queryParam("id",8)
                .when().get("https://reqres.in/api/{mypath}")
                .then().statusCode(200).log().all();
    }
}
