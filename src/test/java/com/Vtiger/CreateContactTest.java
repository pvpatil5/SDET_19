package com.Vtiger;

import java.io.IOException;

import org.testng.annotations.Test;
import com.genericutil.BaseClass;
import com.objectrepo.ContactInfoPage;
import com.objectrepo.CreateContactPage;
import com.objectrepo.HomePage;

public class CreateContactTest extends BaseClass
{
	@Test
	public void createContact() throws InterruptedException, IOException
	{
		
		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();

		ContactInfoPage cp = new ContactInfoPage(driver);
		cp.getCreatecontactsimg().click();

		CreateContactPage cc= new  CreateContactPage(driver);
		cc.getLastNameEdt().sendKeys("sharma");
		
		cc.getSaveBtn().click();


	}
}