package deleteExamples;

import io.restassured.RestAssured;

public class BDDStyleDeleteRequest {
	public static void main(String[] args) {
		
		RestAssured
			.given()
					.baseUri("https://restful-booker.herokuapp.com/booking/1")
					.cookie("token", "f7dddb1093eab19")
			.when()
					.delete()
			.then()
					.assertThat()
					.statusCode(201);
		

		RestAssured
		    .given()
				    .baseUri("https://restful-booker.herokuapp.com/booking/1")
			.when()
					.get()
			.then()
					.statusCode(404);
 
	}
}
