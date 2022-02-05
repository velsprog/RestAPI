package com.FullStackAutomation.RestAssured.JIRA;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllIssuesFromJIRAWith20RecordsLimit {
	
	@Test
	public void getAllIssuesFromJIRAWith20RecordsLimit() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/search";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "aDJOHDSxvY7vZsL9coDw3316");
		Response response = RestAssured
				.given()
				.log().all()
				.accept(ContentType.JSON)
				.queryParam("jql", "project=RS")
				.queryParam("maxResults", "1")
				//.queryParam("fields", "key")
				.get();
		//response.prettyPrint();
		//System.out.println(response.body());
		System.out.println(response.getStatusCode());	
		System.out.println(response.getStatusLine());
		
	}

}
