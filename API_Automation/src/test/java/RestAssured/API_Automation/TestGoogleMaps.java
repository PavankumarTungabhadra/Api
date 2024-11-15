package RestAssured.API_Automation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import RestAssuredFiles.PayLoad;
import RestAssuredFiles.ReUsableMethods;

public class TestGoogleMaps {
	//public static void main(String[] args) 
	@Test
	public void GoogleMaps()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		//Add Place
		String Response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(PayLoad.AddPlace()).when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP")).extract().response().asString();
		//System.out.println(Response);
//		JsonPath js=new JsonPath(Response);
		JsonPath js = ReUsableMethods.JsonPath(Response);
		String Place_Id = js.getString("place_id");
		System.out.println("Place id is ----> "+Place_Id);
		//Update Place
		String NewAddress = "70 winter walk, USA";
		given().log().all().queryParam("key", "Tunga1234").header("Content-Type","application/json").body(PayLoad.UpdatePlace(NewAddress,Place_Id)).when()
		.put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get Place
		String ActualAddress = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", Place_Id).when().get("/maps/api/place/get/json")
		.then().log().all().statusCode(200).extract().response().asString();
		
		 js=ReUsableMethods.JsonPath(ActualAddress);
		String ActualAddress1 = js.getString("address");
		System.out.println(ActualAddress1);
		Assert.assertEquals(NewAddress, ActualAddress1);
	}


}
