package com.genericutil;

import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtil {
@Test
	public int  createrandonNum() 
	{
		Random r=new Random();
		return  r.nextInt(1000);
		
	}
	
}
