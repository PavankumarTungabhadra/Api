package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Pojo.location;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Utils;
import resources.payLoad;

public class StepDefinition extends Utils{
	static RequestSpecification res;
	static Response response;
	static JsonPath js;
	static String Place_Id;
	static String resp ;
	
	
	@Given("AddPlaceAPI payload with {string} {string} {string} {string} {string} {string} {string}")
	public void add_place_api_payload_with(String name, String language, String address, String PhoneNumber, String Website, String Type1, String Type2) throws IOException {
		  
		
		res= given().spec(requestSpecBiilder()).body(payLoad.createPayload(name, language,address,PhoneNumber,Website,Type1,Type2));

	}
	
	@When("user calls {string} with {string} https request")
	public void user_calls_with_https_request(String resourceAPI,String Method) {
	    // Write code here that turns the phrase above into concrete actions
		
			APIResources ApiRes = APIResources.valueOf(resourceAPI);
			System.out.println(ApiRes);
			//String resource = ApiRes.getResourceAPI();
			
			if (Method.equalsIgnoreCase("POST")) 
				 response = res.when().post(ApiRes.getResourceAPI()).then().extract().response();
			else if (Method.equalsIgnoreCase("GET")) 
				response= res.when().get(ApiRes.getResourceAPI()).then().extract().response();			
			
	}
	@Then("place should be sucessfully added with statuscode {int}")
	public void place_should_be_sucessfully_added_with_statuscode(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
		
	   
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedString) {
	  
		
		String value = Jsonpath(response, keyValue);
		System.out.println(value);
		assertEquals(value, expectedString);
		
		 
	}

	@Then("verify place_Id  created maps to {string}  using {string}")
	public void verify_place_id_is_created_maps_to_using(String name, String resource) throws IOException {
		Place_Id=Jsonpath(response, "place_id");
		System.out.println(Place_Id);
		System.out.println(name);
		String reqName="name";
		 // RestAssured.baseURI="https://rahulshettyacademy.com/";
		 res= given().spec(requestSpecBiilder()).queryParam("place_id", Place_Id);
		  user_calls_with_https_request(resource, "GET");
		  
			 String ActName=Jsonpath(response, reqName);
			System.out.println(ActName);
			assertEquals(ActName, name);
			 
		  


	}
	@Given("DeletePlaceAPI payLoad")
	public void delete_place_api_pay_load() throws IOException {
	    res=given().spec(requestSpecBiilder()).body(payLoad.DeletePlacePayLoad(Place_Id)
	    		);
	}

}