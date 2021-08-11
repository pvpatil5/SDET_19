package com.genericutil;

import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtil {
@Test
	public void  createrandonNum() 
	{
		Random r=new Random();
		int ran=r.nextInt(1000);
		System.out.println(ran);
	}
	
}
