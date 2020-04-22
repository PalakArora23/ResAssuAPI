package RestAssuredApi.RestAssuredApi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.*;

public class CreateFewEmployee {

	@Test
	void createemployee()
	{
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//responseobject
		
		JSONObject requestParam = new JSONObject(); 
		
//		requestParam.put("id","011");  
//		requestParam.put("employee_name", "User1");
//		requestParam.put("employee_salary", "320800");
//	    requestParam.put("employee_age", "21");
//		requestParam.put("profile_image", "");
		
	requestParam.put("name","user1");
		requestParam.put("salary","1000");  
	requestParam.put("age","21");
	
	requestParam.put("name","user2");
	requestParam.put("salary","3000");  
requestParam.put("age","23");
	
//		
		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestParam.toJSONString());
		Response respons = httprequest.request(Method.POST,"/create");
		
		// print response in console window
	String responseBody =	respons.getBody().asString();
	System.out.println("Response Body is :" +responseBody);
	
	//verify status code
	int Statuscode = respons.getStatusCode();
	System.out.println("Status Code is :" +Statuscode);
	Assert.assertEquals(Statuscode, 200);
	
	//verify status line
	String StatusLine = respons.getStatusLine();
	System.out.println("Status Line is :" +StatusLine);
	Assert.assertEquals(StatusLine, "HTTP/1.1 200 OK");
	
	}
}
