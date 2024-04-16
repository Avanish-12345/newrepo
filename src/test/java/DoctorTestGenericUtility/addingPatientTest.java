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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtilities.DatabaseUtilityTest;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverutilityTest;
import com.rmg.hms.objectRepository.DoctorhomePage;
import com.rmg.hms.objectRepository.LoginDoctorpage;
import com.rmg.hms.objectRepository.MainPage;
import com.rmg.hms.objectRepository.PatientCreatePage;
import com.rmg.hms.objectRepository.patientcheckpage;

public class addingPatientTest
{
	public static WebDriver driver;
	@Test
public void PatienaddtTest()  throws EncryptedDocumentException, IOException, InterruptedException
{
	FileUtility futil=new FileUtility();
	ExcelUtility eutil=new ExcelUtility();
	JavaUtility jutil=new JavaUtility();
	WebDriverutilityTest wutil=new WebDriverutilityTest();
	DatabaseUtilityTest dutil=new DatabaseUtilityTest();
	String expdata="sohit";
	String patientname = eutil.readDataFromExcel("addpatient2", 1, 0);
	String patientcontactno=eutil.readDataFromExcel("addpatient2", 1, 1);
	String patientemail=eutil.readDataFromExcel("addpatient2", 1, 2);
	String gender=eutil.readDataFromExcel("addpatient2", 1, 3);
	String patientaddress=eutil.readDataFromExcel("addpatient2", 1, 4);
	String patientage=eutil.readDataFromExcel("addpatient2", 1, 5);
	String medicalhistory=eutil.readDataFromExcel("addpatient2", 1, 6);
	String browser=futil.readDataFromPropertyFile("browser");
	String url1=futil.readDataFromPropertyFile("url1");
	String adminusername=futil.readDataFromPropertyFile("adminuser");
	String adminpassword=futil.readDataFromPropertyFile("adminpassword");
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
	MainPage mainpages=new MainPage(driver);
	mainpages.getDoctorclick().click();
	LoginDoctorpage doctorlogin=new LoginDoctorpage(driver);
	doctorlogin.getUsernametextfield().sendKeys(doctorusername);
	doctorlogin.getPasswordtextfield().sendKeys(doctorpassword);
	doctorlogin.getLoginlink().click();
	DoctorhomePage doctorhomepage=new DoctorhomePage(driver);
	doctorhomepage.getPatientclick().click();
	doctorhomepage.getAddpatientclick().click();
	PatientCreatePage createpatientpage=new PatientCreatePage(driver);
	createpatientpage.getPatientname().sendKeys(patientname);
	createpatientpage.getPatientcontact().sendKeys(patientcontactno);
	createpatientpage.getPatientemail().sendKeys(patientemail+jutil.getRandomno());
	createpatientpage.getMalepatient().click();
	createpatientpage.getPatientaddress().sendKeys(patientaddress);
	createpatientpage.getPatientage().sendKeys(patientage);
	createpatientpage.getMedicalhistory().sendKeys(medicalhistory);
	createpatientpage.getSubmitclick().click();
	patientcheckpage checkpatients=new patientcheckpage(driver);
	checkpatients.getPatientclick().click();
	Thread.sleep(500);
	checkpatients.getPatientmanageclick().click();
	Thread.sleep(2000);
	String actualdata=checkpatients.getPatientcheck().getText();
	Thread.sleep(2000);
	System.out.println(actualdata);
	Assert.assertEquals(actualdata,expdata,"users is added succesfully");
		
	
			
}
}
