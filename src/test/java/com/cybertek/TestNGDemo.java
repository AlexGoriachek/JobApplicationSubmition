package com.cybertek;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGDemo {

	@BeforeClass
	public void setUpClass() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");

		System.out.println("Runs once before Begin testing ");

	}
	@BeforeMethod
	public void setUpMethod() {
		System.out.println("Runs before every method");
	}

	@Test
	public void wrongCredentialsTest() {
		driver.fin
		System.out.println("First one");
	}

	@Test
	public void testSecond() {
		System.out.println("Second test");
	}

	@AfterMethod
	public void runonceeveryMethod() {
		System.out.println("Run after every method");
	}

	

	@AfterClass
	void tearDownClass() {
		System.out.println("Runs once after class");

	}
}
