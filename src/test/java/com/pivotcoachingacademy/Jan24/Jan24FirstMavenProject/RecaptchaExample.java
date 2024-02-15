package com.pivotcoachingacademy.Jan24.Jan24FirstMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RecaptchaExample {
	WebDriver driver = null;

	WebDriverWait wait;

	@BeforeMethod
	public void intialisation() {
		WebDriverManager.chromedriver().setup();

		// Launch the browser instance
		driver = new ChromeDriver();

		driver.get("https://myaccount.carbonite.com/createaccount?lang=en");
		wait = new WebDriverWait(driver, 30);
	}

	@Test
	public void signup() {
		WebElement cookieBannerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
		cookieBannerBtn.click();

		WebElement enterEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("create-email")));
		enterEmail.sendKeys("mansan@it.com");

		WebElement enterkeycode = wait.until(ExpectedConditions.elementToBeClickable(By.id("create-keycode")));
		enterkeycode.sendKeys("ABCDEFGHIJKLMNOPABCD");

		WebElement enterPwD = wait.until(ExpectedConditions.elementToBeClickable(By.id("create-password")));
		enterPwD.sendKeys("Password1");

		WebElement enterCpwd = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirm-password")));
		enterCpwd.sendKeys("Password1");

		WebElement creteAccBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreateAccount")));

		creteAccBtn.click();
	}

}
