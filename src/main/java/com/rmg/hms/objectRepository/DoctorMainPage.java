package com.rmg.hms.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoctorMainPage
{
@FindBy(xpath = "//span[text()=' Patients ']")
private WebElement patientclick;
@FindBy(xpath = "//span[text()=' Manage Patient ']")
private WebElement managepatientclick;
}
