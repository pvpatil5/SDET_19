package com.genericutil;

import java.util.Random;

public class JavaUtil {

	public int createrandonNum() 
	{
		Random r=new Random();
		int ran=r.nextInt(1000);
		return ran;
	}
	
}
