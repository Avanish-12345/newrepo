package com.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenerimplements implements ITestListener
{
	

	@Override
	public void onTestStart(ITestResult result) {


	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
	WebDriverutilityTest wutils=new WebDriverutilityTest();
	String methodname=result.getMethod().getMethodName();
	try
	{
		wutils.getScreenShot(baseClass.sdriver, methodname);
	}
	catch(IOException e)
	{
		
	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
	}

}
