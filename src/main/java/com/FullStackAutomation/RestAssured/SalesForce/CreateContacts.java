package com.FullStackAutomation.RestAssured.SalesForce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateContacts extends BaseClass {
	
	@Test
	public void createContact() {
		Response response = given()
		.log().all()
		.contentType(ContentType.JSON)
		.when()
		.body("{\r\n"
				+ "    \"FirstName\": \"Vel\",\r\n"
				+ "    \"LastName\": \"Sam\"\r\n"
				+ "}")
		.post("/services/data/v20.0/sobjects/Contact")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(201)
		.extract()
		.response();
				
		JsonPath jsonPath = response.jsonPath();
		contactID =  jsonPath.getString("id");
	}

}
