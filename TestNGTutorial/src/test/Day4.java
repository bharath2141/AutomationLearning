package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day4 {
	
	@Test
	public void webLoginCarLoan()
	{
	System.out.println("webLoginCarLoan");	
	
	//knowingly failing to test itestlisteners code on failure
	Assert.assertTrue(false);
	}
	
	@Test(dataProvider="getData")
	public void MobileLoginCarLoan(String un,String pwd)
	{
		System.out.println("MobileLoginCarLoan");
		System.out.println(un);
		System.out.println(pwd);
	}
	
	@Test(dependsOnMethods={"MobileLoginCarLoan","webLoginCarLoan"})
	public void LoginAPICarLoan()
	{
	System.out.println("LoginAPICarLoan");	
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After"
				+ " Method");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="Abhay";
		data[0][1]="FGHGVJHKB";
		data[1][0]="RAM";
		data[1][1]="fghgjh";
		
		data[2][0]="Shyam";
		data[2][1]="dfgh";
		
		return data;
	}
	

}
