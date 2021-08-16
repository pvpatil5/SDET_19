package com.Vtiger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericutil.FileUtility;
import com.genericutil.JavaUtil;
import com.genericutil.WebDriver_Utility;


public class CreateOrg  {

	@Test
	public void something() throws IOException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		FileUtility fileutility = new FileUtility();
		driver.get(fileutility.readDatafrompropfile(("url")));

		String UN = fileutility.readDatafrompropfile("UN");

		String pwd = fileutility.readDatafrompropfile("PWD");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);

		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		JavaUtil jv = new JavaUtil();
		int randomnum=jv.createrandonNum();

		String orgname="SONY_TYSS"+randomnum;
		System.out.println(orgname);

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);

		

		WebDriver_Utility wdu = new WebDriver_Utility();

		WebElement industryDropDown = driver.findElement(By.name("industry"));
		wdu.select_DD(industryDropDown, "Technology");

		WebElement typeDropDown = driver.findElement(By.name("accounttype"));
		wdu.select_DD(typeDropDown, "Analyst");

		WebElement ratingDropDown = driver.findElement(By.name("rating"));
		wdu.select_DD(ratingDropDown, "Active");

		WebElement saveBtn =driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));

		wdu.elementtobeclickable(driver, saveBtn);
		
	}
}