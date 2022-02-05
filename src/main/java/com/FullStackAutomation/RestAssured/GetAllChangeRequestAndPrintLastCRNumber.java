package com.FullStackAutomation.RestAssured;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllChangeRequestAndPrintLastCRNumber {
	
	@Test
	public void getAllChangeRequest() {
		RestAssured.baseURI = "https://dev84647.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Password@1");
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "sys_id, short_description, category, number")
				.get();
		response.prettyPrint();
		JsonPath jsonPath = response.jsonPath();
		List<String> list = jsonPath.getList("result.number");
		System.out.println(list.get(list.size()-1));
		
		
	}

}
