package com.FullStackAutomation.RestAssured.JIRA;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FullStackAutomation.RestAssured.JIRA.POJO.Serialization.AddComent.AddComment;
import com.FullStackAutomation.RestAssured.JIRA.POJO.Serialization.AddComent.Visibility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddComments extends BaseRequestForJIRA {
	

	@Test
	public void addComments() {
		AddComment addcomment = new AddComment();
		Visibility visibility = new Visibility();
		addcomment.setBody("Comment1 is added now");
		visibility.setType("role");
		visibility.setValue("tester");
		addcomment.setVisibility(visibility);
		
		Response post = RestAssured
				.given()
				.log().all()
				.contentType(ContentType.JSON)
				.body(addcomment)
				.post("RS-583/comment")
				.then()
				.statusCode(201)
				.extract()
				.response();
	}
}
