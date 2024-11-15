package RestAssured.API_Automation;

import org.testng.annotations.Test;



import RestAssuredFiles.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestJiraApi {
	
	@Test
	public void CreateJira() throws IOException
	{
		RestAssured.baseURI="https://pavankumart855.atlassian.net/";
		String response = given().header("Content-Type","application/json").
		header("Authorization", ReUsableMethods.jiraToken())
		.body(new String(Files.readAllBytes(Paths.get("C://Users/tunga//Downloads//CreateIssue.json"))))
		.when().post("rest/api/3/issue").then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = ReUsableMethods.JsonPath(response);
		String id = js.get("id").toString();
		
		//attach evidence
		
		String AttachmentResponse = given().pathParam("key", id).header("Authorization", ReUsableMethods.jiraToken())
		.header("X-Atlassian-Token","no-check").multiPart("file",new File("C://Users//tunga//Downloads//Madhu.jpg"))
		.when().post("rest/api/3/issue/{key}/attachments").then().log().all().statusCode(200)
		.extract().response().asString();
		JsonPath jsa = ReUsableMethods.JsonPath(AttachmentResponse);
		String filename = jsa.get("filename").toString();
		
		
		
		
	}

}
