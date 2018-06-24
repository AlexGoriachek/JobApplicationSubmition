package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CragsllistsearchOptima {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://washingtondc.craigslist.org/");
	
	driver.findElement(By.linkText("cars+trucks")).click();
	//driver.findElement(By.cssSelector("a[href='/d/business/search/bfa']")).click();
	//driver.findElement(By.className("txt")).click();
	
	driver.findElement(By.name("auto_make_model")).sendKeys("Kia Optima");
	driver.findElement(By.name("max_price")).sendKeys("1600");
	driver.findElement(By.name("min_auto_year")).sendKeys("2006");
	driver.findElement(By.name("max_auto_year")).sendKeys("2009"+Keys.ENTER);
	
	
	
	Thread.sleep(30000);
	// closing tab that was previusly open
	driver.close();
}
}
