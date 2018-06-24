package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//1.
//Open browser
//2.
//Open Etsy homepage
//3.
//Enter search term
//4.
//Verify the results page 
//title contains the search term
//5.
//Verify search entry is still saved in the search bar
//public class VerifySearch {
//	public static void main(String[] args) throws InterruptedException {
//		 WebDriverManager.chromedriver().setup();
//		 
//		    WebDriver driver = new ChromeDriver();
//		    driver.get("http://etsy.com");
//		    String searchTerm = "fathers day gifts";
//		    
//		    WebElement input = driver.findElement(By.("value"));
//		    
//		    input.sendKeys(searchTerm);
//		    
//		    driver.findElement(By.className("btn-primary")).click();
//		    
//		     // input.sendKeys(searchTerm+Keys.ENTER);// page reshreshed/ directed to results page
//		    // locate the element again. 
//		    
//		    input = driver.findElement(By.id("search-query"));
//		    
//		    // get the text of the element
//		    String actual = input.getAttribute("value");
//		    
//		    System.out.println(actual);
//
//		    if (actual.equals(searchTerm)) {
//		      System.out.println("pass");
//		    } else {
//		      System.out.println("fail");
//		      System.out.println("expected:\t"+searchTerm);
//		      System.out.println("found:\t"+actual);
//		      
//		    }
//		Thread.sleep(10000);
//		// closing tab that was previusly open
//		driver.close();
//
//	}
//}
