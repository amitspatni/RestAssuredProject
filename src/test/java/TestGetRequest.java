import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;


public class TestGetRequest {
	
	@Test
	void testget() {
		
		given()
			.get("https://reqres.in/api/users?page=2").
		then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7))	
			.body("data.first_name[0]", equalTo("Michael"))
			.body("data.first_name", hasItems("Michael", "Lindsay"))
			.log().all();
		


	}

	
}
