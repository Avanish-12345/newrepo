package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientviewPage 
{
@FindBy(xpath = "//td[text()='sohit']/..//i[@class='fa fa-edit']")
private WebElement patientviewclick;
@FindBy(xpath = "//label[contains(text(), Male )][2]")
private WebElement patientcheckclick;
@FindBy(name="pataddress")
private WebElement patientaddress;
@FindBy(name = "submit")
private WebElement submitclick;
@FindBy(xpath = "//td[text()='sohit']/..//i[@class='fa fa-eye']")
private WebElement eyeclick;
@FindBy(xpath = "//th[text()='Patient Mobile Number']/..//td[text()='mundenhale']")
private WebElement checkaddress;
public PatientviewPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getPatientviewclick() {
	return patientviewclick;
}
public WebElement getPatientcheckclick() {
	return patientcheckclick;
}
public WebElement getPatientaddress() {
	return patientaddress;
}
public WebElement getSubmitclick() {
	return submitclick;
}
public WebElement getEyeclick() {
	return eyeclick;
}
public WebElement getCheckaddress() {
	return checkaddress;
}
}
