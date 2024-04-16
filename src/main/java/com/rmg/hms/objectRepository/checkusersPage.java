package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkusersPage
{
@FindBy(xpath = "//td[text()='metro']/..//td[text()='Lohit']")
private WebElement checkusers;
public checkusersPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getCheckusers() {
	return checkusers;
}

}
