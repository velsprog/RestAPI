package com.FullStackAutomation.RestAssured.SalesForce;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllContacts extends BaseClass {
	
	@Test(dependsOnMethods = {"com.FullStackAutomation.RestAssured.SalesForce.CreateContacts.createContact"})
	public static void getallcontacts() {
		given()
		.log().all()
		.when()
		.get("/services/data/v20.0/sobjects/Contact/"+contactID)
		.prettyPrint();
	}

}
