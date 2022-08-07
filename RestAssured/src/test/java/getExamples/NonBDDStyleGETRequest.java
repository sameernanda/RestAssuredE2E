package getExamples;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGETRequest {
	
	@Test
	public void getBookingIDs_verify_statusCode() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/booking");
		Response response = request.get();
		String responseString = response.asString();
		System.out.println(responseString);
		
		ValidatableResponse valResponse = response.then();
		valResponse.statusCode(200);
		valResponse.statusLine("HTTP/1.1 200 OK");
		
	}

}

