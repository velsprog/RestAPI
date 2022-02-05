package com.FullStackAutomation.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteChangeRequest extends BaseRequest {
	
	@Test(dependsOnMethods = {"com.FullStackAutomation.RestAssured.UpdateChangeRequest.udateChangeRequest"})
	public void deleteChangeRequest() {
		Response response = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.pathParam("sysID", sys_ID)
				.delete("{sysID}");
		System.out.println(response.getStatusCode());
		//response.prettyPrint();
	}
	

}
