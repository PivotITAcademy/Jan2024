package com.pivotcoachingacademy.Jan24.Jan24FirstMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHoverExample {
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

		driver.manage().window().maximize();
	}

	@Test
	public void rightClick() {
		WebElement mouseHoverElement = driver.findElement(By.id("toolTipButton"));

		actions.moveToElement(mouseHoverElement).perform();
		
		String attributeVal=mouseHoverElement.getAttribute("aria-describedby");


		Assert.assertEquals("buttonToolTip", attributeVal);
		
	}
	
	
}
