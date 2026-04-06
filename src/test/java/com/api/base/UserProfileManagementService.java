package com.api.base;

import com.api.models.request.ProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService {
	
	@Override
	protected String getBasePath() {
		return "/api/users/";
	}
	
	//private static final String BASE_PATH="/api/users/";
	
	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(getBasePath()+"profile");
	}
	
	public Response updateProfile(String token,ProfileRequest payload)
	{
		setAuthToken(token);
		return putRequest(payload, getBasePath()+"profile");
	}
	
	
}
