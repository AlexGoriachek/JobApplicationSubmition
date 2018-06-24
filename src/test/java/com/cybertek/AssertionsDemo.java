package com.cybertek;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AssertionsDemo {

	@AfterMethod
	public void tearDown() {
		System.out.println("clean up");
	}
	@Test
	public void testOne() {
		String a = "qsag";
		String b = "dfh";
		
		System.out.println("Asserting first");
		Assert.assertTrue(false);
		System.out.println("done asserting first");
		
	}
	@Test
	public void testTwo() {
		System.out.println("Asserting second");
		Assert.assertTrue(true);
		System.out.println("done asserting second");
	}
}
