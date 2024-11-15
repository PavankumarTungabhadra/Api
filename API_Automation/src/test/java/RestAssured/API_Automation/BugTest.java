package RestAssured.API_Automation;

import org.testng.annotations.Test;

import RestAssuredFiles.PayLoad;
import RestAssuredFiles.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class BugTest {

	@Test
	public void createTest() {
		RestAssured.baseURI="https://pavankumart855.atlassian.net/";
		String response = given().header("Content-Type","application/json")
		.header("Authorization",ReUsableMethods.jiraToken())
		.body(PayLoad.JiraPayload()).when().post("rest/api/3/issue").then()
		.log().all().statusCode(201).extract().response().asString();
		JsonPath js = ReUsableMethods.JsonPath(response);
		String ID = js.get("id").toString();
		
		
		//Attaching evidence to JIra Id
		
		given().pathParam("key", ID).
		header("X-Atlassian-Token","no-check")
		.header("Authorization",ReUsableMethods.jiraToken())
		.multiPart("file",new File("C://Users//tunga//Downloads//sai_Pallavi.jpeg")).log().all()
		.when().post("rest/api/3/issue/{key}/attachments").then().log().all().statusCode(200);
		
		given().pathParam("key", ID).header("Authorization",ReUsableMethods.jiraToken())
		.header("Accept","application/json").when().get("/rest/api/3/issue/{key}").then().log().all().assertThat().statusCode(200);
	}
}
