package putExamples;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBDDPutRequest {

	public static void main(String[] args) {
		String jsonString = "{\r\n" + "    \"firstname\" : \"Amod\",\r\n" + "    \"lastname\" : \"Mahajan\",\r\n"
				+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.cookie("token", "fa0d5b1138a0d1f");
		request.body(jsonString);
		request.baseUri("https://restful-booker.herokuapp.com/booking/1");
		
		Response response = request.put();
		System.out.println(response.asString());
		
		ValidatableResponse varResp = response.then();
		varResp.statusCode(200);
		varResp.body("firstname", Matchers.equalTo("Amod"));
		varResp.body("lastname", Matchers.equalTo("Mahajan"));
		

	}

}
