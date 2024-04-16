package TestNg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.rmg.hms.objectRepository.LoginAdminPage;

public class DpExecuteTest 
{
	@Test(dataProviderClass = DpTest.class,dataProvider = "login")
	public void getData(String username,String password)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/hms/admin/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		LoginAdminPage loginadminPage=new LoginAdminPage(driver);
		loginadminPage.loginAsAdmin(username, password);
	}
}
