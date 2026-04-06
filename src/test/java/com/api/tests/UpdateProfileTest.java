package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.BaseService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test
	public void updateProfileTest() {
		
		AuthService authService= new AuthService();
		Response response= authService.login(new LoginRequest("vipulnandan", "Welcome@123"));
		LoginResponse loginResponse= response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		
		System.out.println("----------------------------------------------------------------");
		
		UserProfileManagementService userProfileManagementService= new UserProfileManagementService();
		response=userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		UserProfileResponse userProfileResponse= response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(),"vipulnandan");
		
		System.out.println("----------------------------------------------------------------");
		
		ProfileRequest profileRequest= new ProfileRequest.Builder()
				.firstName("Vipul")
				.lastName("Nandan")
				.email("nandan.vipul2@gmail.com")
				.mobileNumber("8888888888")
				.build();
		
		response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
		
	}
}
