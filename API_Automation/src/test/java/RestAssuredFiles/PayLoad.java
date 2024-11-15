package RestAssuredFiles;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.location;


public class PayLoad {
	
	public static String AddPlace() {
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Tungabhadra\",\r\n"
				+ "  \"phone_number\": \"(+91) 9945644665\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
		
	}
	
	public static  String UpdatePlace(String NewAddress,String Place_Id)
	{
		return "{\r\n"
				+ "\"place_id\":\""+Place_Id+"\",\r\n"
				+ "\"address\":\""+NewAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String CoursePrice()
	{
		return "{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 2510,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Appium\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Java\",\r\n"
				+ "\r\n"
				+ "\"price\": 70,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"SQL\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}";
		
	}
	
	public  static String AddBookLibreary( String isbn, String aisle)
	{
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		
	}
	public static String JiraPayload()
	{
		return "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM1\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"Text area not intracting\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public  static  Pojo.AddPlace createPayload()
	{
		AddPlace addplace=new AddPlace();
		addplace.setAccuracy(60);
		addplace.setAddress("Tungabhadra, 6456, Raichur");
		addplace.setLanguage("Kannada-IN");
		addplace.setName("Pavankumar T");
		addplace.setPhone_number("(+91) 9945644557");
		addplace.setWebsite("htttps://Tunga@gmail.com");
		List<String>myList=new ArrayList<String>();
		myList.add("Apache RTR");
		myList.add("Ertiga");
		addplace.setTypes(myList);
		
		location loc=new location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		addplace.setLocation(loc);
		return addplace;
	}
	
	public static String LoginPayLoad() {
		return "{\r\n"
				+ "    \"userEmail\": \"postman.91@gmail.com\",\r\n"
				+ "    \"userPassword\": \"Tunga@6456\"\r\n"
				+ "}";
	}

}
