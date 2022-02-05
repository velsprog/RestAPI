package com.FullStackAutomation.RestAssured.SalesForce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteContacts extends BaseClass {
	
	@Test(dependsOnMethods = {"com.FullStackAutomation.RestAssured.SalesForce.CreateContacts.createContact"})
	public void deleteContact() {
		Response response = given()
		.log().all()
		.when()
		.delete("/services/data/v20.0/sobjects/Contact/"+contactID)
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(204)
		.extract()
		.response();		
	}

}
