package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage 
{
	@FindBy(xpath = "//h3[text()='Admin Login']/..//a[text()='Click Here']")
	private WebElement adminlink;
	
	public MainPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAdminlink()
	{
		return adminlink;
	}
	@FindBy(xpath = "//h3[text()='Patients']/..//a[text()='Click Here']")
	private WebElement patientclick;

	public WebElement getPatientclick() {
		return patientclick;
	}
	@FindBy(xpath = "//h3[text()='Doctors Login']/..//a[text()='Click Here']")
	private WebElement doctorclick;

	public WebElement getDoctorclick() {
		return doctorclick;
	}
	
	
}
