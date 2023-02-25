import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
//	driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']")).click();
/*		List<WebElement> dates=	driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //td[@data-handler='selectDay']/a"));
for(int i=0;i<dates.size();i++)
{
	if(dates.get(i).getText().equalsIgnoreCase("16"))
	{
		dates.get(i).click();
		break;
	}
}*/
		//checking webelement is enbled or disabled before click on round trip
		
		if(	driver.findElement(By.cssSelector(".picker-second")).getAttribute("style").contains("0.5"))
		{
			System.out.println("it's disabled before clicking round trip");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
		//checking the webelement is enabled or not after click on round trip
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	if(	driver.findElement(By.cssSelector(".picker-second")).getAttribute("style").contains("1"))
	{
		System.out.println("it's enabled after clicking round trip");
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
	
	}

}
