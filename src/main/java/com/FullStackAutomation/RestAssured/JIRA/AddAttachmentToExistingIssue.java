package com.FullStackAutomation.RestAssured.JIRA;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonPathGsonObjectDeserializer;
import io.restassured.response.Response;

public class AddAttachmentToExistingIssue {
	
	@Test
	public static void addAttachmentToExistingIssue(String key) {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/3/issue/"+key+"/attachments";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "c2a3HNfBdezxFfrPkUCm16F4");
		Response reponse = RestAssured
				.given()
				.header("X-Atlassian-Token", "no-check")
				.multiPart(new File(".\\testdata\\Software-Bug.jpg"))
				.post();
		System.out.println(reponse.getStatusCode());
		reponse.prettyPrint();
	}

}
