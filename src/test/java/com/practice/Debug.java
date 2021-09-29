package com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Debug {

	
	@Test
	public void login()
	{
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		Debug1 d1 = new Debug1();
		d1.loginVtiger(driver);
	}
}
