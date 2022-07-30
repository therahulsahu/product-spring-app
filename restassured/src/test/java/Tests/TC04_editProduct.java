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
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC04_editProduct {
	
	@Test
	public void editProduct(){
		
		RestAssured.baseURI= "http://localhost:8080/api/productlist/v1";		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request payload along with POST request
		
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("productId", "5");
		requestParams.put("productName", "Iphone");
		requestParams.put("productPrice", "85000");
		requestParams.put("productDesc", "Good storage");
		requestParams.put("productQuantity", "1");
		requestParams.put("productType", "Mobile");
		
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
         Response response = httpRequest.request(Method.POST,"/updateProduct");	
		
		String responseBody = response.getBody().asString();
		
		System.out.println("Response body : " + responseBody);	
		
		int statusCode = response.getStatusCode();
		System.out.println("status code:" +statusCode);

		String successCode= response.jsonPath().get("statusMessage");
		System.out.println("response is:" +successCode);
	}

}
