package services;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class postuser {

	public static void postuser() {
		newdata = new HashMap();
		newdata.put("role", "sdet");
		newdata.put("company", "IBM"); 

		response = given().contentType("application/json").body(newdata).when()
				.post("https://reqres.in/api/users");
		response.jsonPath().getInt("id");

		response.then().statusCode(201).log().all();
		System.out.println("user created with id " + id);

		System.out.println("created role is " + newdata.get("role").equals("sdet"));
	}
}
