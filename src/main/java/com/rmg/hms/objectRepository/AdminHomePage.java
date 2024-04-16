package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage 
{

@FindBy(xpath = "//span[text()=' Doctors ']")
private WebElement doctorclick;
@FindBy(xpath = "//span[text()=' Add Doctor']")
private WebElement adddoctorclick;
@FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
private WebElement clickable;
public WebElement getClickable() {
	return clickable;
}
public WebElement getDoctorclick() {
	return doctorclick;
}
public WebElement getAdddcoctorclick() {
	return adddoctorclick;
}
public AdminHomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//span[text()=' Users ']")
private WebElement usersclick;
@FindBy(xpath = "//span[text()=' Manage Users ']")
private WebElement manageuserclick;
public WebElement getUsersclick() {
	return usersclick;
}
public WebElement getManageuserclick() {
	return manageuserclick;
}

 public void rightClickOnDoc() throws InterruptedException {
	 
	 doctorclick.click();
	 Thread.sleep(2000);
	 adddoctorclick.click();
	 Thread.sleep(2000);
}


}
