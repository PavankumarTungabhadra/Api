package RestAssured.API_Automation;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RestAssuredFiles.PayLoad;
import RestAssuredFiles.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import  static io.restassured.RestAssured.*;
public class APILibrearies {
	

		@DataProvider(name="BookData")
		public Object[][] getData() {
			return new Object[][] {{"abc","123"},{"def","456"},{"ghi","789"}};
		}
		@Test(dataProvider = "BookData")
		public void AddBook(String Isbn, String aisle)
		{
			RestAssured.baseURI="http://216.10.245.166";
			String Response=given().header("Content-Type","application/json").body(PayLoad.AddBookLibreary(Isbn, aisle))
			.when().post("Library/Addbook.php").then().log().all().statusCode(200).extract().response().asString();
		JsonPath js = ReUsableMethods.JsonPath(Response);
		js.get("Msg");
			
		}
		
		
		
		
		
		
		
}
