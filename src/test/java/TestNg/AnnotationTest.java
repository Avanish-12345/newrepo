package TestNg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationTest
{
@BeforeSuite
public void db()
{
	System.out.println("coonect to database");
}
@Test
public void executescript1()
{
	System.out.println("script 1  ");
}
@BeforeMethod
public void launchApp()
{
	System.out.println("login the app");
}
@BeforeClass
public void launchbrowser()
{
	System.out.println("launch the browser");
}
@Test
public void executescript2()
{
	System.out.println("script 2  ");
}
@AfterMethod
public void closeApp()
{
	System.out.println("close app");
}
}
