package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day1 {
	
@Test(enabled=false)
public void firstTest()
{
	System.out.println("In FirstTest ");
}

@Test(timeOut=5000)
public void secondTest()
{
	System.out.print("in secondTest ");
}

@BeforeTest
public void clearCache()
{
	System.out.println("Before test");
}

@AfterTest
public void afterTest()
{
	System.out.println("After test");
}
}
