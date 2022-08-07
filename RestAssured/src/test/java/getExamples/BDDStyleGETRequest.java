package getExamples;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BDDStyleGETRequest {
	
	@Test
	public void GetBookingIds_VerifyStatusCode() {
		RestAssured
		.given().baseUri("https://restful-booker.herokuapp.com")
		.when().get("/booking")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.body("bookingid[3]", Matchers.equalTo(3573));
	}

}
