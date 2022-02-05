package com.FullStackAutomation.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateChangeRequest extends BaseRequest {
	
	@Test (dependsOnMethods = {"com.FullStackAutomation.RestAssured.CreateChangeRequest.createChangeRequest"})
	public void udateChangeRequest() {
		Response response = RestAssured
				.given()
				.log().all()
				.contentType(ContentType.JSON)
				.pathParam("sysID", sys_ID)
				.body("{\"short_description\":\"short description updated\",\"description\":\"description updated\",\"priority\":\"3\",\"risk\":\"2\"}")
				.put("{sysID}");
		System.out.println(response.getStatusCode());
		response.prettyPrint();
	}
	

}
