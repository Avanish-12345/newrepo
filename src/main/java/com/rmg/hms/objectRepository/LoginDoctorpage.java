package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDoctorpage
{
@FindBy(name = "username")
private WebElement usernametextfield;
@FindBy(name = "password")
private WebElement passwordtextfield;
@FindBy(xpath = "//button[contains(text(),'	Login')]")
private WebElement loginlink;
public WebElement getUsernametextfield() {
	return usernametextfield;
}
public WebElement getPasswordtextfield() {
	return passwordtextfield;
}
public WebElement getLoginlink() {
	return loginlink;
}
public LoginDoctorpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}
