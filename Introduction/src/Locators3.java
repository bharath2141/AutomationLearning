import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Traversing between siblings
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText(), "Login");
	//Traversing from child to parent
		driver.findElement(By.xpath("//header/div/button[1]/parent::div"));
	}

}
