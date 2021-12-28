package RahulShetty;

import org.testng.Assert;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	
	public static void main(String[] args) {
		
	JsonPath js = new JsonPath(Payload.coursePrice());
	
	// print number of course return by
	
	int size = js.getInt("courses.size()");
	
	System.out.println(size);
	
	// get the total price
	
	int s = js.getInt("dashboard.purchaseAmount");
	
	System.out.println(s);
	
	//iterate over json and add the price of get sum of total prize
	
	int price = 0;
	
	for (int i=0; i<size; i++) {
		
		price += (js.getInt("courses["+i+"].price")) * (js.getInt("courses["+i+"].copies")) ;
		
		
	}
	
	System.out.println(price);
	
	Assert.assertEquals(s, price);
	
	//iterate over json and get the value based on the matching condition
	// no of copies sold for RPA
	
	for (int i=0; i<size; i++) {
		
		String title = js.get("courses["+i+"].title");
		if (title.equalsIgnoreCase("RPA")) {
			
			System.out.println(js.getInt("courses["+i+"].copies"));
			break;
		}
		
		
		
		
	}
	
	
	
	
	}

}

