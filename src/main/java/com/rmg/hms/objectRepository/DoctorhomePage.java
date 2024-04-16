package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorhomePage
{
@FindBy(xpath = "//span[text()=' Patients ']")
private WebElement patientclick;
@FindBy(xpath = "//span[text()=' Add Patient']")
private WebElement addpatientclick;
public WebElement getPatientclick() {
	return patientclick;
}
public WebElement getAddpatientclick() {
	return addpatientclick;
}
public DoctorhomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}
