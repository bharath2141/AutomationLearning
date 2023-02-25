import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("body a.blinkingText")).click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);

		System.out.println(driver.findElement(By.cssSelector("strong a")).getText());
		String userName = driver.findElement(By.cssSelector("strong a")).getText();
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(userName);

	}

}
