import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumStreamPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("th[aria-label^='Veg']")).click();
		//List<WebElement> products=driver.findElements(By.xpath("//tr/td[1]"));
		/*
		 * List<String> originalList=
		 * products.stream().map(s->s.getText()).collect(Collectors.toList());
		 * List<String>
		 * sortedList=originalList.stream().sorted().collect(Collectors.toList());
		 * Assert.assertTrue(originalList.equals(sortedList));
		 */
		List<String> prices;
		do {
			List<WebElement> products=driver.findElements(By.xpath("//tr/td[1]"));
		prices=products.stream().filter(s->s.getText().contains("Dragon")).map(s->getPrice(s)).collect(Collectors.toList());
		prices.forEach(s->System.out.println(s));
		if(prices.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}}
		while(prices.size()<1); 
	}
	

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		String veggiePrice=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return veggiePrice;
	}


}

