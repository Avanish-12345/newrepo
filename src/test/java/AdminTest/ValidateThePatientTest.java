package AdminTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ValidateThePatientTest
{
	public static WebDriver driver;
	@Test
public void ThePatientValidateTest() throws EncryptedDocumentException, IOException, InterruptedException
{
	String expdata="sohit";
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonDataAdmin.properties");
	FileInputStream fisexcel=new FileInputStream(".\\src\\test\\resources\\test.xlsx");
	Workbook wbkk = WorkbookFactory.create(fisexcel);
	Sheet sh = wbkk.getSheet("adddoctor");
	Properties pobj=new Properties();
	pobj.load(fis);
	String browser=pobj.getProperty("browser");
	String url1=pobj.getProperty("url1");
	String adminusername=pobj.getProperty("adminuser");
	String adminpassword=pobj.getProperty("adminpassword");
	if(browser.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("wrong driver");
	}
	
	driver.get(url1);
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//h3[text()='Admin Login']/..//a[text()='Click Here']")).click();
	WebElement usernametext=driver.findElement(By.name("username"));
	usernametext.sendKeys(adminusername);
	WebElement passwordtext=driver.findElement(By.name("password"));
	passwordtext.sendKeys(adminpassword);
	driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()=' Manage Patients ']")).click();
	Thread.sleep(2000);
	WebElement verify=driver.findElement(By.xpath("//td[text()='7645667777']/..//td[text()='sohit']"));
	String actual=verify.getText();
	Thread.sleep(2000);
	System.out.println(actual);
	if(expdata.equalsIgnoreCase(actual))
	{
		System.out.println("patients added successfully");
		
	}
	else
	{
		System.out.println("patients is not added successfully");
	}
		
	
	
	
}
}
