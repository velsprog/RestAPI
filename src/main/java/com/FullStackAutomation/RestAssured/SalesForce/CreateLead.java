package com.FullStackAutomation.RestAssured.SalesForce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateLead extends BaseClass {
	
	@Test
	public void createLead() {
		Response response = given()
		.log().all()
		.contentType(ContentType.JSON)
		.when()
		.body("{\r\n"
				+ "    \"FirstName\": \"Test\",\r\n"
				+ "    \"LastName\": \"CreateLead\",\r\n"
				+ "    \"Company\": \"Sam Corp\"\r\n"
				+ "}")
		.post("/services/data/v20.0/sobjects/Lead")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(201)
		.extract()
		.response();
				
		JsonPath jsonPath = response.jsonPath();
		leadID =  jsonPath.getString("id");
	}

}
