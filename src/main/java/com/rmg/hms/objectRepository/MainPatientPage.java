package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPatientPage 
{
@FindBy(xpath = "//td[text()='7645667777']/..//td[text()='sohit']")
private WebElement checkpatient;

public WebElement getCheckpatient() {
	return checkpatient;
}
public MainPatientPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}
