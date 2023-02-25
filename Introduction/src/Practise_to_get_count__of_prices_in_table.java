import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise_to_get_count__of_prices_in_table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int k=0;
		List<WebElement> prices=driver.findElements(By.cssSelector("table[name='courses'] td:last-child"));
		for(WebElement price:prices)
			
		{
			//System.out.println(price.getText());
			int courcePrice=Integer.parseInt(price.getText());
			k=k+courcePrice;
		}
		System.out.println(k);

	}

}
