package com.Vtiger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericutil.ReadData_prop;


public class CreateOrg extends ReadData_prop {

	public static void main(String[] args) throws IOException {

		
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

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("SONY_TYSS");

		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();


	}
}