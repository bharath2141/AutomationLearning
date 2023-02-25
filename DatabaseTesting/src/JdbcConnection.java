import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JdbcConnection {
	
	@Test
	public void jdbcconnectiondemo() throws SQLException
	{
		String host="localhost";
		String port="3306";
	Connection conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/Qadbt", "root", "Funday@15");
	
	Statement s=conn.createStatement();
	ResultSet res=s.executeQuery("select * from Employeeinfo where name='sam'");
	while(res.next())
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
	driver.findElement(By.cssSelector("#username")).sendKeys(res.getString("name"));
	//res.getString("name"));
	driver.findElement(By.cssSelector("#password")).sendKeys(res.getString("location"));
	//res.getString("location");

	}
	}

}
