import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollBy(0,500)");

		int k=0;
		List<WebElement> prices=driver.findElements(By.cssSelector(".tableFixHead td:last-child"));
		for(WebElement price:prices)
			
		{
			//System.out.println(price.getText());
			int courcePrice=Integer.parseInt(price.getText());
			k=k+courcePrice;
		}
		System.out.println(k);
	String TotalAmountText=	driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
	int totalAmount=Integer.parseInt(TotalAmountText);
	Assert.assertEquals(k, totalAmount);
	/*
	 * if(k==totalAmount) { System.out.println("Successful"); }
	 
	 */
	
	}

}
