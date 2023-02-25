import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
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
		
		//updated dropdown for adults sample
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
		
	}

}
