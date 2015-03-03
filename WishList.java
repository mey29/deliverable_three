/*
 * User Story 5:
 * Feature:
 * As a user of Amazon I want to manage my wish lists so that I can store future potential purchases. 
 * 
 * Scenarios:
 * 
 * 1. Create a new wish list
 * 		Given a signed in Amazon account Wish List page, when I click "Create another Wish List," then a new wish list appears.
 * 2. Edit wish list name
 * 		Given a signed in Amazon account Wish List page, when I click "Edit list name," then the list name will display the updated name.
 * 3. Add item to wish list
 * 		Given a signed in Amazon account Wish List page, when I search Moby Dick and click "Add to Wish List," then the novel will be found in the wish list. 
 * 4. Remove item from wish list
 * 		Given a signed in Amazon account Wish List page, when I click "Delete item," then the item is no longer found in the wish list.
 */


import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class WishList {

	WebDriver driver = new FirefoxDriver();

	public void setUp() throws Exception {
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Travel to sign in page
		driver.findElement(By.id("nav-signin-text")).click();
		
		//DEPENDENT ON SIGNING IN CORRECTLY
		driver.findElement(By.id("ap_email")).sendKeys(
				"softwaretesting1699@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("testingcs");
		driver.findElement(By.id("signInSubmit-input")).click();
		driver.findElement(By.id("nav-signin-title")).click();
	}
	
	@Test
	public void testNewList() {
		// Click on "Wish List"
		driver.findElement(By.id("nav-wishlist")).click();
		
		// Add a new address
		driver.findElement(By.id("createList")).click();
		driver.findElement(By.xpath("//input[@type='submit'])[38]"));
		
		//Test Case
		WebElement element = driver.findElement(By.id("profile-list-name"));
		assertNotNull(element);		
		driver.quit();
	}
	
	
	@Test
	public void testAddItem() {
		
		//Search for Moby Dick
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("moby dick");
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		driver.findElement(By.cssSelector("img.s-access-image.cfMarker")).click();
		driver.findElement(By.id("add-to-wishlist-button-submit")).click();
		driver.findElement(By.cssSelector("span.w-button-text")).click();

		//Test Case
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("Moby Dick"));
		driver.quit();
	}
	
	@Test
	public void testRemoveItem() {
		// Click on "Add New Address"
		driver.findElement(By.linkText("Add New Address")).click();
		
		//HERE
		
		//Test Case
		WebElement element = driver.findElement(By.id("myab-alert-bar-title"));
		assertNotNull(element);		
		driver.quit();
	}
	
	@Test
	public void testEditListName() {
		// Click on "Wish List"
		driver.findElement(By.id("nav-wishlist")).click();
		
		driver.findElement(By.linkText("Edit list name")).click();
		driver.findElement(By.cssSelector("input.a-input-text.a-width-large")).sendKeys("Software");
		driver.findElement(By.id("a-autoid-1-announce")).click();
		
		//Test Case
		WebElement element = driver.findElement(By.id("myab-alert-bar-title"));
		assertNotNull(element);		
		driver.quit();
	}	

}
