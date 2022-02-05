package com.FullStackAutomation.RestAssured.SalesForce;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseClass {
	
	public static String contactID;
	public static String leadID;
	
	@BeforeSuite
	public void init() {
		RestAssured.baseURI = "https://testleaf59-dev-ed.my.salesforce.com";
		RestAssured.authentication = RestAssured.oauth2("00D5j000007MURS!ARQAQIIU42DFogQJAvSd_qvddNzhdwC5nzAsbKpPi6iObW69grYY.7nYHbBCfnDJvhdPnumMc77SSGI23MyTI..e5k77rNp.");	

	}

}
