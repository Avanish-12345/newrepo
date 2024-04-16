package DoctorTest;

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
import org.openqa.selenium.interactions.Actions;

public class addingPatientTest
{
	public static WebDriver driver;
public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
{
	String expdata="sohit";
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonDataAdmin.properties");
	FileInputStream fisexcel=new FileInputStream(".\\src\\test\\resources\\test.xlsx");
	Workbook wbkk = WorkbookFactory.create(fisexcel);
	Sheet sh = wbkk.getSheet("addpatient2");
	String patientname = sh.getRow(1).getCell(0).getStringCellValue();
	String patientcontactno=sh.getRow(1).getCell(1).getStringCellValue();
	String patientemail=sh.getRow(1).getCell(2).getStringCellValue();
	String gender=sh.getRow(1).getCell(3).getStringCellValue();
	String patientaddress=sh.getRow(1).getCell(4).getStringCellValue();
	String patientage=sh.getRow(1).getCell(5).getStringCellValue();
	String medicalhistory=sh.getRow(1).getCell(6).getStringCellValue();
	Properties pobj=new Properties();
	pobj.load(fis);
	String browser=pobj.getProperty("browser");
	String url1=pobj.getProperty("url1");
	String adminusername=pobj.getProperty("adminuser");
	String adminpassword=pobj.getProperty("adminpassword");
	String doctorusername=pobj.getProperty("doctoruser");
	String doctorpassword=pobj.getProperty("doctorpassword");
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
	driver.findElement(By.xpath("//h3[text()='Doctors Login']/..//a[text()='Click Here']")).click();
	driver.findElement(By.name("username")).sendKeys(doctorusername);
	Random ram=new Random();
	int random=ram.nextInt(500);
	driver.findElement(By.name("password")).sendKeys(doctorpassword);
	driver.findElement(By.xpath("//button[contains(text(),'	Login')]")).click();
	driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
	driver.findElement(By.xpath("//span[text()=' Add Patient']")).click();
	driver.findElement(By.name("patname")).sendKeys(patientname);
	driver.findElement(By.name("patcontact")).sendKeys(patientcontactno);
	driver.findElement(By.name("patemail")).sendKeys(patientemail+random);
	WebElement male=driver.findElement(By.xpath("//label[contains(text(), Male )][2]"));
	male.click();
	driver.findElement(By.name("pataddress")).sendKeys(patientaddress);
	driver.findElement(By.name("patage")).sendKeys(patientage);
	driver.findElement(By.name("medhis")).sendKeys(medicalhistory);
	driver.findElement(By.name("submit")).click();
	driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("//span[text()=' Manage Patient ']")).click();
	Thread.sleep(2000);
	Actions action=new Actions(driver);
	WebElement verify=driver.findElement(By.xpath("//td[text()='7645667777']/..//td[text()='sohit']"));
	action.moveToElement(verify).pause(2000).perform();
	String actualdata=verify.getText();
	Thread.sleep(2000);
	System.out.println(actualdata);
	if(expdata.equalsIgnoreCase(actualdata))
	{
		System.out.println("patients added successfully");
		
	}
	else
	{
		System.out.println("patients is not added successfully");
	}
		
	
			
}
}
