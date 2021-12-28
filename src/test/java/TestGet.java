import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;



public class TestGet {
	
	
	@Test
	void test_O1() {
		Response res = get("https://reqres.in/api/users?page=2");
		
		
		System.out.println(res.asString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getHeader("content-type"));
		
		
		int statusCode = res.getStatusCode();
		
		Assert.assertEquals(statusCode,200);
		
	}
	
	@Test
	void test_02() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7));
			
		
	}

}
