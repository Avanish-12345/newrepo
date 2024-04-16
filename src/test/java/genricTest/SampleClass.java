package genricTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtilities.baseClass;
import com.rmg.hms.objectRepository.AdminHomePage;
import com.rmg.hms.objectRepository.AdminHomePatientPage;
import com.rmg.hms.objectRepository.DoctorCreatePage;
import com.rmg.hms.objectRepository.MainPatientPage;
import com.rmg.hms.objectRepository.Managedoctorpage;

public class SampleClass extends baseClass {

	@Test
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
		/*if(expdata.equalsIgnoreCase(actual))
		{
			System.out.println("Doctor added successfully");

		}
		else
		{
			System.out.println("Doctor is not added successfully");
		}*/
		Assert.assertEquals(actual, expdata,"Doctor added successfully");
	}
	
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
//		if(expdata.equalsIgnoreCase(actual))
//		{
//			System.out.println("patients added successfully");
//
//		}
//		else
//		{
//			System.out.println("patients is not added successfully");
//		}




	}
	
	
	
}
