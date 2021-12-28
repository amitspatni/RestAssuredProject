import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


import io.restassured.response.Response;


public class TestDelete {
	


	@BeforeTest
	public static void setup() {
    baseURI = "https://jsonplaceholder.typicode.com";
	}

	@Test
	public void deleteRequest() {
    Response response = //given()
            //.header("Content-type", "application/json")
            //.
            when()
            .delete("/posts/1")
            .then()
            .extract().response();

    	Assert.assertEquals(200, response.getStatusCode());
	}
	
	
}
