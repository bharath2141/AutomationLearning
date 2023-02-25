package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day2 {
	

	@Parameters({"URL","APIKey"})
	@Test
public void thirdTest(String URLname,String key)
{
	System.out.println("In thirdTest ");
	System.out.println(URLname);
	System.out.println(key);
}

@Test(groups={"smoke"})
public void fourthTest()
{
	System.out.print("In fourthTest ");
}

@BeforeClass
public void beforeClass()
{
	System.out.println("Before class");
}

@AfterClass
public void afterClass()
{
	System.out.println("After class");
}
}
