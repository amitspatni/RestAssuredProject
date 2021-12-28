package RahulShetty;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetTestDataFromOtherAPI {
	
	

@Test
public void getPayloadFromTheFile() {
		
		///getting payload from the files and store response in a string
		 RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		 String response = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.getPayload()).when().
		post("maps/api/place/add/json").then().
					assertThat().statusCode(200).
					body("scope", equalTo("APP")).extract().response().asString();
					
		JsonPath js = new JsonPath(response);
			
		String placeID = js.get("place_id");
		
		System.out.println("*************");
		
		
		 //update place
		
		String newAddress = "70 winter walk, USA";
		
		given().queryParam("key", "qaclick123").header("Content-Type", "application/json").body("{\r\n"
				+ "\"place_id\":\""+placeID+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").when().put("/maps/api/place/update/json").
					then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"))
					.log().all();
		
		
		
		
		//now verify this is updated or not
		
		String updatedAddress = given().queryParam("key", "qaclick123").queryParam("place_id", placeID).
				header("Content-Type", "application/json").when().get("/maps/api/place/get/json")
				.then().assertThat().statusCode(200).extract().response().asString();
		
		
		
		
		
		JsonPath js1 = new JsonPath(updatedAddress);
		
		String actualResults = js1.get("address");
		
		System.out.println(actualResults);
		
		Assert.assertEquals(newAddress, actualResults);
		
		
		
		
		
		
	}

}

