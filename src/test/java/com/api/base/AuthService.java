package com.api.base;

import java.util.HashMap;
import java.util.Map;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {
	
	@Override
	protected String getBasePath() {
		return "/api/auth/";
	}
	
//	private static final String BASE_PATH="/api/auth/";
	
	public Response login(LoginRequest payload) {
		return postRequest(payload, getBasePath()+"login");//earlier- BASE_PATH+"login"
	}
	
	public Response signUp(SignUpRequest payload) {
		return postRequest(payload, getBasePath()+"signup");
	}
	
	public Response forgotPassword(String emailAddress) {
		Map<String, String> payload= new HashMap<>();
		payload.put("email", emailAddress);
		return postRequest(payload, getBasePath()+"forgot-password");
	}

}
