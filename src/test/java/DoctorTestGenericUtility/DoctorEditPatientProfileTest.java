package DoctorTestGenericUtility;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtilities.DatabaseUtilityTest;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverutilityTest;
import com.rmg.hms.objectRepository.CreateDoctorpage;
import com.rmg.hms.objectRepository.PatientviewPage;
import com.rmg.hms.objectRepository.patientcheckpage;
public class DoctorEditPatientProfileTest
{
	public static WebDriver driver;
	@Test
public void EditPatientProfileDoctorTest()  throws EncryptedDocumentException, IOException, InterruptedException
{
	FileUtility futil=new FileUtility();
	ExcelUtility eutil=new ExcelUtility();
	JavaUtility jutil=new JavaUtility();
	WebDriverutilityTest wutil=new WebDriverutilityTest();
	DatabaseUtilityTest dutil=new DatabaseUtilityTest();
	String expdata="mundenhale";
	String patientnewaddress=eutil.readDataFromExcel("addpatient2", 2, 4);
	String browser=futil.readDataFromPropertyFile("browser");
	String url1=futil.readDataFromPropertyFile("url1");
	String doctorusername=futil.readDataFromPropertyFile("doctoruser");
	String doctorpassword=futil.readDataFromPropertyFile("doctorpassword");
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
	
	driver.get(futil.readDataFromPropertyFile("url1"));
	wutil.maximizeWindow(driver);
	CreateDoctorpage createdoctor=new CreateDoctorpage(driver);
	createdoctor.getDoctorclick().click();
	createdoctor.getUsernametext().sendKeys(doctorusername);
	createdoctor.getPasswordtext().sendKeys(doctorpassword);
	createdoctor.getDoctorlogin().click();
	Thread.sleep(2000);
	patientcheckpage patientcheck=new patientcheckpage(driver);
	patientcheck.getPatientclick().click();
	Thread.sleep(2000);
	patientcheck.getPatientmanageclick().click();
	Thread.sleep(2000);
	PatientviewPage patientview=new PatientviewPage(driver);
	patientview.getPatientviewclick().click();
	patientview.getPatientcheckclick().click();
	patientview.getPatientaddress().clear();
	patientview.getPatientaddress().sendKeys(patientnewaddress);
	patientview.getSubmitclick().click();
	patientview.getEyeclick().click();
	String actualdata =patientview.getCheckaddress().getText();

	System.out.println(actualdata);
	Assert.assertEquals(actualdata,expdata,"patient profile is edited succesfully");
}
}
