package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverutilityTest;

public class DoctorCreatePage 
{
@FindBy(name = "Doctorspecialization")
private WebElement doctorspecialization;
@FindBy(xpath = "//input[@placeholder='Enter Doctor Name']")
private WebElement enterdoctorName;
@FindBy(name = "clinicaddress")
private WebElement cliniccaddress;
@FindBy(xpath = "//input[@placeholder='Enter Doctor Consultancy Fees']")
private WebElement doctorfees;
@FindBy(name = "doccontact")
private WebElement doctorcontact;
@FindBy(name = "docemail")
private WebElement doctoremail;
@FindBy(name = "npass")
private WebElement doctorpassword;
@FindBy(name="cfpass")
private WebElement confirmdoctorpassword;
@FindBy(id = "submit")
private WebElement submitclick;
public WebElement getDoctorspecialization() {
	return doctorspecialization;
}
public WebElement getEnterdoctorName() {
	return enterdoctorName;
}
public WebElement getCliniccaddress() {
	return cliniccaddress;
}
public WebElement getDoctorfees() {
	return doctorfees;
}
public WebElement getDoctorcontact() {
	return doctorcontact;
}
public WebElement getDoctoremail() {
	return doctoremail;
}
public WebElement getDoctorpassword() {
	return doctorpassword;
}
public WebElement getConfirmdoctorpassword() {
	return confirmdoctorpassword;
}
public WebElement getSubmitclick() {
	return submitclick;
}
public DoctorCreatePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
WebDriverutilityTest wutil=new WebDriverutilityTest();
JavaUtility jutil=new JavaUtility();
 public void createDoctor(String docSpcl,String docName,String cliAdd,String fee,String contact,String email,String pass,String confPass) throws InterruptedException {
	 doctorspecialization.sendKeys(docSpcl);
	 enterdoctorName.sendKeys(docName);
	 cliniccaddress.sendKeys(cliAdd);
	 doctorfees.sendKeys(fee);
	 doctorcontact.sendKeys(contact);
	 doctoremail.sendKeys(email+jutil.getRandomno());
	 doctorpassword.sendKeys(pass);
	 confirmdoctorpassword.sendKeys(confPass);
	 Thread.sleep(2000);
	 submitclick.click();
	 Thread.sleep(2000);
}
























}
