import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("bharath");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
	
		
		System.out.println(driver.findElement(By.cssSelector(".error")).getText());
		//driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("bharath");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("bharathreddy1428@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("9949908967");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		String password=driver.findElement(By.cssSelector("form p")).getText();
		String[] updatedpwd=password.split("'");
		String formattedPwd=updatedpwd[1];
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("bharath");
		driver.findElement(By.cssSelector("input[type$='word']")).sendKeys(formattedPwd);
		List<WebElement> checkboxes=driver.findElements(By.cssSelector("input[id^='chk']"));
		for(WebElement checkbox:checkboxes)
		{
			checkbox.click();
		}
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}

}
