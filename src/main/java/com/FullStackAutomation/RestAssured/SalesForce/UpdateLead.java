package com.FullStackAutomation.RestAssured.SalesForce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UpdateLead extends BaseClass {
	
	@Test(dependsOnMethods = {"com.FullStackAutomation.RestAssured.SalesForce.CreateLead.createLead"})
	public void updateLead() {
		Response response = given()
		.log().all()
		.contentType(ContentType.JSON)
		.when()
		.body("{\r\n"
				+ "    \"MobilePhone\": \"6621230251\"\r\n"
				+ "}")
		.patch("/services/data/v20.0/sobjects/Lead/"+leadID)
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(204)
		.extract()
		.response();		
		
		GetLead.getLead();
	}

}
