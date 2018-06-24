package com.cybertek;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {
	WebDriver driver;

	@BeforeClass
	public void setUpClass() {

	}

	@BeforeMethod
	public void setUpMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("goes to websait");
		driver.get("http://amazon.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void SearchBookOnAmazon() throws InterruptedException {

		driver.findElement(By.name("field-keywords")).sendKeys("selenium cookbook");
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).sendKeys(Keys.ENTER);
		 String xpath = "//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal'][.='Selenium Testing Tools Cookbook']";
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java OCA"+Keys.ENTER);

		Thread.sleep(3000);
		try {
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		System.out.println(driver.findElement(By.xpath(xpath)).isDisplayed());
		
	}
}