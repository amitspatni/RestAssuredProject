package RahulShetty;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class DynamicJson {
	
		
	//@Test
	public void getSingleUser() {
		

		RestAssured.baseURI = "https://reqres.in";
		given().log().all().
		header("Content-Type", "application/json")
			.when().get("/api/users/2")
			.then().assertThat().statusCode(200).log().all();
				
	}
 
	
	@Test
	public void getSingleUsersDataFromFile() throws IOException {
		

		RestAssured.baseURI = "https://reqres.in";
		String b =	given().
		header("Content-Type", "application/json").
		body(new String (Files.readAllBytes(Paths.get("C:\\Users\\amitjain\\OneDrive - Capgemini\\Documents\\TrainingRestAssured\\testData.txt"))))
			.when().post("api/register")
			.then().assertThat().log().all().statusCode(200).extract().response().asString();
	
		JsonPath js = new JsonPath(b);
		
		int statusCode = js.getInt("id");
		
		System.out.println(statusCode);
				
	}
	
	
	//@Test(dataProvider = "testData")
	public void postRegisterUser(String emails, String passwords) {
		
		RestAssured.baseURI = "https://reqres.in";
		String b =	given().
		header("Content-Type", "application/json").body(Payload.registerUser(emails,passwords))
			.when().post("api/register")
			.then().assertThat().log().all().statusCode(200).extract().response().asString();
	
		JsonPath js = new JsonPath(b);
		
		int statusCode = js.getInt("id");
		
		System.out.println(statusCode);
		
				
	}
	
	//@DataProvider(name = "testData")
	public Object[][] getData() {
		
//		Object[][] data = new Object[3][2];
//		
//		data[0][0] = "eve.holt@reqres.in";
//		data[0][1] = "pistol";
//		
//		data[1][0] = "eve.holt@reqres.in";
//		data[1][1] = "pistol2";
//		
//		data[2][0] = "eve.holt@reqres.in";
//		data[2][1] = "pistol2";
//		
//		return data;
		
		// this way is also ok
		
		return new Object[][] {{"eve.holt@reqres.in", "pistol"}, {"eve.holt@reqres.in", "pistol"} };
		
		
		
		
		
	}
	
}
