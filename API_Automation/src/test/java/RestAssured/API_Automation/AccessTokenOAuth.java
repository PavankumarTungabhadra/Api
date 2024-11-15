package RestAssured.API_Automation;

import org.testng.annotations.Test;

import ApiPojoGetCourses.GetCourse;
import RestAssuredFiles.ReUsableMethods;
import groovyjarjarantlr4.v4.parse.ANTLRParser.id_return;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers.*;

public class AccessTokenOAuth {

	
	@Test
	public void GetCourses()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response=given().formParam("client_id", ReUsableMethods.AccessTokenCredentials())
		.formParam("client_secret", ReUsableMethods.ClientScrete())
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().post("oauthapi/oauth2/resourceOwner/token")
		.then().log().all().extract().response().asString();
		
		JsonPath js = ReUsableMethods.JsonPath(response);
		String Id = js.get("access_token").toString();
		///get course
		
		GetCourse gc = given().queryParam("access_token", Id).when()
		.get("oauthapi/getCourseDetails").then().log().all().extract().response().as(GetCourse.class);
		
		System.out.println(gc.getExpertise());
		System.out.println(gc.getInstructor());
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getUrl());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		System.out.println(gc.getCourses().getApi().get(1).getPrice());
		
		
		int count=gc.getCourses().getApi().size();
		
		for (int i = 0; i < count; i++) {
			String title = gc.getCourses().getApi().get(i).getCourseTitle();
			String price = gc.getCourses().getApi().get(i).getPrice();
			
			System.out.println(title);
			System.out.println(price);
		}
		
	}
}
