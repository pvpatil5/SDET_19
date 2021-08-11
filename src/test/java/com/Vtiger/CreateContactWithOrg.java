package com.Vtiger;

import org.dom4j.DocumentException;

import com.genericutil.ReadData_XML;

public class CreateContactWithOrg 
{
	public static void main(String[] args) throws DocumentException {


		ReadData_XML xml = new  ReadData_XML();
		System.out.println(xml.readDatafrom_XML("//SDET/browser"));
	}
}