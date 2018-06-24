package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LookingforFlyght {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.kayak.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#nlsN-destination-airport-display")).click();
		//sendKeys("Kiev");
		
		
//Thread.sleep(10000);
//		
//		// closing tab that was previusly open
//		driver.close();
}
}