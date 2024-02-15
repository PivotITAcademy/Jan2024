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

public class ElementClickInterceptedExample {
	WebDriver driver = null;

	WebDriverWait wait;

	@BeforeMethod
	public void intialisation() {
		WebDriverManager.chromedriver().setup();

		// Launch the browser instance
		driver = new ChromeDriver();

		driver.get(
				"https://certn.co/?utm_term=certn&utm_campaign=LCS%20-%20RTC%20-%20Search%20-%20Specifics%20-%20EN&utm_source=adwords&utm_medium=ppc&hsa_acc=5611481948&hsa_cam=13442922707&hsa_grp=123722546375&hsa_ad=526586818028&hsa_src=g&hsa_tgt=kwd-1392367903800&hsa_kw=certn&hsa_mt=b&hsa_net=adwords&hsa_ver=3&gad_source=1&gclid=EAIaIQobChMIvN7X_JishAMVEEpHAR3Bvw1HEAAYASAAEgIcmfD_BwE");
		wait = new WebDriverWait(driver, 30);
	}

	@Test
	public void elementClickIntercepted() {

		WebElement cookieBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
		cookieBtn.click();

		WebElement seeplanBtn = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("div.ccm-custom-style-container:nth-of-type(2) div.row div.row div.row div>a")));

		seeplanBtn.click();
	}

	@Test
	public void elementClickInterceptedCertn() {

		WebElement getStartedBtn = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("#site-navigation div.certn-menu__container>div:last-of-type a:first-of-type")));

		getStartedBtn.click();
	}

}
