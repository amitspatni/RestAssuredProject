package pojo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Serializetests {


@Test

public void test1() {
	
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body("{\r\n"
			+ " \r\n"
			+ "    	\"location\":{\r\n"
			+ "     	\"lat\" : -38.383494,\r\n"
			+ "     	\"lng\" : 33.427362\r\n"
			+ "     	},\r\n"
			+ "     	\"accuracy\":50,\r\n"
			+ "     	\"name\":\"Frontline house\",\r\n"
			+ "     	\"phone_number\":\"(+91) 983 893 3937\",\r\n"
			+ "     	\"address\" : \"29, side layout, cohen 09\",\r\n"
			+ "     	\"types\": [\"shoe park\",\"shop\"],\r\n"
			+ "     	\"website\" : \"http://google.com\",\r\n"
			+ "     	\"language\" : \"French-IN\"\r\n"
			+ " \r\n"
			+ "}").when().log().all().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200).log().all();
		
	
}

}
