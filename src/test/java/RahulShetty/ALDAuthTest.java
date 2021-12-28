package RahulShetty;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class ALDAuthTest {
	
	
	@Test
	public void doLogin() {
		
		RestAssured.baseURI = "https://apimanager.accept.aldautomotive.com/apigateway";
		
		
			
		String response  = given().header("Content-Type", "application/json").
		body("{\r\n"
				+ "  \"email\": \"mznznziz.zhzuzhzrz@zezrznz.zo.iz\",\r\n"
				+ "  \"password\": \"Pass@word1\"\r\n"
				+ "}").when().post("/usermanagement/api/User/Authenticate").
				then()
				.statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		
		String bearertoken = js.get("access_token");
		
		
		System.out.println(bearertoken);
		
//		 .headers(
//	              "Authorization", "Bearer " + bearerToken, "Content-Type", ContentType.JSON,
//	              "Accept",
//	              ContentType.JSON)
//		
//		
		given().header("Content-Type", "application/json").header("Authorization", "Bearer " + bearertoken)
		.body("{\r\n"
				+ "  \"contractId\": \"045151\",\r\n"
				+ "  \"mileage\": 5001\r\n"
				+ "}").log().all().post("/contract/api/contract/UpdateMileage")
				.then().log().all();
		
		//https://apidriver.accept.aldautomotive.com/apigateway/contract/api/contract/UpdateMileage
		
		
//		,  )
			
		
		
		
		//C045151
		
		
		
		
															
															
		
		
	}

}
