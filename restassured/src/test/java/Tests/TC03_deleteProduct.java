package Tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC03_deleteProduct {
	
	@Test
	public void deleteProduct()
	{
		RestAssured.baseURI= "http://localhost:8080/api/productlist/v1";		
		RequestSpecification httpRequest = RestAssured.given();
		
        Map<String,Object> requestParams = new HashMap<String,Object>();
		
		requestParams.put("productId", "5");
		
		
		List<Map<String,Object>> jsonArrayPayload = new ArrayList<>();
		
		jsonArrayPayload.add(requestParams);
		System.out.println("Json is" +jsonArrayPayload );
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(jsonArrayPayload);
		
		Response response = httpRequest.request(Method.POST,"/deleteproduct");	
		
		String responseBody = response.getBody().asString();
		
		System.out.println("Response body : " + responseBody);	
		
		int statusCode = response.getStatusCode();
		System.out.println("status code:" +statusCode);
		String successCode= response.jsonPath().get("statusMessage");
		System.out.println("response is:" +successCode);
		

}
	
}
