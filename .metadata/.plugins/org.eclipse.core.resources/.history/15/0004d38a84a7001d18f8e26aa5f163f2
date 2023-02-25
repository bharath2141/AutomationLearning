import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footer=driver.findElement(By.cssSelector("table.gf-t"));
	    System.out.println(footer.findElements(By.tagName("a")).size());
	  WebElement footerColumn= footer.findElement(By.cssSelector("table.gf-t td:first-child"));
	  System.out.println(footerColumn.findElements(By.tagName("a")).size());
	  List<WebElement> footercolumnlinks=footerColumn.findElements(By.tagName("a"));
	  for(int i=1;i<footercolumnlinks.size();i++)
	  {
		  footercolumnlinks.get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		  
		  
	  }
	  
	  Set<String> tabs=driver.getWindowHandles();
	  Iterator<String> it=tabs.iterator();
	  while(it.hasNext())
	  {
		 System.out.println(driver.switchTo().window(it.next()).getTitle());
		 driver.close();
	  }
	  
	  
	}

}
