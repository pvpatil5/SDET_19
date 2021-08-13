package com.genericutil;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility 
{

	/**
	 * @author AMAR-G
	 * 
	 * @param element
	 * @param text
	 */
	public void  select_DD(WebElement element,String text) 
	{
		Select select= new Select(element);
		select.selectByVisibleText(text);

	}

	public void  select_DD(WebElement element,int index) 
	{
		Select select= new Select(element);
		select.selectByIndex(index);


	}
	public void select_DD(String value, WebElement element)
	{
		Select select= new Select(element);
		select.selectByValue(value);
	}

	public void switchframe(WebDriver driver, int index) 
	{
		driver.switchTo().frame(index);
	}

	public void switchframe(WebDriver driver,String nameorId) 
	{
		driver.switchTo().frame(nameorId);
	}
	public void switchframe(WebDriver driver,WebElement element) 
	{
		driver.switchTo().frame(element);
	}

	public void switchwindow(WebDriver driver, String title) 
	{

		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> iterator=windowId.iterator();

		while(iterator.hasNext()) 
		{
			String window=iterator.next();
			String currenttitle= driver.switchTo().window(window).getTitle();
			if(currenttitle.contains(title)) 
			{	
				break;
			}

		}
	}


}
