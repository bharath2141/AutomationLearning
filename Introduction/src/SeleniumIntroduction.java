import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//invoking the browser
		//chrome -ChromeDriver-->methods
	//	System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
	//	WebDriver driver=new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "C:/QentelliAutomation/drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		
		driver.get("https://www.rahulshettyacademy.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.close();
		driver.quit();
		

	}

}
