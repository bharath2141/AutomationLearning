import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String[] veggies = { "Brocolli", "Cauliflower", "Cucumber", "Beetroot" };
		System.setProperty("webdriver.chrome.driver", "C:/QentelliAutomation/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addItemsToBag(driver,veggies);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.cssSelector(".cart-preview.active .action-block button")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoWrapper button.promoBtn")).click();
		
		//explicit wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!");
		
	}
	
	public static void addItemsToBag(WebDriver driver,String[] veggies)
	{
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		/*
		 * int j=0; while(j<veggies.length) { for(int i=0;i<products.size();i++) {
		 * if(products.get(i).getText().contains(veggies[j])) {
		 * driver.findElements(By.cssSelector(".product-action")).get(i).click(); break;
		 * } } j++; }
		 */

		int k = 0;
		List<String> veggiesNeededList = Arrays.asList(veggies);
		for (int i = 0; i < products.size(); i++) {
			String productName = products.get(i).getText();
			String formattedProductname = productName.split("-")[0].trim();

			if (veggiesNeededList.contains(formattedProductname)) {
				driver.findElements(By.cssSelector(".product-action button")).get(i).click();
				k++;
				if (k == veggiesNeededList.size()) {
					System.out.println("breaking");
					break;
				}
			}

		}

	}

}
