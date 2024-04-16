package AdminTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidateTheUserTest
{
	
	public static WebDriver driver;
public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
{
	String expdata="Lohit";
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonDataAdmin.properties");
	FileInputStream fisexcel=new FileInputStream(".\\src\\test\\resources\\test.xlsx");
	Workbook wbkk = WorkbookFactory.create(fisexcel);
	Sheet sh = wbkk.getSheet("addpatient");
	String fullname = sh.getRow(1).getCell(0).getStringCellValue();
	String address=sh.getRow(1).getCell(1).getStringCellValue();
	String city=sh.getRow(1).getCell(2).getStringCellValue();
	String gender=sh.getRow(1).getCell(3).getStringCellValue();
	String email=sh.getRow(1).getCell(4).getStringCellValue();
	String password=sh.getRow(1).getCell(5).getStringCellValue();
	String passwordagain=sh.getRow(1).getCell(6).getStringCellValue();
	Properties pobj=new Properties();
	pobj.load(fis);
	String browser=pobj.getProperty("browser");
	String url1=pobj.getProperty("url1");
	String url2=pobj.getProperty("url2");
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
	driver.findElement(By.xpath("//h3[text()='Patients']/..//a[text()='Click Here']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Create an account')] ")).click();
	Random ram=new Random();
	int random=ram.nextInt(500);
	driver.findElement(By.name("full_name")).sendKeys(fullname);
	driver.findElement(By.name("address")).sendKeys(address);
	driver.findElement(By.name("city")).sendKeys(city);
	WebElement male=driver.findElement(By.xpath("//label[contains(text(), Male )][2]"));
	male.click();
	driver.findElement(By.name("email")).sendKeys(email+random);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("password_again")).sendKeys(passwordagain);
	driver.findElement(By.name("submit")).click();
	driver.switchTo().alert().accept();
	driver.get(url2);
	WebElement usernametext=driver.findElement(By.name("username"));
	usernametext.sendKeys(adminusername);
	WebElement passwordtext=driver.findElement(By.name("password"));
	passwordtext.sendKeys(adminpassword);
	driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right']")).click();
	driver.findElement(By.xpath("//span[text()=' Users ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()=' Manage Users ']")).click();
	WebElement verify=driver.findElement(By.xpath("//td[text()='metro']/..//td[text()='Lohit']"));
	String actualdata=verify.getText();
	System.out.println(actualdata);
	if(expdata.equalsIgnoreCase(actualdata))
	{
		System.out.println("users added successfully");
		
	}
	else
	{
		System.out.println("users is not added successfully");
	}
		
	
	
	
	
}
}
