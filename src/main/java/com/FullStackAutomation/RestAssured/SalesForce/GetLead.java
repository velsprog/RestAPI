package com.FullStackAutomation.RestAssured.SalesForce;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetLead extends BaseClass {
	
	@Test(dependsOnMethods = {"com.FullStackAutomation.RestAssured.SalesForce.CreateLead.createLead"})
	public static void getLead() {
		given()
		.log().all()
		.when()
		.get("/services/data/v20.0/sobjects/Lead/"+leadID)
		.prettyPrint();
	}

}
