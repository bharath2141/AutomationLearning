import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class SeleniumTopicUsingStreams2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String veggie="Chee";
		driver.findElement(By.cssSelector("div #search-field")).sendKeys(veggie);
		List<WebElement> filteredList=driver.findElements(By.xpath("//tr/td[1]"));
	List<String> veggieStringList=filteredList.stream().filter(s->s.getText().contains(veggie)).map(s->getVeggie(s)).collect(Collectors.toList());
	Thread.sleep(5000);	
	//System.out.println(veggieStringList);
	Assert.assertTrue(veggieStringList.get(0).contains(veggie));
	Assert.assertEquals(filteredList.size(), veggieStringList.size());
		
		}

	private static String getVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String veggieName=s.getText();
		return veggieName;
	}

}
