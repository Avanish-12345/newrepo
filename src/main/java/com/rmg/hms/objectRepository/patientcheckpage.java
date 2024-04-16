package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class patientcheckpage 
{
@FindBy(xpath = "//span[text()=' Patients ']")
private WebElement patientclick;
@FindBy(xpath = "//span[text()=' Manage Patient ']")
private WebElement patientmanageclick;
@FindBy(xpath = "//td[text()='7645667777']/..//td[text()='sohit']")
private WebElement patientcheck;
public WebElement getPatientclick() {
	return patientclick;
}
public WebElement getPatientmanageclick() {
	return patientmanageclick;
}
public WebElement getPatientcheck() {
	return patientcheck;
}
public patientcheckpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}
