package com.FullStackAutomation.RestAssured.JIRA;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.FullStackAutomation.RestAssured.JIRA.POJO.Deserialization.GetASpecificIssue.GetIssue;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetASpecficIssue extends BaseRequestForJIRA {
	
	@Test
	public void getASpecficIssue() throws FileNotFoundException {
//		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue";
//		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "aDJOHDSxvY7vZsL9coDw3316");
		
		FileOutputStream fos = new FileOutputStream("log.txt");
		 RequestSpecification request = new RequestSpecBuilder()
		.setBaseUri("https://api-may2020.atlassian.net/rest/api/2/issue")
		.addQueryParam("fields", Arrays.asList("key","name","priority","summary","description","fixVersions"))
		.addFilter(RequestLoggingFilter.logRequestTo(new PrintStream(fos)))
		.addFilter(ResponseLoggingFilter.logResponseTo(new PrintStream(fos)))
		.addPathParam("key", "RS-583")
		.addHeader("accept", "application/json").build();
		 
		 ResponseSpecification build = new ResponseSpecBuilder()
				 .build();
		
		GetIssue response = RestAssured
				.given()
				.log().all()
//				.accept(ContentType.JSON)
//				.pathParam("key", "RS-583")
//				.queryParam("fields", Arrays.asList("key","name","priority","summary","description","fixVersions"))
				.spec(request)
				.get("{key}")
				.then()
				.assertThat()
				.statusCode(200)
				.extract()
				.response()
				.as(GetIssue.class);
		//response.prettyPrint();
		System.out.println(response.getKey());
		System.out.println(response.getId());
		System.out.println(response.getFields().getSummary());
		System.out.println(response.getFields().getDescription());
		System.out.println(response.getFields().getFixVersions().get(0).getName());
		System.out.println(response.getFields().getFixVersions().get(0).isReleased());
	}

}
