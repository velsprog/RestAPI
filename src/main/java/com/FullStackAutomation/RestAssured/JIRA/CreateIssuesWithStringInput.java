package com.FullStackAutomation.RestAssured.JIRA;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIssuesWithStringInput {
	
	@DataProvider(name = "fetchData")
	public String[] getData() {
		String[] data = new String[2];
		data[0] = ".\\testdata\\Bug.json";
		data[1] = ".\\testdata\\story.json";
		return data;
	}
	
	@Test(dataProvider = "fetchData")
	public void createIssuesWithStringInput(String bodyContent) {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "c2a3HNfBdezxFfrPkUCm16F4");
		Response response = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.body(new File(bodyContent))
				.post();
		
		System.out.println(response.statusCode());
		//System.out.println(response.prettyPrint());
		JsonPath jsonPath = response.jsonPath();
		System.out.println(jsonPath.get("key"));
		String key = jsonPath.get("key");
		AddAttachmentToExistingIssue.addAttachmentToExistingIssue(key);
	}

}
