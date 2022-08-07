package deleteExamples;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBDDDeleteRequest {

	public static void main(String[] args) {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/booking/1");
		request.cookie("token", "f4e70e7b9bbcd05");
		
		Response response = request.delete();
		System.out.println(response.asString());
		ValidatableResponse varResp = response.then();
		
		varResp.statusCode(201);
		
		RequestSpecification getRequestSpec = RestAssured.given();
		getRequestSpec.baseUri("https://restful-booker.herokuapp.com/booking/1");
		Response res = getRequestSpec.get();
		Assert.assertEquals(res.statusCode(), 404);

	}

}
