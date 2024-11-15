package resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.location;

public class payLoad {
	
	public  static  Pojo.AddPlace createPayload(String name, String language, String address, String PhoneNumber, String Website,String Type1,String Type2)
	{
		AddPlace addplace=new AddPlace();
		addplace.setAccuracy(60);
		addplace.setAddress(address);
		addplace.setLanguage(language);
		addplace.setName(name);
		addplace.setPhone_number(PhoneNumber);
		addplace.setWebsite(Website);
		List<String>myList=new ArrayList<String>();
		myList.add(Type1);
		myList.add(Type2);
		addplace.setTypes(myList);
		
		location loc=new location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		addplace.setLocation(loc);
		return addplace;
	}
	
	public static String DeletePlacePayLoad(String Place_Id)
	{
		return "{\r\n"
				+ "    \"place_id\":\""+Place_Id+"\"\r\n"
				+ "}\r\n"
				+ "";
	}

}
