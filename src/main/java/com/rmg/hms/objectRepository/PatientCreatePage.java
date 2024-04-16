package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientCreatePage
{
@FindBy(name = "patname")
private WebElement patientname;
@FindBy(name = "patcontact")
private WebElement patientcontact;
@FindBy(name="patemail")
private WebElement patientemail;
@FindBy(xpath = "//label[contains(text(), Male )][2]")
private WebElement malepatient;
@FindBy(name = "pataddress")
private WebElement patientaddress;
@FindBy(name = "patage")
private WebElement patientage;
@FindBy(name = "medhis")
private WebElement medicalhistory;
@FindBy(name = "submit")
private WebElement submitclick;
public WebElement getPatientname() {
	return patientname;
}
public WebElement getPatientcontact() {
	return patientcontact;
}
public WebElement getPatientemail() {
	return patientemail;
}
public WebElement getMalepatient() {
	return malepatient;
}
public WebElement getPatientaddress() {
	return patientaddress;
}
public WebElement getPatientage() {
	return patientage;
}
public WebElement getMedicalhistory() {
	return medicalhistory;
}
public WebElement getSubmitclick() {
	return submitclick;
}
public PatientCreatePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}
