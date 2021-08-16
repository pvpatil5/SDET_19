package com.Vtiger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericutil.FileUtility;
import com.genericutil.WebDriver_Utility;

public class CreateContact_Org
{
	@Test
	public void createContact() throws InterruptedException, IOException {
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

		WebElement contacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contacts.click();

		WebElement addContact = driver.findElement(By.xpath("//img[@title='Create Contact...']"));
		addContact.click();

		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.sendKeys("sharma");

		WebElement addOrgNameBtn = driver.findElement(By.xpath("//img[@title='Select']"));
		addOrgNameBtn.click();

		WebDriver_Utility wdu = new WebDriver_Utility();
		wdu.switchwindow(driver, "Accounts");

		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("PAVAN123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='PAVAN123']")).click();

		wdu.switchwindow(driver, "VTiger");

		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

		WebElement logout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		wdu.movetoelement(driver, logout);

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}
}
