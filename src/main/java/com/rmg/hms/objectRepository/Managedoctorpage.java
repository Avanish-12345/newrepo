package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Managedoctorpage 
{
@FindBy(xpath = "//td[text()='cardiologist']/..//td[text()='Rohit']")
private WebElement checkDoctor;

public WebElement getCheckDoctor() {
	return checkDoctor;
}
public Managedoctorpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}
