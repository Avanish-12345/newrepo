package com.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryimpclass implements IRetryAnalyzer
{
	int lowercount=0;
	int uppercount=3;

	@Override
	public boolean retry(ITestResult result) 
	{
		if(lowercount<uppercount)
		{
			lowercount++;
			return true;
		}
		return false;
	}
 
}
