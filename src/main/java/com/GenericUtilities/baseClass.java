package com.GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.rmg.hms.objectRepository.LoginAdminPage;
import com.rmg.hms.objectRepository.MainPage;

public class baseClass 
{
	public static WebDriver sdriver;
	public WebDriver driver;
	public WebDriverutilityTest wutil;
	public FileUtility futil=new FileUtility();
	public ExcelUtility eutil=new ExcelUtility();
	public JavaUtility jutil=new JavaUtility();
//	public WebDriverutilityTest wutil=new WebDriverutilityTest();
	public DatabaseUtilityTest dutil=new DatabaseUtilityTest();
	
	/*@BeforeSuite
	public void connectTodb() throws SQLException
	{
	
	dutil.connectTodb();
	Reporter.log("-----Db command", true);
	}*/
	@BeforeClass
	public void launchThebrowser() throws IOException
{
		String browser=futil.readDataFromPropertyFile("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			{
				Reporter.log("------invalid browser", true);
			}
			
		}
		
		sdriver = driver;
		wutil = new WebDriverutilityTest();
		wutil.maximizeWindow(driver);
		wutil.waitforPageLoad(driver, 20);
}
	@BeforeMethod
	public void loginToAdmin() throws IOException
	{
		
	String urlAdmin=futil.readDataFromPropertyFile("url1");
	driver.get(urlAdmin);
	MainPage mainpage=new MainPage(driver);
	mainpage.getAdminlink().click();
	String useradmin=futil.readDataFromPropertyFile("adminuser");
	String passwordadmin=futil.readDataFromPropertyFile("adminpassword");
	LoginAdminPage logadmin=new LoginAdminPage(driver);
	logadmin.loginAsAdmin(useradmin, passwordadmin);
	}
	@AfterMethod
	public void logoutAsAdmin()
	{
		
	}
	@AfterClass
	public void closebrowser()
	{
		wutil.minimizewindow(driver);
		wutil.quitbrowser(driver);
	}
	/*@AfterSuite
	public void closeDB() throws SQLException {
		dutil.closeDb();
	}*/
	


}
