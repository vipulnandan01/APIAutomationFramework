package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilters;
import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseService {//wrapper for Rest Assured!!
	//Base URI
	//Creating the request
	//handling the response
	
	private static final String BASE_URL="http://64.227.160.186:8080";
	
	private RequestSpecification requestSpecification;
	
	//This static block will be executed only once and it will be available for everyone
	//It is not put inside the constructor because if we do parallel execution, the constructor will be called everytime.
	static {
		RestAssured.filters(new LoggingFilters());
	}
	
	public BaseService() {
		requestSpecification=given().baseUri(BASE_URL);
	}
	
	// Abstract -> child defines base path only
	protected abstract String getBasePath();
	
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer "+token);
	}

	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}
	
	protected Response putRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
}
