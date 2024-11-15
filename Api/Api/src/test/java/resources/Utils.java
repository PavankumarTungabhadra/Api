package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	 static RequestSpecification reqSpec ;
	
	public static String Jsonpath(Response response, String KeyValue)
	{
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		
		return js.get(KeyValue).toString();
		
		
	}
	
	public  RequestSpecification requestSpecBiilder() throws IOException
	{
		
		if (reqSpec==null) {
			
		
		
		PrintStream log = new PrintStream(new FileOutputStream("loggin.txt"));
		
	 reqSpec = new RequestSpecBuilder()
			.setBaseUri(globalProperty()).addQueryParam("key", "qaclick123")
			.setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(log))
			.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
	 	return reqSpec;
		}
		return reqSpec;
		
	
	}

	
	public static String globalProperty() throws IOException
	{
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//globalData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String BaseUri = prop.getProperty("baseUri").toString();
		return BaseUri;
		
	}
	
	
	
}
