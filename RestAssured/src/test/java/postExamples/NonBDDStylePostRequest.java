package postExamples;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBDDStylePostRequest {
	public static void main(String[] args) {
		String jsonString = "{\"username\" : \"admin\", \"password\" : \"password123\"}";
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.baseUri("https://restful-booker.herokuapp.com/auth");
		request.body(jsonString);
		
		Response response = request.post();
		System.out.println(response.asString());
		ValidatableResponse valResp = response.then();
		valResp.statusCode(200);
		valResp.body("token", Matchers.notNullValue());
		valResp.body("token.length()", Matchers.is(15));
		valResp.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
	}

}
