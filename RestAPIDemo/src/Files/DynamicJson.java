package Files;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test
	public void addBook() {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json")
				.body(PayLoad.addBook("barath", "redddy")).when().post("/Library/Addbook.php").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		JsonPath js = ReusableMethods.rawToJson(response);
		String addedBookId = js.get("ID");
		System.out.println(addedBookId);
		Assert.assertEquals(addedBookId, "barathreddy");
	}

}
