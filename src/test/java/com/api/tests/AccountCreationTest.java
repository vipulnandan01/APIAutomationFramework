package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description = "Verify if the new user gets registered")
	public void createAccountTest() {
		
		SignUpRequest signUpRequest= new SignUpRequest.Builder()
		.userName("Ravi22112")
		.email("ravi22112@gmail.com")
		.firstName("Ravi")
		.lastName("Singh")
		.password("Ravi22112")
		.mobileNumber("6666666662")
		.build();
		
		AuthService authService= new AuthService();
		Response response= authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		
	}

}
