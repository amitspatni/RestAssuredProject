package DataDrivenExamples;

import static io.restassured.RestAssured.*;


import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenTests {

	@DataProvider(name = "data")
	public Object[][] dataForPost() {
		
		Object[][] data = new Object[2][3];
		
//		data[0][0] = "Albert";
//		data[0][1] = "Enginner";
//		data[0][2] = 20;
//		
//		data[1][0] = "Nemo";
//		data[1][1] = "Assoc Enginner";
//		data[1][2] = 21;
		
		return data;
		

		
			
		
	}
	
	
	@Test(dataProvider = "data")
	void test1Post(String name, String job, int id) {
		
		baseURI = "https://reqres.in/api";

		JSONObject req = new JSONObject();
		
		req.put("name", name);
		req.put("job", job);
		req.put("id", id);
		
//		System.out.println(req.toJSONString());
				
		given()
			.header("Content-Type", "application/json") // to pass it as JSON
			.accept(ContentType.JSON) // to accept the content type as JSON
			.body(req.toJSONString()).
		when().
			post("/users").
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
