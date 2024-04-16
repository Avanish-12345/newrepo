package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatepatientPage 
{
@FindBy(name = "full_name")
private WebElement fullname;
@FindBy(name = "address")
private WebElement address;
@FindBy(name="city")
private WebElement city;
@FindBy(xpath = "//label[contains(text(), Male )][2]")
private WebElement male;
@FindBy(name = "email")
private WebElement email;
@FindBy(name = "password")
private WebElement password;
@FindBy(name="password_again")
private WebElement passwordagain;
@FindBy(name = "submit")
private WebElement submit;
public WebElement getFullname() {
	return fullname;
}
public WebElement getAddress() {
	return address;
}
public WebElement getCity() {
	return city;
}
public WebElement getMale() {
	return male;
}
public WebElement getEmail() {
	return email;
}
public WebElement getPassword() {
	return password;
}
public WebElement getPasswordagain() {
	return passwordagain;
}
public WebElement getSubmit() {
	return submit;
}
public CreatepatientPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

}
