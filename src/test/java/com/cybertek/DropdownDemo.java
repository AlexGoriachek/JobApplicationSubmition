package com.cybertek;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownDemo {
	// https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/
	// Shared via @Webclipse. To open this file type:
	// /code-open DropdownDemo.java 4 /apKgw
public static void main(String[] args) throws InterruptedException {
	

	WebDriverManager.chromedriver().setup();;
	WebDriver driver = new ChromeDriver();
	driver.get("https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/");
	// 1. find select tag
	
	WebElement selectTag = driver.findElement(By.name("my_html_select_box"));
	
 // 2. create select object from select tag
	Select list = new Select(selectTag);
	// print the selected value option 1
	
	WebElement selected = list.getFirstSelectedOption();
	System.out.println(selected.getText());
	// print the selected value option 2:
	System.out.println(list.getFirstSelectedOption().getText());
	// returns a list of all the options (selected and not selected)
	List<WebElement> options = list.getOptions();
	
	System.out.println("/////");
	for (WebElement webElement : options) {
		
		System.out.println(webElement.getText());
	}
	System.out.println("////");
	list.selectByVisibleText("Madrid");
	
	System.out.println("Selected:\t" + list.getFirstSelectedOption().getText());
	
	list.selectByIndex(2);
	System.out.println("----------------------------------------------");
	Select secondList = new Select(driver.findElement(By.cssSelector("select[multiple='yes']")));
	secondList.selectByVisibleText("New York");
	secondList.selectByVisibleText("Madrid");
	
	System.out.println("Selected:\t" + list.getFirstSelectedOption().getText());
	List<WebElement> allSelectedOptions = secondList.getAllSelectedOptions();
for (WebElement webElement : allSelectedOptions) {
	System.out.println(webElement.getText());
}
System.out.println(allSelectedOptions.size());
secondList.deselectAll();
allSelectedOptions = secondList.getAllSelectedOptions();
System.out.println(allSelectedOptions);
	
	Thread.sleep(20000);
	// closing tab that was previusly open
	driver.close();
	}

	
}

