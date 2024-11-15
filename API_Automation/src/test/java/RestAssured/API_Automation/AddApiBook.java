package RestAssured.API_Automation;

import org.testng.annotations.Test;

import RestAssuredFiles.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

import static  io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AddApiBook {
	
	@Test
	public void AddBook() throws IOException {
		RestAssured.baseURI="http://216.10.245.166";
	given().header("Content-Type", "application/json")
		.body(new String(Files.readAllBytes(Paths.get("C://Users//tunga//Downloads//AddLibAdd.json"))))
		.when().post("Library/Addbook.php").then().log().all().assertThat().
		statusCode(200).body("Msg", equalTo("Book Already Exists"));
//		extract().response().asString();
	 
//	JsonPath js = ReUsableMethods.JsonPath(response);
//	 String id = js.get("ID").toString();
//	System.out.println(id);
	}

}
