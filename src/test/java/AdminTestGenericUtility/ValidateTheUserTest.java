package AdminTestGenericUtility;

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
import com.GenericUtilities.baseClass;
import com.rmg.hms.objectRepository.AdminHomePage;
import com.rmg.hms.objectRepository.CreatepatientPage;
import com.rmg.hms.objectRepository.LoginAdminPage;
import com.rmg.hms.objectRepository.MainPage;
import com.rmg.hms.objectRepository.PatientLoginPage;
import com.rmg.hms.objectRepository.checkusersPage;

public class ValidateTheUserTest extends baseClass
{

	//	public static WebDriver driver;
	@Test
	public void userValidateTest()  throws EncryptedDocumentException, IOException, InterruptedException 
	{
		String expdata="Lohit";
		String fullname = eutil.readDataFromExcel("addpatient", 1, 0);
		String address=eutil.readDataFromExcel("addpatient", 1, 1);
		String city=eutil.readDataFromExcel("addpatient", 1, 2);
		String gender=eutil.readDataFromExcel("addpatient", 1, 3);
		String email=eutil.readDataFromExcel("addpatient", 1, 4);
		String password=eutil.readDataFromExcel("addpatient", 1, 5);
		String passwordagain=eutil.readDataFromExcel("addpatient", 1, 6);
		String url2=futil.readDataFromPropertyFile("url2");
		String adminusername=futil.readDataFromPropertyFile("adminuser");
		String adminpassword=futil.readDataFromPropertyFile("adminpassword");
		MainPage mainpages=new MainPage(driver);
		mainpages.getPatientclick().click();
		PatientLoginPage createaccount=new PatientLoginPage(driver);
		createaccount.getCreatepatient().click();
		CreatepatientPage createpatient=new CreatepatientPage(driver);
		createpatient.getFullname().sendKeys(fullname);
		createpatient.getAddress().sendKeys(address);
		createpatient.getCity().sendKeys(city);
		createpatient.getMale().click();
		Thread.sleep(2000);
		createpatient.getEmail().sendKeys(email+jutil.getRandomno());
		createpatient.getPassword().sendKeys(password);
		createpatient.getPasswordagain().sendKeys(passwordagain);
		createpatient.getSubmit().click();

		wutil.alertpopupAccept(driver);
		driver.get(futil.readDataFromPropertyFile("url2"));
		LoginAdminPage loginpage=new LoginAdminPage(driver);

		Thread.sleep(2000);

		wutil.sendKeysActions(driver, loginpage.getUsernametextfield(), adminusername);

		wutil.sendKeysActions(driver, loginpage.getPasswordtextfield(), adminpassword);
		loginpage.getLoginlink().click();
		AdminHomePage adminhomepage=new AdminHomePage(driver);
		adminhomepage.getUsersclick().click();
		Thread.sleep(2000);
		adminhomepage.getManageuserclick().click();
		checkusersPage checkusers=new checkusersPage(driver);
		String actualdata=checkusers.getCheckusers().getText();

		System.out.println(actualdata);
	Assert.assertEquals(actualdata,expdata,"users is added succesfully");

	}
}
