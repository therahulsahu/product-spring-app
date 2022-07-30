package Tests;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_POST_request {
	
@Test
	public void createProductlist()
	{
		RestAssured.baseURI= "http://localhost:8080/api/productlist/v1";		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request payload along with POST request
		
		Map<String,Object> requestParams = new HashMap<String,Object>();
		
		requestParams.put("productId", "5");
		requestParams.put("productName", "Iphone");
		requestParams.put("productPrice", "83000");
		requestParams.put("productDesc", "High end camera");
		requestParams.put("productQuantity", "1");
		requestParams.put("productType", "Mobile");
		
		List<Map<String,Object>> jsonArrayPayload = new ArrayList<>();
		
		jsonArrayPayload.add(requestParams);
		System.out.println("Json is" +jsonArrayPayload );
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(jsonArrayPayload);
	
		
		Response response = httpRequest.request(Method.POST,"/createproduct");	
		
		String responseBody = response.getBody().asString();
		
		System.out.println("Response body : " + responseBody);	
		
		int statusCode = response.getStatusCode();
		System.out.println("status code:" +statusCode);
		
		String successCode= response.jsonPath().get("response");
		Assert.assertEquals(successCode,"Successfully product created");			
		
	}

}
