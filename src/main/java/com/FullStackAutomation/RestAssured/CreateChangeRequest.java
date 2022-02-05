package com.FullStackAutomation.RestAssured;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateChangeRequest extends BaseRequest {
	
	@Test
	public void createChangeRequest() {
		Response response = RestAssured
				.given()
				.log().all()
				.contentType(ContentType.JSON)
				.body("{\"short_description\":\"short description\",\"description\":\"description\",\"priority\":\"2\",\"risk\":\"3\"}")
				//.expect().body("description", containsStringIgnoringCase("desc"))
				.when()
				.post()
				.then()
				.rootPath("result")
				.assertThat()
				//.log().all()
				//.body("description", containsStringIgnoringCase("desc"))
				.body("short_description", equalTo("short description"))
				.extract()
				.response();
		System.out.println(response.getStatusCode());
		
		System.out.println(response.contentType());
		Object path = response.path("","");
		//System.out.println(path.toString());
		//response.prettyPrint();
		sys_ID = response.jsonPath().get("result.sys_id");
	}
	

}
