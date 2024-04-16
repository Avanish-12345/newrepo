package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.ah.A;

public class WebDriverutilityTest 
{
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
public void minimizewindow(WebDriver driver)
{
	driver.manage().window().minimize();
}
public void quitbrowser(WebDriver driver)
{
	driver.quit();
}
public void waitforPageLoad(WebDriver driver,int sec)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
}
public WebDriverWait webdriverwaitobj(WebDriver driver,int sec)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
	return wait;
}
public void waituntilelementTobeVisibile(WebDriver driver,int sec,WebElement element)
{
	webdriverwaitobj(driver,sec).until(ExpectedConditions.visibilityOf(element));
}
public void waitUntilElementtobeClickable(WebDriver driver,int sec,WebElement element)
{
	webdriverwaitobj(driver,sec).until(ExpectedConditions.elementToBeClickable(element));
}
public void waitUntilTogettitle(WebDriver driver,int sec,String title)
{
	webdriverwaitobj(driver,sec).until(ExpectedConditions.titleContains(title));
}
public Actions performActions(WebDriver driver)
{
	Actions action=new Actions(driver);
	return action;
}
public void enterPressKeyAction(WebDriver driver)
{
	performActions(driver).sendKeys(Keys.ENTER).perform();
}
public void dragAnddropAction(WebDriver driver,WebElement src,WebElement dest)
{
	performActions(driver).dragAndDrop(src, dest).perform();
	
}
public void moveToElementAction(WebDriver driver,WebElement element)
{
	performActions(driver).moveToElement(element).perform();
}
public void clickAndholdAction(WebDriver driver,WebElement element)
{
	performActions(driver).clickAndHold(element).perform();
}
public void contextclickActions(WebDriver driver,WebElement element)
{
	performActions(driver).contextClick(element).perform();
}
public void doubleClickAction(WebDriver driver,WebElement element)
{
	performActions(driver).doubleClick(element).perform();
}
public void sendKeysActions(WebDriver driver,WebElement element,String keys)
{
	performActions(driver).sendKeys(element, keys).perform();
}
public void clickActions(WebDriver driver,WebElement element)
{
	performActions(driver).click(element).perform();
}
public void clearActions(WebDriver driver,WebElement element)
{
	performActions(driver).moveToElement(element).click(element).keyDown(Keys.CONTROL).sendKeys("a").pause(2000).keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
}
public Select HandleDropdowns(WebElement element)
{
	Select select=new Select(element);
	return select;
}
public void visibilitytextDropdown(WebElement element,String text)
{
	HandleDropdowns(element).selectByVisibleText(text);
}
public void ValueDropDown(WebElement element,String value)
{
	HandleDropdowns(element).selectByValue(value);
}
public void indexDropDown(WebElement element,int index)
{
	HandleDropdowns(element).selectByIndex(index);
}
public void switchToWindow(WebDriver driver,String expWindow)
{
	Set<String> windows=driver.getWindowHandles();
	Iterator<String> iterator=windows.iterator();
	while(iterator.hasNext())
	{
		String winner=iterator.next();
		String currenttitle=driver.switchTo().window(winner).getTitle();
		if(currenttitle.contains(expWindow))
		{
			break;
		}
	}
}
public void switchToFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
public void switchToFrame(WebDriver driver,String nameOrid)
{
	driver.switchTo().frame(nameOrid);
}
public void switchToFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}
public Robot robotobj() throws AWTException
{
	Robot robot=new Robot();
	return robot;
			
}
public void enterKeyPress(WebDriver driver) throws AWTException
{
	robotobj().keyPress(KeyEvent.VK_ENTER);
}
public void enterKeyRelease(WebDriver driver) throws AWTException
{
	robotobj().keyRelease(KeyEvent.VK_ENTER);
}
public static String getScreenShot(WebDriver driver,String screenshotname) throws IOException
{
	JavaUtility jutils=new JavaUtility();
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String path="./screenshot/"+screenshotname+" "+jutils.getSystemDateinFormat()+".png";
	File dest=new File(path);
	String srcpath=dest.getAbsolutePath();
	FileUtils.copyFile(src, dest);
	return srcpath;
}
public void scrolltillbottom(WebDriver driver)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.s", null);
}
public void clickonElement(WebDriver driver,WebElement element)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguements[0].click", element);
	
}
public void sendKeys(WebDriver driver,WebElement element,String text)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguements[0].value=arguements[1]",element,text);
}
public void scrolltillElementtobeVisisble(WebDriver driver,WebElement element)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguements[0].scrollIntoView()", element);
}
public void alertpopupAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
public void alertpopupdismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
{
	
}

}
