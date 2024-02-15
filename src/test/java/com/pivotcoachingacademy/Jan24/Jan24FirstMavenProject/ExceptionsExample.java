package com.pivotcoachingacademy.Jan24.Jan24FirstMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionsExample {
	WebDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		WebDriverManager.chromedriver().setup();

		// Launch the browser instance
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/text-box");
	}

	@Test
	public void frameExceptionExample() {

		WebElement userName = driver.findElement(By.id("userName"));
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		WebElement pAddress = driver.findElement(By.id("permanentAddress"));

		//throw no such frame exception
		driver.switchTo().frame(23);
	}
	
	
	@Test
	public void alertExceptionExample() {

		WebElement userName = driver.findElement(By.id("userName"));
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		WebElement pAddress = driver.findElement(By.id("permanentAddress"));

		driver.switchTo().alert().accept();
	}
}
