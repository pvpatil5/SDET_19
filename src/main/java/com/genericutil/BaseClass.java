package com.genericutil;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.objectrepo.HomePage;
import com.objectrepo.LoginPage;

public class BaseClass
{
	public WebDriver driver;
	public WebDriver_Utility wdu = new WebDriver_Utility();
	public FileUtility fileutility = new FileUtility();


	@BeforeSuite
	public void setup_JDBC_Report() 
	{
		System.out.println("=====JDBC Connection Done====");
	}

	@AfterSuite
	public void close_JDBC_Report() {
		System.out.println("=====JDBC Connection Closed====");
	}


	@BeforeClass
	public void launchBrowser() throws IOException 
	{
		String BROWSER =fileutility.readDatafrompropfile("browser");

		if(BROWSER.equalsIgnoreCase("Chrome")) 
		{
			driver= new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		else {
			driver= new ChromeDriver();
		}

		driver.get(fileutility.readDatafrompropfile("url"));
		wdu.maximizewindow(driver);
		wdu.pageloadtimeout(driver);
	}

	@AfterClass
	public void closeBrowser() 
	{
		driver.close();
	}

	@BeforeMethod
	public void logintoVtiger() throws IOException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginintoApp();
	}

	@AfterMethod
	public void logoutVtiger() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutfromApp();
	}

}
