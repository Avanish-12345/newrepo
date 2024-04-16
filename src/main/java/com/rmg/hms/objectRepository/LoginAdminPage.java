package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAdminPage
{
@FindBy(name = "username")
private WebElement usernametextfield;
@FindBy(name = "password")
private WebElement passwordtextfield;
@FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
private WebElement loginlink;
public WebElement getLoginlink() {
	return loginlink;
}

public WebElement getUsernametextfield() {
	return usernametextfield;
}
public WebElement getPasswordtextfield() {
	return passwordtextfield;
}
public LoginAdminPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
	
}

public void loginAsAdmin(String userName,String password) {
	usernametextfield.sendKeys(userName);
	passwordtextfield.sendKeys(password);
	loginlink.click();
}
}
