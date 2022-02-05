package com.FullStackAutomation.RestAssured.SalesForce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteLead extends BaseClass {
	
	@Test(dependsOnMethods = {"com.FullStackAutomation.RestAssured.SalesForce.CreateLead.createLead"})
	public void deleteLead() {
		Response response = given()
		.log().all()
		.when()
		.delete("/services/data/v20.0/sobjects/Lead/"+leadID)
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(204)
		.extract()
		.response();		
	}

}
