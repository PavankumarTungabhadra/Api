package E2eApiAutomation;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ReUsableMethods {

	
	public static io.restassured.path.json.JsonPath JsonPath(String Variable)
	{
		JsonPath js=new JsonPath(Variable);
		return js;
	}

	public static String jiraToken()
	{
		return "Basic cGF2YW5rdW1hcnQ4NTVAZ21haWwuY29tOkFUQVRUM3hGZkdGMHRlcHkwazAzSUVoQkd4WExKQWlLeHV3c1dTZFhMRGNkSTVZUW8zZlZEc016WTAwbk5Sal9MRTV3aWhtQkhwRHUzdVZPQmxHcThXU0NZWk9VYlo0QWdUTGlHa3hxcjQ1ZlR5ZjQxU09LbXpPZzhfMGcybTBLNFFIWHdEODdXX3JyajlNY1ZDRkh4RjRWa05vRFRZTGxzRDVOTndDMHloamF0NFFybExybkUzVT1EQzc3RkRDNQ==";
	}
	
	public static String AccessTokenCredentials() {
		return "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com";
	}
	public static  String ClientScrete() {
		return "erZOWM9g3UtwNRj340YYaK_W";
	}
}

