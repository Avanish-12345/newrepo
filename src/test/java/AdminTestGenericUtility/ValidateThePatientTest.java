package AdminTestGenericUtility;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtilities.DatabaseUtilityTest;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverutilityTest;
import com.GenericUtilities.baseClass;
import com.rmg.hms.objectRepository.AdminHomePage;
import com.rmg.hms.objectRepository.AdminHomePatientPage;
import com.rmg.hms.objectRepository.LoginAdminPage;
import com.rmg.hms.objectRepository.MainPage;
import com.rmg.hms.objectRepository.MainPatientPage;
import com.rmg.hms.objectRepository.Managedoctorpage;

public class ValidateThePatientTest extends baseClass
{
	@Test
	public void ThePatientValidateTest()  throws EncryptedDocumentException, IOException, InterruptedException
	{
		String expdata="sohit";

		AdminHomePage adminhomepage=new AdminHomePage(driver);
		Thread.sleep(2000);
		AdminHomePatientPage adminhomepatientpage=new AdminHomePatientPage(driver);
		adminhomepatientpage.getPatientclick().click();
		Thread.sleep(2000);
		adminhomepatientpage.getManagepatientclick().click();
		Thread.sleep(2000);
		MainPatientPage managepatientpage=new MainPatientPage(driver);
		String actual=managepatientpage.getCheckpatient().getText();
		Thread.sleep(2000);		
		//Thread.sleep(2000);
		System.out.println(actual);
		Assert.assertEquals(actual, expdata,"Patients added successfully");





	}
}
