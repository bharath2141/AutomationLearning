package Files;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test(dataProvider="getData")
	public void addBook(String isbn,String aisle) throws InterruptedException, IOException {
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
		
		//giving path of the static payload in body
		
		given().log().all().header("Content-Type", "application/json").body(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/src/Files/AddPlace.json"))))
		.when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added"));
	
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] ob= {{"12","34"},{"45","67"},{"98","45"}};
		return ob;
	}

}
