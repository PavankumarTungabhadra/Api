package RestAssured.API_Automation;

import java.util.Iterator;

import org.testng.annotations.Test;

import RestAssuredFiles.PayLoad;
import RestAssuredFiles.ReUsableMethods;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class ComplexJsonPath {
	@Test
	public void JsonNodes()
	{
		// TODO Auto-generated method stub

		// Print no of courses
		JsonPath js = ReUsableMethods.JsonPath(PayLoad.CoursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//print purchase amount
		
		int pruchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(pruchaseAmount);
		
		//print the title of the first course
		
		 String FirstCourseTitle = js.get("courses[0].title").toString();
		 System.out.println(FirstCourseTitle);
		 
		 //print All the courses title and their respective price
		 
		 for (int i = 0; i <count; i++) {
			 
			String Title = js.get("courses["+i+"].title").toString();
			int Price = js.getInt("courses["+i+"].price");
			int Copies = js.getInt("courses["+i+"].copies");
			System.out.println(Title +" ----->"+ Price+" No OfCopies-->"+Copies);
			
		}
		 
		 //print no of copies sold by Appium
		 
		 for (int i = 0; i < count; i++) {
			 
			 String Title = js.get("courses["+i+"].title").toString();
			 
			 if (Title.equalsIgnoreCase("Appium")) {
				int copies=js.getInt("courses["+i+"].copies");
				System.out.println("No of Copies sold==="+copies);
			}
			
		}
		 
		 int price=0;
		 int Copies=0;
		 int sumOfAllCorse=0;
		 for (int i = 0; i < count; i++) {
			
			 price= js.getInt("courses["+i+"].price");
		
			 
			 Copies=js.getInt("courses["+i+"].copies");
			 //sumOfCopies=sumOfCopies+count;
			 
			int Sum = price*Copies;
			sumOfAllCorse=Sum+sumOfAllCorse;
		}
		System.out.println(sumOfAllCorse);
		int PurchasedAmount=js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sumOfAllCorse, PurchasedAmount);
	}

}
