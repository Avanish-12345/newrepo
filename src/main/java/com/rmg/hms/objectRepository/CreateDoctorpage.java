package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDoctorpage 
{
@FindBy(xpath = "//h3[text()='Doctors Login']/..//a[text()='Click Here']")
private WebElement doctorclick;
@FindBy(name = "username")
private WebElement usernametext;
@FindBy(name="password")
private WebElement passwordtext;
@FindBy(xpath = "//button[contains(text(),'	Login')]")
private WebElement doctorlogin;
public  CreateDoctorpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getDoctorclick() {
	return doctorclick;
}
public WebElement getUsernametext() {
	return usernametext;
}
public WebElement getPasswordtext() {
	return passwordtext;
}
public WebElement getDoctorlogin() {
	return doctorlogin;
}
}
