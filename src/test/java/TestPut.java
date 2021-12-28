import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestPut {
	
	@Test
	void test1Put() {

		JSONObject req = new JSONObject();
		
		req.put("name", "amit");
		req.put("job", "engineer");
		
//		System.out.println(req.toJSONString());
				
		given()
			.header("Content-Type", "application/json") 
			.contentType(ContentType.JSON) // to pass it as JSON
			.accept(ContentType.JSON) // to accept the content type as JSON
			.body(req.toJSONString()). // to convert request to JSON object that is optional .body(req) will also work
		when().
			put("https://reqres.in/api/users/2").
		then()
			.statusCode(200)
			.log().all();
		
			
	}

	
	
}
