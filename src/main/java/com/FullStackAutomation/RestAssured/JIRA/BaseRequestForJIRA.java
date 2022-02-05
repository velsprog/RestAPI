package com.FullStackAutomation.RestAssured.JIRA;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseRequestForJIRA {
	
	@BeforeSuite
	public static void baseRequestForJIRA() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "aDJOHDSxvY7vZsL9coDw3316");
	}

}
