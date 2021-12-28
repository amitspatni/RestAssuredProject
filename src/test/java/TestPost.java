import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestPost {
	
	@Test
	void test1Post() {

		JSONObject req = new JSONObject();
		
		req.put("name", "amit");
		req.put("job", "engineer");
		
//		System.out.println(req.toJSONString());
				
		given()
			.header("Content-Type", "application/json") // to pass it as JSON
			.accept(ContentType.JSON) // to accept the content type as JSON
			.body(req.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then()
			.statusCode(201)
			.log().all();
		
		//		method 2 to create JSON Body
		
		//Map<String, Object> map = new HashMap<String,Object>();
//		map.put("name", "Amit");
//		map.put("job", "Engineer");
//		
//		System.out.println(map);
//		
//		JSONObject req = new JSONObject(map);
//		
//		System.out.println(req.toJSONString());
//		
		
	}

	
	
}
