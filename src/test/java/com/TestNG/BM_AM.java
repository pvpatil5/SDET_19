package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BM_AM {
	
	
	@BeforeClass
	public void launchbrowser() {
		System.out.println("browser launched");
	}
	
	
	@BeforeMethod
	public void logintoApp() 
	{
		Assert.assertEquals(true, true);
		System.out.println("Login Successful");
		System.out.println("Login Successful");
	}

	@Test
	public void test1() 
	{
		Assert.assertEquals(true, false);
		System.out.println("Org created successfully");
	}
	
	@AfterMethod
	public void logout() 
	{
		System.out.println("Logged out successfully");
	}
}
