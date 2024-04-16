package AdminTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

public class addingDoctorTest
{
	public static WebDriver driver;
public static void main(String[] args) throws IOException, InterruptedException 
{
	String expdata="Rohit";
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonDataAdmin.properties");
	FileInputStream fisexcel=new FileInputStream(".\\src\\test\\resources\\test.xlsx");
	Workbook wbkk = WorkbookFactory.create(fisexcel);
	Sheet sh = wbkk.getSheet("adddoctor");
	String doctorname = sh.getRow(1).getCell(0).getStringCellValue();
	String doctoraddress=sh.getRow(1).getCell(1).getStringCellValue();
	String doctorfees=sh.getRow(1).getCell(2).getStringCellValue();
	String doctorcontact=sh.getRow(1).getCell(3).getStringCellValue();
	String doctoremail=sh.getRow(1).getCell(4).getStringCellValue();
	String doctorpassword=sh.getRow(1).getCell(5).getStringCellValue();
	String doctorconfirmpassword=sh.getRow(1).getCell(6).getStringCellValue();
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
	driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()=' Add Doctor']")).click();
	WebElement doctorspecialization=driver.findElement(By.name("Doctorspecialization"));
	Random ram=new Random();
	int random=ram.nextInt(500);
	Select select=new Select(doctorspecialization);
	select.selectByValue("cardiologist");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Name']")).sendKeys(doctorname);
	driver.findElement(By.name("clinicaddress")).sendKeys(doctoraddress);
	driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Consultancy Fees']")).sendKeys(doctorfees);
	driver.findElement(By.name("doccontact")).sendKeys(doctorcontact);
	driver.findElement(By.name("docemail")).sendKeys(doctoremail+random);
	driver.findElement(By.name("npass")).sendKeys(doctorpassword);
	driver.findElement(By.name("cfpass")).sendKeys(doctorconfirmpassword);
	Thread.sleep(2000);
	driver.findElement(By.id("submit")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	WebElement verify=driver.findElement(By.xpath("//td[text()='cardiologist']/..//td[text()='Rohit']"));
	String actual=verify.getText();
	System.out.println(actual);
	if(expdata.equalsIgnoreCase(actual))
	{
		System.out.println("Doctor added successfully");
		
	}
	else
	{
		System.out.println("Doctor is not added successfully");
	}
}
}
