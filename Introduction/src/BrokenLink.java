import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
	
			System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement>links=driver.findElements(By.cssSelector(".gf-t tr td a"));
		SoftAssert a=new SoftAssert();
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");
			//java methods will call the url's and get the status codes
			HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int status=conn.getResponseCode();
			System.out.println(status);
			/*
			 * if(status>=400) { System.out.println("The link with the text "+link.getText()
			 * +" is broken with "+status+" code"); Assert.assertTrue(false); }
			 */
			//Soft Assertion: even if there is a failure, execution wont stop 
			
			
			a.assertTrue(status<400," The link with the text "+link.getText()
			  +" is broken with "+status+" code");
			
			
	}
		a.assertAll();
		}

}
