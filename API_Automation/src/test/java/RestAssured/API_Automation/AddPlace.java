package RestAssured.API_Automation;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;

public class AddPlace {
public static void main(String[] args) {
	
	RestAssured.baseURI="https://rahulshettyacademy.com";
	given().log().all().queryParam("key", "Dhanu1009").header("Content-Type","application/json")
	.body("{\r\n"
			+ "  \"location\": {\r\n"
			+ "    \"lat\": -38.383494,\r\n"
			+ "    \"lng\": 33.427362\r\n"
			+ "  },\r\n"
			+ "  \"accuracy\": 50,\r\n"
			+ "  \"name\": \"Dhanalaxmi\",\r\n"
			+ "  \"phone_number\": \"(+91) 9945644665\",\r\n"
			+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
			+ "  \"types\": [\r\n"
			+ "    \"shoe park\",\r\n"
			+ "    \"shop\"\r\n"
			+ "  ],\r\n"
			+ "  \"website\": \"http://google.com\",\r\n"
			+ "  \"language\": \"Kannada\"\r\n"
			+ "}\r\n"
			+ "").when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200);
}
}
