package com.cybertek;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTest {

	@Test
	
	public void addTest() {
		int expected = 2;
		Unit unit = new Unit();
		int actual = unit.add(1,1);
		
		Assert.assertEquals(actual, expected);
		
	}
	
//	public static void main(String[] args) {
//		int expected = 2;
//		Test unit = new Test();
//		int actual = unit.add(1,1);
//		
//		if (actual == expected) {
//			System.out.println("pass");
//		}else {
//			System.out.println("fail");
//		}
}
