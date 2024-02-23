package SchemaValidation;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import javax.swing.*;
import java.io.File;
import java.util.HashMap;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class JSONSchemaValidation {

    @Test
    public void testApiJsonSchemaValidation() {
        given()
                .when().get("https://reqres.in/api/users")
                .then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Himanshu Jadoun\\Desktop\\java selenium\\RestAssuredTraining\\src\\main\\java\\SchemaValidation\\sampleTestSchema.json")));
    }

}
