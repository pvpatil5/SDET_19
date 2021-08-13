package com.Vtiger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.genericutil.JavaUtil;
import com.genericutil.ReadData_prop;
import com.genericutil.WebDriver_Utility;


public class CreateOrg extends ReadData_prop {

	@Test
	public void something() throws IOException {


		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		ReadData_prop propfile = new ReadData_prop();
		driver.get(propfile.readDatafrompropfile(("url")));

		String UN = propfile.readDatafrompropfile("UN");

		String pwd = propfile.readDatafrompropfile("PWD");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);

		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);

		driver.findElement(By.id("submitButton")).click();


		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		JavaUtil jv = new JavaUtil();
		int randomnum=jv.createrandonNum();

		String orgname="SONY_TYSS11"+randomnum;
		System.out.println(orgname);

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);

		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		WebDriver_Utility wdu = new WebDriver_Utility();
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		wdu.select_DD(industryDropDown, "Technology");


		WebElement typeDropDown = driver.findElement(By.name("accounttype"));
		wdu.select_DD(typeDropDown, "Analyst");
		
	
		//
		//		WebElement ratingDropDown = driver.findElement(By.name("rating"));
		//		Select select2=new Select(ratingDropDown);
		//		select2.selectByValue("Active");


		WebElement saveBtn = driver.findElement(By.xpath("//input[@class='crmbutton small save']"));

		saveBtn.click();
	}
}