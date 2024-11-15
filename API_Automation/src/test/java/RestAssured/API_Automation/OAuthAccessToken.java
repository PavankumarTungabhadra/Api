package RestAssured.API_Automation;

import org.testng.annotations.Test;

import Pojo.GetCourse;
import Pojo.api;
import Pojo.courses;
import RestAssuredFiles.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.List;

public class OAuthAccessToken {
	
	@Test
	public void getDetails() {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response = given().formParam("client_id", ReUsableMethods.AccessTokenCredentials()).
		formParam("client_secret", ReUsableMethods.ClientScrete())
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust").when().post("oauthapi/oauth2/resourceOwner/token")
		.then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js = ReUsableMethods.JsonPath(response);
		String accessToken = js.get("access_token").toString();
		
		// getDetails
		
		GetCourse gc = given().queryParam("access_token", accessToken)
		.when().get("oauthapi/getCourseDetails").then().log().all()
		.statusCode(401).extract().response().as(GetCourse.class);
		
//		JsonPath js1 = ReUsableMethods.JsonPath(response2);
//		String inst = js1.get("instructor").toString();
//		System.out.println(inst);
		
		System.out.println(gc.getInstructor());
		System.out.println(gc. getLinkedIn());
		System.out.println(gc.getUrl());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		System.out.println(gc.getCourses().getApi().get(1).getPrice());
		List<api> apiCourses = gc.getCourses().getApi();
		int count=apiCourses.size();
		
		for (int i = 0; i < count; i++) {
			
			String title = apiCourses.get(i).getCourseTitle();
			if (title.equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println( apiCourses.get(i).getPrice());
				
			}
		}
	
		
		
	}

}
