package com.rmg.hms.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage
{
@FindBy(xpath = "//a[contains(text(),'Create an account')] ")
private WebElement createpatient;
public  PatientLoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getCreatepatient() {
	return createpatient;
}
}

