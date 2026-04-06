package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest2 {
	
	@Test(description="Verify if Login API is working")
	public void loginTest()
	{
		
		//This is called as service object model (SOA) just like in UI we use POM
		
		LoginRequest loginRequest= new LoginRequest("vipulnandan", "Welcome@123");
		String payload="{\"username\": \"vipulnandan\",\"password\": \"Welcome@123\"}";
		
		AuthService authservice= new AuthService();
		Response response= authservice.login(loginRequest);
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getId());
		
		Assert.assertTrue(loginResponse.getToken()!=null);
		Assert.assertEquals(loginResponse.getEmail(), "nandan.vipul2@gmail.com");
		Assert.assertEquals(loginResponse.getId(), 4913);
		
	}

}
