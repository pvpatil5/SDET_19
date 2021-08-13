package com.Vtiger;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericutil.ReadData_prop;

public class CreateContact_Org
{
	@Test
	public void createContact() throws InterruptedException, IOException {
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

		WebElement contacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contacts.click();

		WebElement addContact = driver.findElement(By.xpath("//img[@title='Create Contact...']"));
		addContact.click();

		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.sendKeys("sharma");

		WebElement addOrgNameBtn = driver.findElement(By.xpath("//img[@title='Select']"));
		addOrgNameBtn.click();

		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> iterator=windowId.iterator();

		while(iterator.hasNext()) 
		{
			String window=iterator.next();
			String title= driver.switchTo().window(window).getTitle();
			if(title.contains("Accounts")) 
			{	
				break;
			}

		}

		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("PAVAN123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='PAVAN123']")).click();

		//		Set<String> windowId = driver.getWindowHandles();
		//		Iterator<String> iterator=windowId.iterator();


		//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();


	}
}
