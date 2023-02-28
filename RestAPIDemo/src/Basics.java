import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import Files.PayLoad;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String newAddress="Laxmiguda , Chevella";

		// validate if Add Place API is working as expected.
		
		//Scenario: Add place-->update place with new address-->get place to validate whether new place is present in response

		// given- all input details
		// when- Submit the API -resource and http method
		// Then- Validate the Response
		// RestAssured.baseURl="https://rahulshettyacademy.com";
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(PayLoad.addPlace()).when().post("maps/api/place/add/json").then().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)").extract()
				.response().asString();
	//	System.out.println(response);
		
	//	JsonPath js=new JsonPath(response); //for parsing json
	//String placeId=	js.getString("place_id");
		String placeId=ReusableMethods.rawToJson(response).getString("place_id");
	System.out.println(placeId);
	
	Map<String,String> mp=new HashMap<String,String>();
	mp.put("key", "qaclick123");
	mp.put("place_id", placeId);
	System.out.println(mp);
	
	//update place
	given().log().all().queryParams(mp).header("Content-Type", "application/json").body(PayLoad.updatePlace(placeId,newAddress)).when().log().all().put("/maps/api/place/update/json").then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
	//verify the updated place
	
	String getPlaceResponse=given().log().all().queryParams("key", "qaclick123").queryParam("place_id", placeId).when().get("maps/api/place/get/json").then().assertThat().statusCode(200).extract().response().asString();

	/*
	 * JsonPath js1=new JsonPath(getPlaceResponse); String
	 * actualAddress=js1.getString("address");
	 */
	
	String actualAddress=ReusableMethods.rawToJson(getPlaceResponse).getString("address");
		Assert.assertEquals(actualAddress, newAddress);
		System.out.println(actualAddress);
		
		 
	}

}
