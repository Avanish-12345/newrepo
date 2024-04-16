package AdminTestGenericUtility;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.DatabaseUtilityTest;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverutilityTest;
import com.GenericUtilities.baseClass;
import com.rmg.hms.objectRepository.AdminHomePage;
import com.rmg.hms.objectRepository.DoctorCreatePage;
import com.rmg.hms.objectRepository.LoginAdminPage;
import com.rmg.hms.objectRepository.MainPage;
import com.rmg.hms.objectRepository.Managedoctorpage;
@Listeners(com.GenericUtilities.Listenerimplements.class)
public class addingDoctorTest extends baseClass
{
	@Test(retryAnalyzer = com.GenericUtilities.Retryimpclass.class)
	public void DoctorAddTest() throws IOException, InterruptedException 
	{
		//String expdata="Rohit";
		String doctorname = eutil.readDataFromExcel("adddoctor", 1, 0);
		String doctoraddress=eutil.readDataFromExcel("adddoctor", 1, 1);
		String doctorfees=eutil.readDataFromExcel("adddoctor", 1, 2);
		String doctorcontact=eutil.readDataFromExcel("adddoctor", 1, 3);
		String doctoremail=eutil.readDataFromExcel("adddoctor", 1, 4);
		String doctorpassword=eutil.readDataFromExcel("adddoctor", 1, 5);
		String doctorconfirmpassword=eutil.readDataFromExcel("adddoctor", 1, 6);
		AdminHomePage adminhomepage=new AdminHomePage(driver);
		adminhomepage.rightClickOnDoc();
		DoctorCreatePage doctorcreatepage=new DoctorCreatePage(driver);
		doctorcreatepage.createDoctor("cardiologist", doctorname, doctoraddress, doctorfees, doctorcontact, doctoremail, doctorpassword, doctorconfirmpassword);
		Thread.sleep(2000);
		Assert.fail();
		wutil.alertpopupAccept(driver);
		Managedoctorpage managedoctor=new Managedoctorpage(driver);
		String actual=managedoctor.getCheckDoctor().getText();
		System.out.println(actual);
		String expdata="Rohit";
		Assert.assertEquals(actual, expdata,"Doctor added successfully");
	}
}
