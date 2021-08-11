package com.genericutil;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class ReadData_XML {

	public String readDatafrom_XML(String node) throws DocumentException 
	{

		File inputfile = new File("../SDET_19/src/test/resources/CommonDAta.xml");
		SAXReader reader = new SAXReader();
		Document doc = reader.read(inputfile);
		String value = doc.selectSingleNode(node).getText();

		return value;
	}

}
