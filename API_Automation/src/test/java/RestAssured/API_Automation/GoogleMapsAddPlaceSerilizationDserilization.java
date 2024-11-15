package RestAssured.API_Automation;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import Pojo.AddPlace;
import Pojo.AddPlaceStatus;
import Pojo.location;
import RestAssuredFiles.PayLoad;
import RestAssuredFiles.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers.*;

public class GoogleMapsAddPlaceSerilizationDserilization {
	
	@Test
	public void adddPlace()
	{
//		AddPlace addplace=new AddPlace();
//		addplace.setAccuracy(60);
//		addplace.setAddress("Tungabhadra, 6456, Raichur");
//		addplace.setLanguage("Kannada-IN");
//		addplace.setName("Pavankumar T");
//		addplace.setPhone_number("(+91) 9945644557");
//		addplace.setWebsite("htttps://Tunga@gmail.com");
//		List<String>myList=new ArrayList<String>();
//		myList.add("Apache RTR");
//		myList.add("Ertiga");
//		addplace.setTypes(myList);
//		
//		Location loc=new Location();
//		loc.setLat(-38.383494);
//		loc.setLng(33.427362);
		
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key",  "qaclick123").setContentType(ContentType.JSON).build();
		 RequestSpecification reqPart = given().spec(reqSpec).body(PayLoad.createPayload());
		
	AddPlaceStatus placeStatus = 
		reqPart.when().post("/maps/api/place/add/json").then().log().all().extract().response().as(AddPlaceStatus.class);
	
	System.out.println(placeStatus.getId());
	System.out.println(placeStatus.getPlace_id());
	System.out.println(placeStatus.getReference());
	System.out.println(placeStatus.getScope());
	System.out.println(placeStatus.getStatus());
	

	
	
	
	
		
		
		
		
		
	}
}
