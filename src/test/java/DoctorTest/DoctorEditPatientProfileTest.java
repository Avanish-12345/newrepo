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
public class DoctorEditPatientProfileTest
{
	public static WebDriver driver;
public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
{
	String expdata="mundenhale";
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonDataAdmin.properties");
	FileInputStream fisexcel=new FileInputStream(".\\src\\test\\resources\\test.xlsx");
	Workbook wbkk = WorkbookFactory.create(fisexcel);
	Sheet sh = wbkk.getSheet("addpatient2");
	String patientnewaddress=sh.getRow(2).getCell(4).getStringCellValue();
	Properties pobj=new Properties();
	pobj.load(fis);
	String browser=pobj.getProperty("browser");
	String url1=pobj.getProperty("url1");
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
	driver.findElement(By.name("password")).sendKeys(doctorpassword);
	driver.findElement(By.xpath("//button[contains(text(),'	Login')]")).click();
	Random ram=new Random();
	int random=ram.nextInt(500);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()=' Manage Patient ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//td[text()='sohit']/..//i[@class='fa fa-edit']")).click();
	WebElement male=driver.findElement(By.xpath("//label[contains(text(), Male )][2]"));
	male.click();
	WebElement patientnwaddress=driver.findElement(By.name("pataddress"));
	patientnwaddress.clear();
	patientnwaddress.sendKeys(patientnewaddress);
	driver.findElement(By.name("submit")).click();
	driver.findElement(By.xpath("//td[text()='sohit']/..//i[@class='fa fa-eye']")).click();
	WebElement verify=driver.findElement(By.xpath("//th[text()='Patient Mobile Number']/..//td[text()='mundenhale']"));
	String actualdata=verify.getText();
	System.out.println(actualdata);
	if(expdata.equalsIgnoreCase(actualdata))
	{
		System.out.println("Patients profile is edited successfully");
		
	}
	else
	{
		System.out.println("Patients profile is not edited successfully");
	}
	
}
}
