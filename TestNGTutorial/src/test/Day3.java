package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {
	
	@Test
	public void webLoginHomeLoan()
	{
	System.out.println("webLoginHomeLoan");	
	}
	
	@Test
	public void MobileLoginHomeLoan()
	{
		System.out.println("MobileLoginHomeLoan");
	}
	@Parameters("URL")
	@Test
	public void MobileSigninHomeLoan(String URLname)
	{
		System.out.println("MobileSigninHomeLoan");
		System.out.println(URLname);
	}
	
	@Test(groups="smoke")
	public void MobileSignupHomeLoan()
	{
		System.out.println("MobileSignupHomeLoan");
	}
	
	@Test
	public void LoginAPIHomeLoan()
	{
	System.out.println("LoginAPIHomeLoan");	
	}
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite");
	}
	

}
