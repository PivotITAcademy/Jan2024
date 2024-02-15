package com.pivotcoachingacademy.Jan24.Jan24FirstMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VishuExample {

	public class ExplicitWait {
		WebDriver driver = null;
		WebDriverWait wait = null;
		Actions action = null;

		@BeforeMethod
		public void gerPageUrl() {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 15);
			action = new Actions(driver);

		}

		@AfterMethod
		public void closeDriver() {
			if (driver != null) {
				driver.quit();
			}
		}

		@Test
		public void subscribeNewsletter() {
			loggingIn();
			navigateToNewsLetter();
		}

		public void loggingIn() {
			WebElement myAccountDropDown = driver.findElement(By.cssSelector(
					"a[href='https://naveenautomationlabs.com/opencart/index.php?route=account/account'][class='dropdown-toggle']"));
			myAccountDropDown.click();
			WebElement loginBtn = driver.findElement(By.cssSelector(
					"	a[href='https://naveenautomationlabs.com/opencart/index.php?route=account/login']"));
			loginBtn.click();
			WebElement inputEmail = driver.findElement(By.cssSelector("input#input-email"));
			inputEmail.sendKeys("vk@gmail.com");
			WebElement inputPassword = driver.findElement(By.cssSelector("input#input-password"));
			inputPassword.sendKeys("Password");
			WebElement submitBtn = driver.findElement(By.cssSelector("input.btn.btn-primary"));
			submitBtn.submit();
		}

		public void navigateToNewsLetter() {

			WebElement newsLetter = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#content ul:last-of-type a")));
			newsLetter.click();
			WebElement newsLetterSubscribe = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("div.form-group div>label:first-of-type input")));
			newsLetterSubscribe.click();

			WebElement continueBtn = wait.until(ExpectedConditions
					.elementToBeClickable(By.cssSelector("div.buttons.clearfix div:last-of-type input")));
			continueBtn.click();
			
			WebElement text= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-success")));
			
			System.out.println(text.getText());
			
		}

	}
}
