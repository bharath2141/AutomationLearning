
package rahulshettyacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config()
	{
		String path=System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation results");
		reporter.config().setDocumentTitle("Test results");
		
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Bharath");
	}
	
	@Test
	public void initialDemo()
	{
		ExtentTest test=extent.createTest("initialDemo");
		System.setProperty("webdriver.chrome.driver", "C:\\QentelliAutomation\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		
		//wantedly failing te get in report
		test.fail("results mismatch");
		extent.flush();
	}

}
