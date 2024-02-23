import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
public class dem1 {
    @Test
    public  void test(){
        Response res= given().when().get("url");
        System.out.println(res.body().toString());
        File f=  new File("");
        FileReader fr= FileReader(f);
        JSONTokener jt= new JSONTokener(fr);
        JSONObject jo=new JSONObject(fr);
        jo.get("");

    }
}
