import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
	List<WebElement> options=driver.findElements(By.cssSelector(".ui-menu-item a"));
	
	for(int i=0;i<options.size();i++)
	{
		if(options.get(i).getText().equalsIgnoreCase("india"))
		{
			options.get(i).click();
			break;
		}
		
	}
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//Thread.sleep(3000);
	//	driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[contains(@id,'destin')] //a[@value='MAA']")).click();
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		List<WebElement> dates=	driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //td[@data-handler='selectDay']/a"));
		for(int i=0;i<dates.size();i++)
		{
			if(dates.get(i).getText().equalsIgnoreCase("16"))
			{
				dates.get(i).click();
				break;
			}
		}	
		if(	driver.findElement(By.cssSelector(".picker-second")).getAttribute("style").contains("0.5"))
		{
			System.out.println("it's disabled before clicking round trip");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		driver.findElement(By.cssSelector("#divpaxinfo")).click();
		System.out.println(driver.findElement(By.cssSelector("#divpaxinfo")).getText());
		Thread.sleep(3000);
		int i=1;
	while(i<5)
	{
		driver.findElement(By.cssSelector("#hrefIncAdt")).click();
		i++;
	}
		driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.cssSelector("#divpaxinfo")).getText());
WebElement selectLocator=driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
		
		Select se=new Select(selectLocator);
		se.selectByIndex(2);
		se.selectByVisibleText("INR");
		se.selectByValue("USD");
		System.out.println(se.getFirstSelectedOption().getText());
//Assert.assertEquals(se.getFirstSelectedOption().getText(), "AE");
	//	se.getOptions();
		for(WebElement option:se.getOptions())
		{
			System.out.println(option.getText());
			
		}
		
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
		
		//System.out.println(checkboxes.size());
		Assert.assertEquals(checkboxes.size(), 6);
		for(int j=0;j<checkboxes.size();j++)
		{
			if(checkboxes.get(j).getText().equalsIgnoreCase("Student"))
			
			
			{
				//System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).get(j).isSelected());
				Assert.assertFalse(driver.findElements(By.xpath("//input[@type='checkbox']")).get(j).isSelected());
				checkboxes.get(j).click();
			//System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).get(j).isSelected());
			Assert.assertTrue(driver.findElements(By.xpath("//input[@type='checkbox']")).get(j).isSelected());
				break;
			}
		}
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		


	}

}
