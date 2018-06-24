package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ATestThatCleansUp {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test
	public void searchAmazon() {

		driver.get("https:amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Gift" + Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("Gift"));
	}

	@Test

	public void searchonGoogle() {

		driver.get("https:google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Gift" + Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("Nikolaev"));
		driver.close();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
