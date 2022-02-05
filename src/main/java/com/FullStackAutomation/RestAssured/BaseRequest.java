package com.FullStackAutomation.RestAssured;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseRequest {
	
	public static String sys_ID = "";
	
	@BeforeSuite
	public void init() {
		RestAssured.baseURI = "https://dev84647.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.preemptive().basic("admin", "Password@1");
	}

}
