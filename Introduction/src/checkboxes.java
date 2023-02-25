import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class checkboxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//System.out.println(driver.findElement(By.xpath("//input[contains(@id,'Senior')]/following-sibling::label")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//input[contains(@id,'Senior')]/following-sibling::label")).getText(), "Senior Citizen");
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
	
	//System.out.println(checkboxes.size());
	Assert.assertEquals(checkboxes.size(), 6);
	for(int i=0;i<checkboxes.size();i++)
	{
		if(checkboxes.get(i).getText().equalsIgnoreCase("Student"))
		
		
		{
			//System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).isSelected());
			Assert.assertFalse(driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).isSelected());
			checkboxes.get(i).click();
		//System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).isSelected());
		Assert.assertTrue(driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).isSelected());
			break;
		}
	}
	}

}
