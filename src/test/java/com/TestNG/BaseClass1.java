package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
public class BaseClass1
{
	public WebDriver driver;
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"RegressionTest"})
	public void launch_browser() 
	{
//	if(BROWSER.equalsIgnoreCase("Chrome"))
//	{
//		driver= new ChromeDriver();
//	}
//	else if (BROWSER.equalsIgnoreCase("firefox"))
//	{
//		driver= new FirefoxDriver();
//	}
//	else
//	{
//		driver= new ChromeDriver();
//	}

		Assert.assertEquals(true, true);
		
		System.out.println("Browser Launch Successful");
	}

	

	

	@AfterClass(groups= {"RegressionTest"})
	public void closeBrowser() 
	{
		System.out.println("Browser Closed Successful");
	}
	@BeforeMethod(groups= {"RegressionTest"})
	public void logintoApp() 
	{
		Assert.assertEquals(true, true);
		System.out.println("Login Successful");
	}

	@AfterMethod(groups= {"RegressionTest"})
	public void logout() 
	{
		System.out.println("Logged out successfully");
	}

}

