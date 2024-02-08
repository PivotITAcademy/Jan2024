package com.pivotcoachingacademy.Jan24.Jan24FirstMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionExample {
	EdgeDriver driver = null;
	Actions actions;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Owner\\Downloads\\edgedriver_win64 (4)\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		driver.get("https://demoqa.com/tool-tips");

		actions = new Actions(driver);

		// driver.manage().window().maximize();
	}

	@Test
	public void rightClick() {
		WebElement rightClickBtn = driver.findElement(By.xpath("//button[text()='Right Click Me']"));

		actions.contextClick(rightClickBtn).perform();

	}
	
	@Test
	public void doubleClick() {
		WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));

		actions.doubleClick(doubleClickBtn).perform();

	}
}
