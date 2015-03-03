/*
 * User Story 3:
 * Feature:
 * As a user of Amazon I want to manage my account so that I can have up-to-date information and I am aware of account balances. 
 * 
 * Scenarios:
 * 
 * 1. Add a new address
 * 		Given a signed in Amazon account page, when I click "Add New Address," then a new address can be constructed.
 * 2. Change name
 * 		Given a signed in Amazon account page, when I click "Change Account Settings," then my name can be updated.
 * 3. View product availability alerts
 * 		Given a signed in Amazon account page, when I click "Product Availability Alerts," then all alerts associated with the account will be listed.
 * 4. View past orders
 * 		Given a signed in Amazon account Wish List page, when I click "View Archived Orders," then I see a list of order history.
 * 5. View gift card balance
 * 		Given a signed in Amazon account page, when I click "View Gift Card Balance," then my current gift card balance is displayed.
 * 6. View payment options
 * 		Given a signed in Amazon account page, when I click "Manage Payment Options," then a list of payment methods for my account is displayed.
 * 7. View browsing history
 * 		Given a signed in Amazon account page, when I click "View and Edit Your Browsing History," then all recently viewed items appear.
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageAccount {

	// Create new WebDriver
	WebDriver driver = new FirefoxDriver();

	public void setUp() throws Exception {
		
		// Base URL of WebDriver at amazon.com
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Travel to sign in page
		driver.findElement(By.id("nav-signin-text")).click();

		// DEPENDENT ON SIGNING IN CORRECTLY
		driver.findElement(By.id("ap_email")).sendKeys(
				"softwaretesting1699@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("testingcs");
		driver.findElement(By.id("signInSubmit-input")).click();
		driver.findElement(By.cssSelector("#nav-your-account > span.nav-button-title.nav-button-line2")).click();
	}

	/*
	 * This test case checks that a successful message is received upon updating
	 * the account name.
	 */
	@Test
	public void testNameChange() {
		
		// Click on "Change Account Settings"
		driver.findElement(By.linkText("Change Account Settings")).click();

		// Click on change name
		driver.findElement(By.id("cnep_1A_change_name_button-input")).click();

		// Enter new name
		driver.findElement(By.id("ap_customer_name")).sendKeys(
				"SoftwareUpgrade");
		driver.findElement(By.id("cnep_1C_submit_button-input")).click();

		// Test Case
		WebElement element = driver.findElement(By.id("message_success"));
		assertNotNull(element);
		driver.quit();
	}

	/*
	 * This test case checks that a successful message is received upon 
	 * adding a new address.
	 */
	@Test
	public void testAddAddress() {
		
		// Click on "Add New Address"
		driver.findElement(By.linkText("Add New Address")).click();

		// Add a new address
		driver.findElement(By.id("enterAddressFullName")).sendKeys("Software");
		driver.findElement(By.id("enterAddressAddressLine1")).sendKeys(
				"4200 Fifth Avenue");
		driver.findElement(By.id("enterAddressCity")).sendKeys("Pittsburgh");
		driver.findElement(By.id("enterAddressState")).sendKeys("Pennsylvania");
		driver.findElement(By.id("enterAddressPostalCode")).sendKeys("15260");
		driver.findElement(By.id("enterAddressPhoneNumber")).sendKeys(
				"4126244141");
		driver.findElement(By.id("myab_newAddressButton")).click();

		// Test Case
		WebElement element = driver.findElement(By.id("myab-alert-bar-title"));
		assertNotNull(element);
		driver.quit();
	}

	/*
	 * This test case checks that no alerts exist for the account.
	 */
	@Test
	public void testAvailabilityAlerts() {
		
		// Click on "Product Availability Alerts"
		driver.findElement(By.linkText("Product Availability Alerts")).click();
		
		// Test Case
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("You do not have any alerts."));

		driver.quit();
	}

	@Test
	public void testViewOrders() {
		
		// Click on "View Archived Orders"
		driver.findElement(By.linkText("View Archived Orders")).click();
		
		// Test Case
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("There are no archived orders in your account"));

		driver.quit();
	}

	@Test
	public void testViewGiftCardBalance() {
		
		// Click on "View Gift Card Balance"
		driver.findElement(By.linkText("View Gift Card Balance")).click();
	
		// Test Case
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("$0.00"));
		driver.quit();
	}

//	@Test
//	public void testPaymentOptions() {
//		// Click on "Add New Address"
//		driver.findElement(By.linkText("Add New Address")).click();
//
//		//HERE
//
//		// Test Case
//		WebElement element = driver.findElement(By.id("myab-alert-bar-title"));
//		assertNotNull(element);
//		driver.quit();
//	}

	@Test
	public void testBrowsingHistory() {
		// Click on "View and Edit Your Browsing History"
		driver.findElement(By.linkText("View and Edit Your Browsing History")).click();
		
		// Test Case
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("Moby Dick"));
		driver.quit();
	}
}
