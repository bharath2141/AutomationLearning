import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocatorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		System.out.println(driver.findElement(with(By.tagName("label")).above(driver.findElement(By.xpath("//input[@name='email']")))).getText());
		
		
		driver.findElement(with(By.tagName("input")).below(By.cssSelector("label[for='exampleInputPassword1']"))).sendKeys("Heyy");
		
		driver.findElement(with(By.tagName("input")).toLeftOf(By.cssSelector("[for='exampleCheck1']"))).click();
	    System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(By.cssSelector("#inlineRadio3"))).getText());
		
		//syntax:
		//driver.findElement(with(by.tagName()).below(Locator/webElement));
		//driver.findElement(with(by.tagName()).above(Locator/webElement));
		//driver.findElement(with(by.tagName()).toLeftOf(Locator/webElement));
		//driver.findElement(with(by.tagName()).toRightOf(Locator/webElement));
	

	}

}