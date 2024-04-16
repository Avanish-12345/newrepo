package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePatientPage 
{
@FindBy(xpath = "//span[text()=' Patients ']")
private WebElement patientclick;
@FindBy(xpath = "//span[text()=' Manage Patients ']")
private WebElement managepatientclick;
public WebElement getPatientclick() {
	return patientclick;
}
public WebElement getManagepatientclick() {
	return managepatientclick;
}
public AdminHomePatientPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

}
