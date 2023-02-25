package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//need to implement iTestListeners which implements TEstng Listners

public class Listeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Itesting success");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" testcase got failed");
		//screenshot code
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
	}
	
	
	

}
