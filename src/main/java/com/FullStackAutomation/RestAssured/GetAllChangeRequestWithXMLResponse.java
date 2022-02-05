package com.FullStackAutomation.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllChangeRequestWithXMLResponse {
	
	@Test
	public void getAllChangeRequestWithXMLResponse() {
		RestAssured.baseURI = "https://dev84647.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Password@1");
		Response response = RestAssured
				.given()
				.accept(ContentType.XML)
				.queryParam("sysparm_fields", "sys_id, short_description, category, number")
				.get();
		response.prettyPrint();
	}

}
