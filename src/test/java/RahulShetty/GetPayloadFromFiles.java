package RahulShetty;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;

public class GetPayloadFromFiles {
	
	
	
@Test
public void getPayloadFromTheFile() {
		
		///getting payload from the files
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.getPayload()).when().log().all().
		post("maps/api/place/add/json")
					.then().assertThat().statusCode(200);
		
	}


}
