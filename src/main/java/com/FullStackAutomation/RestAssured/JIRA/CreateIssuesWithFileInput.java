package com.FullStackAutomation.RestAssured.JIRA;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIssuesWithFileInput {
	
	@DataProvider(name = "fetchData")
	public String[] getData() {
		String[] data = new String[2];
		data[0] = "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "    \"project\":\r\n"
				+ "                {\r\n"
				+ "                    \"key\": \"RS\"\r\n"
				+ "                },\r\n"
				+ "    \"summary\": \"create First issue in RS project\",\r\n"
				+ "    \"description\": \"Creating an issue using project keys and issue type names using the REST API\",\r\n"
				+ "    \"issuetype\": {\r\n"
				+ "                    \"name\": \"Bug\"\r\n"
				+ "                }\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "";
		data[1] = "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "    \"project\":\r\n"
				+ "                {\r\n"
				+ "                    \"key\": \"RS\"\r\n"
				+ "                },\r\n"
				+ "    \"summary\": \"create Story in RS project\",\r\n"
				+ "    \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "    \"issuetype\": {\r\n"
				+ "                    \"name\": \"Story\"\r\n"
				+ "                }\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "";
		return data;
	}
	
	@Test(dataProvider = "fetchData")
	public void createIssuesWithStringInput(String bodyContent) {
		
		Response response = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.body(bodyContent)
				.post();
		
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		JsonPath jsonPath = response.jsonPath();
		System.out.println(jsonPath.get("key"));
	}

}
