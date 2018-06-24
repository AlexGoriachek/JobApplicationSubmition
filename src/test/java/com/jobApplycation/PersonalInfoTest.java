package com.jobApplycation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import static org.testng.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PersonalInfoTest {
	WebDriver driver;
	WebDriver driverForIP;
	String firstName;
	String lastName;
	int gender;
	String dateOfBirth;
	String email;
	String city;
	String state;
	String country;
	int annualSalary;
	List<String> technologies;
	int yearsOfExperience;
	String education;
	String github;
	List<String> certifications;
	String additionalSkills;
	Faker data = new Faker();
	Random random = new Random();
	String phoneNumber;
	String actualIP;
	String expectedIP;
	String actualGender;
	String expectedGender;
	String countryElem;
	String tempTechno = new String();
	String educationchoise;

	@BeforeClass // runs once for all tests

	public void setUp() {

		System.out.println("Setting up WebDriver in BeforeClass...");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@BeforeMethod // runs before each @Test

	public void navigateToHomePage() {

		System.out.println("Navigating to homepage in @BeforeMethod....");

		driver.get(
				"https://forms.zohopublic.com/murodil/form/JobApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4_mekBNfNLIconAHvfdIk3CJSQ");

		firstName = data.name().firstName();

		lastName = data.name().lastName();

		gender = data.number().numberBetween(1, 3);

		dateOfBirth = data.date().birthday().toString();

		email = "kaxajiqa-6031@yopmail.com";

		phoneNumber = data.phoneNumber().cellPhone().replace(".", "");

		city = data.address().cityName();

		state = data.address().stateAbbr();

		annualSalary = data.number().numberBetween(60000, 150000);

		technologies = new ArrayList<>();

		technologies.add("Java-" + data.number().numberBetween(1, 4));

		technologies.add("HTML-" + data.number().numberBetween(1, 4));

		technologies.add("Selenium WebDriver-" + data.number().numberBetween(1, 4));
		technologies.add("Maven-" + data.number().numberBetween(1, 4));

		technologies.add("Git-" + data.number().numberBetween(1, 4));
		technologies.add("TestNG-" + data.number().numberBetween(1, 4));

		technologies.add("JUnit-" + data.number().numberBetween(1, 4));

		technologies.add("Cucumber-" + data.number().numberBetween(1, 4));

		technologies.add("API Automation-" + data.number().numberBetween(1, 4));

		technologies.add("JDBC-" + data.number().numberBetween(1, 4));

		technologies.add("SQL-" + data.number().numberBetween(1, 4));

		yearsOfExperience = data.number().numberBetween(1, 11);

		education = data.number().numberBetween(1, 4) + "";

		github = "https://github.com/CybertekSchool/selenium-maven-automation.git";

		certifications = new ArrayList<>();

		certifications.add("Java OCA");

		certifications.add("AWS");

		additionalSkills = data.job().keySkills();

	}

	@Test

	public void submitFullApplication() {

		driver.findElement(By.xpath("//input[@name='Name_First']")).sendKeys(firstName);

		driver.findElement(By.xpath("//input[@name='Name_Last']")).sendKeys(lastName);

		setGender(gender);

		setDateOfBirth(dateOfBirth);

		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email);

		driver.findElement(By.xpath("//input[@name='countrycode']")).sendKeys(phoneNumber);

		driver.findElement(By.xpath("//input[@name='Address_City']")).sendKeys(city);

		driver.findElement(By.xpath("//input[@name='Address_Region']")).sendKeys(state);

		Select countryElem = new Select(driver.findElement(By.xpath("//select[@id='Address_Country']")));

		countryElem.selectByIndex(data.number().numberBetween(1, countryElem.getOptions().size()));
		// here we checking where is a country in

		country = countryElem.getFirstSelectedOption().getText();

		driver.findElement(By.xpath("//input[@name='Number']")).sendKeys(String.valueOf(annualSalary) + Keys.TAB);

		verifySalaryCalculations(annualSalary);

		driver.findElement(By.xpath("//em[.=' Next ']")).click();

		// SECOND PAGE ACTIONS

		setSkillset(technologies);

		if (yearsOfExperience > 0) {

			driver.findElement(By.xpath("//a[@rating_value='" + yearsOfExperience + "']")).click();

		}

		Select educationList = new Select(driver.findElement(By.xpath("//select[@name='Dropdown']")));

		educationList.selectByIndex(data.number().numberBetween(1, educationList.getOptions().size()));
		// getting the selected option from education list

		educationchoise = educationList.getFirstSelectedOption().getText();
		System.out.println("This is education " + educationchoise);
		driver.findElement(By.xpath("//input[@name='Website']")).sendKeys(github);
		driver.findElement(By.xpath("//input[@value='Java OCA']")).click();
		driver.findElement(By.xpath("//input[@value='Scrum Master']")).click();
		driver.findElement(By.xpath("//textarea[@name='MultiLine']")).clear();
		driver.findElement(By.xpath("//textarea[@name='MultiLine']")).sendKeys(additionalSkills);
		driver.findElement(By.xpath("//button[@class='fmSmtButton submitColor fmSmtButtom']")).click();
		// application is submit
		// now we are checking the if subbmition is the same what will put in
		// application
		IpAddress();
		nameCompressing();
		genderCompressing();
		emailCompressing();
		phoneCompressing();
		adressCompressing();
		annualSalaryCompressing();
		yearsOfExperience();
		technologiesCompressing();
		EducationCompressing();
		GitHubCompressing();
		//CertificationsCompressing();
		AdditionalSkillsCompressing();
	}

	public void setSkillset(List<String> tech) {

		for (String skill : tech) {

			String technology = skill.substring(0, skill.length() - 2);

			int rate = Integer.parseInt(skill.substring(skill.length() - 1));

			String level = "";

			switch (rate) {

			case 1:

				level = "Expert";

				break;

			case 2:

				level = "Proficient";

				break;

			case 3:

				level = "Beginner";

				break;

			default:

				fail(rate + " is not a valid level");

			}

			String xpath = "//input[@rowvalue='" + technology + "' and @columnvalue='" + level + "']";

			driver.findElement(By.xpath(xpath)).click();

			/*
			 * tempTechno we need to save in string all techno skills in one formate
			 * Technologies: Java : Proficient HTML : Proficient Selenium WebDriver :
			 * Beginner Maven : Beginner Git : Beginner TestNG : Expert JUnit : Proficient
			 * Cucumber : Expert API Automation : Expert JDBC : Expert SQL : Beginner
			 */

			tempTechno += "  " + technology + " : " + level;
			System.out.println("techno :" + tempTechno);

		}

	}

	public void verifySalaryCalculations(int annual) {

		String monthly = driver.findElement(By.xpath("//input[@name='Formula']")).getAttribute("value");

		String weekly = driver.findElement(By.xpath("//input[@name='Formula1']")).getAttribute("value");

		String hourly = driver.findElement(By.xpath("//input[@name='Formula2']")).getAttribute("value");

		System.out.println(monthly);

		System.out.println(weekly);

		System.out.println(hourly);

		DecimalFormat formatter = new DecimalFormat("#.##");

		assertEquals(Double.parseDouble(monthly), Double.parseDouble(formatter.format((double) annual / 12.0)));

		assertEquals(Double.parseDouble(weekly), Double.parseDouble(formatter.format((double) annual / 52.0)));

		assertEquals(Double.parseDouble(hourly), Double.parseDouble(formatter.format((double) annual / 52.0 / 40.0)));

	}

	public void setDateOfBirth(String bday) {

		String[] pieces = bday.split(" ");

		String birthDay = pieces[2] + "-" + pieces[1] + "-" + pieces[5];

		driver.findElement(By.xpath("//input[@id='Date-date']")).sendKeys(birthDay);

	}

	public void setGender(int n) {

		if (n == 1) {

			driver.findElement(By.xpath("//input[@value='Male']")).click();

		} else {

			driver.findElement(By.xpath("//input[@value='Female']")).click();

		}

	}

	@Test

	public void fullNameEmptyTest() {

		// firstly assert that you are on the correct page

		assertEquals(driver.getTitle(), "SDET Job Application");

		driver.findElement(By.xpath("//input[@elname='first']")).clear();

		driver.findElement(By.xpath("//*[@elname='last']")).clear();

		driver.findElement(By.xpath("//em[.=' Next ']")).click();

		String nameError = driver.findElement(By.xpath("//p[@id='error-Name']")).getText();

		assertEquals(nameError, "Enter a value for this field.");

	}

	public void nameCompressing() {
		String actualFullName = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[1]")).getText();
		System.out.println("Actual name:" + actualFullName.substring(4, actualFullName.length() - 1));
		String expectedFullName = (firstName + " " + lastName);
		System.out.println("expected name:" + expectedFullName);
		assertEquals(actualFullName.substring(5, actualFullName.length() - 1), expectedFullName);
	}

	public void IpAddress() {

		driverForIP = new ChromeDriver();
		driverForIP.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driverForIP.get("https://www.google.com/");
		driverForIP.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("What is my IP address" + Keys.ENTER);
		expectedIP = driverForIP.findElement(By.xpath("//div[@class='pIpgAc xyYs1c XO51F xsLG9d']")).getText();
		actualIP = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[6]")).getText();

		assertEquals(actualIP.substring(12), expectedIP);

	}

	public void genderCompressing() {

		System.out.println(gender);
		if (gender == 1) {
			actualGender = "Gender:Male";
		} else {
			actualGender = "Gender:Female";
		}
		expectedGender = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[9]")).getText();
		System.out.println("expected gender:" + expectedGender);
		assertEquals(actualGender, expectedGender);

	}

	public void emailCompressing() {

		String expectedEmail = "Email: " + email;
		String actualEmail = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[11]")).getText();
		System.out.println("actualEmail:" + actualEmail);
		assertEquals(actualEmail, expectedEmail);
	}

	public void phoneCompressing() {

		String expectedPhone = "Phone: " + phoneNumber;
		String actualPhone = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[12]")).getText();
		System.out.println("actualPhone:" + actualPhone);
		assertEquals(actualPhone, expectedPhone);
	}

	public void adressCompressing() {

		String expectedAddress = "Address: " + city + ", " + state + ", " + country;
		System.out.println("expectedAddress:" + expectedAddress);
		String actualAddress = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[13]")).getText();
		System.out.println("actualAddress:" + actualAddress);
		assertEquals(actualAddress, expectedAddress);
	}

	public void annualSalaryCompressing() {

		String expectedannualSalary = "Annual Salary: " + annualSalary;
		String actualannualSalary = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[14]")).getText();
		System.out.println("expectedannual:" + expectedannualSalary);
		System.out.println("Annual Salary:" + actualannualSalary);
		assertEquals(actualannualSalary, expectedannualSalary);
	}

	public void technologiesCompressing() {

		String actualtechnologies = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[15]")).getText();
		String expectedtechnologies = "Technologies: " + tempTechno.substring(2);

		System.out.println("expectedtechnologies:" + expectedtechnologies);
		System.out.println("actualtechnologies :" + actualtechnologies);

		assertEquals(expectedtechnologies, actualtechnologies);

	}

	public void yearsOfExperience() {
		String expectedyearsOfExperience = "Years of Experience: " + yearsOfExperience;
		String actualyearsOfExperience = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[16]"))
				.getText();
		System.out.println("Expected Years of Experience:" + expectedyearsOfExperience);
		System.out.println("Years of Experience:" + actualyearsOfExperience);
		assertEquals(actualyearsOfExperience, expectedyearsOfExperience);

	}

	public void EducationCompressing() {

		String actualEducation = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[17]")).getText();
		String expectedEducation = "Education: " + educationchoise;

		System.out.println("expectedEducation:" + expectedEducation);
		System.out.println("actualteEducation:" + actualEducation);

		assertEquals(expectedEducation, actualEducation);
	}

	public void GitHubCompressing() {

		String actualGitHub = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[18]")).getText();
		String expectedGitHub = "GitHub: " + github;

		System.out.println("expectedGitHub:" + expectedGitHub);
		System.out.println("actualteGitHub:" + actualGitHub);

		assertEquals(expectedGitHub, actualGitHub);
	}

	public void CertificationsCompressing() {

		String actualCertifications = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[19]")).getText();
		String expectedCertifications = "Certifications: " + "" ;
		
		System.out.println("expectedCertifications:" + expectedCertifications);
		System.out.println("actualteCertifications:" + actualCertifications);
		
		assertEquals(expectedCertifications, actualCertifications);
	}
@Test
	public void AdditionalSkillsCompressing() {

		String actualAdditionalSkills = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[20]")).getText();
		String expectedAdditionalSkills = "Additional Skills: " + additionalSkills ;
		
		System.out.println("expectedAdditionalSkills:" + expectedAdditionalSkills);
		System.out.println("actualteAdditionalSkills:" + actualAdditionalSkills);
		
		assertEquals(expectedAdditionalSkills, actualAdditionalSkills);
	}
}