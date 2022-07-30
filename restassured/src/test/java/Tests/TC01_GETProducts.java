package Tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_GETProducts {
	
	@Test
	public void getProductlist()
	{
		RestAssured.baseURI= "http://localhost:8080/api/productlist/v1";		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/getlist");
		
		String responseBody = response.getBody().asString();
		
		System.out.println("Response body : " + responseBody);
		
		//status code validation
		
		int statusCode = response.getStatusCode();
		System.out.println("status code:" +statusCode);
		
		Assert.assertEquals(statusCode,200);
		
		//status line verification
		
		String statusLine = response.getStatusLine();
		System.out.println("status line :" + statusLine);
		
		
		
		
	}

}
