/*
 * User Story 2:
 * Feature:
 * As a user of Amazon I want to be able to sign in so that I can make purchases. 
 * 
 * Scenarios:
 * 
 * 1. Correct username and correct password
 * 		Given the Amazon sign-in page, when I enter the correct username and password, then I am signed into my account.
 * 2. Incorrect username and incorrect password
 * 		Given the Amazon sign-in page, when I enter the incorrect username and password, then I am not signed into my account and receive an error message.
 * 3. Incorrect username and correct password
 * 		Given the Amazon sign-in page, when I enter the incorrect username and correct password, then I am not signed into my account and receive an error message.
 * 4. Correct username and incorrect password
 *   	Given the Amazon sign-in page, when I enter the correct username and incorrect password, then I am not signed into my account and receive an error message.
 */

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {

	/*
	 * This test assures that with both the correct username and password Sign
	 * in is achieved. 
	 * Username email: softwaretesting1699@gmail.com 
	 * Password: testingcs
	 */
	@Test
	public void testCorrectInput() {
		
		//Create new driver with base URL at amazon.com
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Travel to sign-in page
		driver.findElement(By.id("nav-your-account")).click();

		// Click on text box for email address and enter correct email
		driver.findElement(By.name("email")).sendKeys(
				"softwaretesting1699@gmail.com");

		// Click on text box for password and enter correct password
		driver.findElement(By.name("password")).sendKeys("testingcs");

		// Click "Sign in using our secure server"
		driver.findElement(By.name("signInSubmit-input")).click();

		// Test Case - signed in
		WebElement element = driver.findElement(By.id("ys-top"));
		assertEquals(element.getText(), "Your Amazon.com");
		driver.quit();
	}
	
	/*
	 * This test assures that with both incorrect username and password Sign
	 * in is NOT achieved. 
	 */
	@Test
	public void testIncorrectOutput() {
		
		//Create new driver with base URL at amazon.com
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Travel to sign in page
		driver.findElement(By.id("nav-your-account")).click();

		// Click on text box for email address and enter correct email
		driver.findElement(By.id("ap_email")).sendKeys("1699@gmail.com");
		
		// Click on text box for password and enter correct password
		driver.findElement(By.id("ap_password")).sendKeys("test");
		
		// Click "Sign in using our secure server"
		driver.findElement(By.id("signInSubmit-input")).click();

		// Test Case - NOT signed in
		WebElement element = driver.findElement(By.id("message_error"));
		assertEquals(element.getText(), "There was a problem with your request");
		driver.quit();
	}

	/*
	 * This test assures that with both incorrect username and correct password Sign
	 * in is NOT achieved. 
	 */
	@Test
	public void testWrongUsername() {
		
		//Create new driver with base URL at amazon.com
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Travel to sign in page
		driver.findElement(By.id("nav-your-account")).click();

		// Click on text box for email address and enter correct email
		driver.findElement(By.id("ap_email")).sendKeys("1699@gmail.com");

		// Click on text box for password and enter correct password
		driver.findElement(By.id("ap_password")).sendKeys("testingcs");

		// Click "Sign in using our secure server"
		driver.findElement(By.id("signInSubmit-input")).click();

		// Test Case - NOT signed in
		WebElement element = driver.findElement(By.id("message_error"));
		assertEquals(element.getText(), "There was a problem with your request");
		driver.quit();
	}

	/*
	 * This test assures that with both correct username, but incorrect password Sign
	 * in is NOT achieved. 
	 */
	@Test
	public void testWrongPassword() {
		
		//Create new driver with base URL at amazon.com
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Travel to sign in page
		driver.findElement(By.id("nav-your-account")).click();

		// Click on text box for email address and enter correct email
		driver.findElement(By.id("ap_email")).sendKeys("1699@gmail.com");

		// Click on text box for password and enter correct password
		driver.findElement(By.id("ap_password")).sendKeys("test");

		// Click "Sign in using our secure server"
		driver.findElement(By.id("signInSubmit-input")).click();

		// Test Case - NOT signed in
		WebElement element = driver.findElement(By.id("message_error"));
		assertEquals(element.getText(), "There was a problem with your request");
		driver.quit();
	}
}
