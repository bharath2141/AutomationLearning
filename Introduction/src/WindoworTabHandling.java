import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindoworTabHandling {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		// scenario:
		// open url and enter text field webelement in one web page by copying the text
		// from other web page of other url
		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);

		driver.get("https://rahulshettyacademy.com");
		String courseName = driver.findElements(By.cssSelector("h2 a[href*='https://courses.rahulshettyacademy']"))
				.get(1).getText();
		driver.switchTo().window(parentId);
		WebElement name = driver.findElement(By.xpath("//input[@name='name' and @minlength='2']"));
		name.sendKeys(courseName);

		// Screenshot of webelement
		File src = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("WebElementScreenshot.png"));

		// to get height and width of web Element
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getHeight());
		System.out.println(name.getRect().getWidth());

	}
}
