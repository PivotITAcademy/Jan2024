package com.pivotcoachingacademy.Jan24.Jan24FirstMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basil {

	public class SeleniumAssignment {

		WebDriver driver = null;
		WebDriverWait wait = null;
		Actions action=null;

		@BeforeMethod
		public void Initialization() {
			
			WebDriverManager.firefoxdriver().setup();

			// To launch the browser instancE

			driver = new FirefoxDriver();

			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			wait = new WebDriverWait(driver, 15);
			
			action=new Actions(driver);
			
			driver.manage().window().maximize();
		}

		@Test

		public void AddingProducttoCart() {

			WebElement addProductToCart = wait.until(ExpectedConditions
					.elementToBeClickable(By.cssSelector("#content div.row>div:nth-of-type(1) button:first-of-type")));
			addProductToCart.click();

			WebElement goToCart = wait.until(ExpectedConditions.elementToBeClickable(By.id("cart-total")));
			goToCart.click();

			WebElement checkout = driver
					.findElement(By.xpath("//*[@class='dropdown-menu pull-right']/li[2]/div/p/a[2]"));
			checkout.click();

			WebElement radioGuestCheckout = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='guest']")));
			radioGuestCheckout.click();

			WebElement continueBtn = driver.findElement(By.xpath("//*[@id='button-account']"));
			continueBtn.click();

			WebElement firstName = driver.findElement(By.id("input-payment-firstname"));
			WebElement lastName = driver.findElement(By.id("input-payment-lastname"));
			WebElement email = driver.findElement(By.id("input-payment-email"));
			WebElement telephoneNumber = driver.findElement(By.id("input-payment-telephone"));
			WebElement address = driver.findElement(By.id("input-payment-address-1"));
			WebElement city = driver.findElement(By.id("input-payment-city"));
			WebElement postalCode = driver.findElement(By.id("input-payment-postcode"));

			firstName.sendKeys("Basil");
			lastName.sendKeys("Thomas");
			email.sendKeys("abcabc@gmail.com");
			telephoneNumber.sendKeys("6390001234");
			address.sendKeys("123 Hillcrest Place");
			city.sendKeys("Edmonton");
			postalCode.sendKeys("T5R 5X6");

			WebElement dropCountry = driver.findElement(By.id("input-payment-country"));
			Select drpCountry = new Select(dropCountry);
			drpCountry.selectByVisibleText("Canada");

			WebElement dropZone = driver.findElement(By.id("input-payment-zone"));
			Select drpZone = new Select(dropZone);

			drpZone.selectByValue("602");

			WebElement billingContinue = driver.findElement(By.id("button-guest"));
			billingContinue.click();

			WebElement termsAndConditionRadioBtn = driver.findElement(By.xpath("//*[@name='agree']"));
			termsAndConditionRadioBtn.click();

		}

	}
}
