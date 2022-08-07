package extractResponse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WriteResponseInTextFile {

	public static void main(String[] args) throws IOException {
		String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/auth");
		request.contentType(ContentType.JSON);
		request.body(jsonString);
		
		Response response = request.post();
		String responseAsString = response.asString();
		
		//Getting response as Byte stream and writing in to a file
		byte[] responseAsStringByte = responseAsString.getBytes();
		File targetFileForString = new File("src/main/resources/targetFileForString.json");
		Files.write(responseAsStringByte, targetFileForString);
		
		//Getting response as Input stream and writing in to a file
		InputStream responseAsInputStream = response.asInputStream();
		byte[] responseAsInputStreamByte = new byte[responseAsInputStream.available()];
		responseAsInputStream.read(responseAsInputStreamByte);
		File targetFileFoInpuStream = new File("src/main/resources/targetFileForInputStream.json");
		Files.write(responseAsInputStreamByte, targetFileFoInpuStream);

		//Directly getting Byte Array and writing in to a file
		byte[] responseAsByteArray = response.asByteArray();
		File targetFileForByteArray = new File("src/main/resources/targetFileForByteArray.json");
		Files.write(responseAsByteArray, targetFileForByteArray);
	}

}
