package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DpTest
{
	@Test(dataProvider = "login")
	
	public Object[][] login()
	{
		Object [][] obj=new Object[2][2];
		obj[0][0]="admin";
		obj[0][1]="Test@12345";
		
		obj[1][0]="admin";
		obj[1][1]="Test@123456";
		return obj;
		
	}
}
