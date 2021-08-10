package com.genericutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData_prop {

	
	/**
	 * @author AMAR-G
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDatafrompropfile(String key) throws IOException 
	{
		
		FileInputStream fis = new FileInputStream("../SDET_19/src/test/resources/CommonData.properties");	
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
	
}
