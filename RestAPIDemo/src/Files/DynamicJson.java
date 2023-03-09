package Files;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test(dataProvider="getData")
	public void addBook(String isbn,String aisle) throws InterruptedException {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json")
				.body(PayLoad.addBook(isbn, aisle)).when().post("/Library/Addbook.php").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		JsonPath js = ReusableMethods.rawToJson(response);
		String addedBookId = js.get("ID");
		System.out.println(addedBookId);
	//	Assert.assertEquals(addedBookId, "barathredddy");
		Thread.sleep(5000);
		
		given().log().all().header("Content-Type", "application/json")
		.body(PayLoad.deleteBook(addedBookId)).when().post("/Library/DeleteBook.php")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("book is successfully deleted"));	
	
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] ob= {{"12","34"},{"45","67"},{"98","45"}};
		return ob;
	}

}
