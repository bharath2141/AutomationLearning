import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTopicUsingStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<String> price;
		//to check sorting button is working
	/*	driver.findElement(By.xpath("//th[1]")).click();
		List<WebElement> elementsList=driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> originalList=elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		//driver.findElement(By.xpath("//th[1]")).click();
		List<String> originalList=elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String>sortedList=originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));*/
		do {
			List<WebElement> elementsList=driver.findElements(By.xpath("//tr/td[1]"));
			 price=elementsList.stream().filter(s->s.getText().contains("Man")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
			price.forEach(s->System.out.println(s));
			
			if(price.size()<1)
			{
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		}
		while(price.size()<1);
		
		
	}

	private static String getVeggiePrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue=s.findElement(By.xpath("following-sibling::td[2]")).getText();
		return priceValue;
	}

}
