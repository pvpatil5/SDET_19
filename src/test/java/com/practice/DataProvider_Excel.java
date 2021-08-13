package com.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericutil.ReadData_Excel;

public class DataProvider_Excel  extends ReadData_Excel
{

	@Test(dataProvider = "getvalues")
	public void sdet(String s1,String s2)
	{
		System.out.println(s1+" "+s2);
	}

	@DataProvider
	public Object[][] getvalues() throws EncryptedDocumentException, IOException 
	{
		int  lastrow=	getlastrow();
		Object[] [] arr = new  Object[lastrow+1] [2];
		for (int i = 0; i < lastrow+1; i++)
		{
			arr[i][0]= readDataExcel("Sheet2", i, 0);
			arr[i][1]= readDataExcel("Sheet2", i, 1);
		}
		return arr;
	}
}
