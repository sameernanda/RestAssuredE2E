package postExamples;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BDDStylePostRequest {
	public static void main(String[] args) {
		String jsonString = "{\"username\" : \"admin\", \"password\" : \"password123\"}";
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(jsonString)
		.baseUri("https://restful-booker.herokuapp.com/auth")
		.when().post()
		.then()
		.statusCode(200)
		.body("token",Matchers.notNullValue())
		.body("token.length()", Matchers.is(15))
		.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
	}

}
