package putExamples;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BDDStylePutRequest {

	public static void main(String[] args) {
		String jsonString = "{\r\n" + "    \"firstname\" : \"Amod\",\r\n" + "    \"lastname\" : \"Mahajan\",\r\n"
				+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body(jsonString)
		.baseUri("https://restful-booker.herokuapp.com/booking/1")
		.cookie("token", "fa0d5b1138a0d1f")
		.when().put()
		.then()
		.statusCode(200)
		.body("firstname", Matchers.equalTo("Pramod"))
		.body("lastname", Matchers.equalTo("Mahajan"));

	}

}
