package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//create a webelement + perform action(click, sendKeys, getText, isDispplayed)
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//1.
		/*
		 * driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
		 * driver.findElement(By.id("input-password")).sendKeys("test123");
		 */
		
		/*//2.
		 * WebElement emailId = driver.findElement(By.id("input-email")); WebElement
		 * password = driver.findElement(By.id("input-password"));
		 * 
		 * emailId.sendKeys("test@gmail.com"); password.sendKeys("test123");
		 */
		
		/*//3.
		 *  By username = By.id(("input-email")); By pwd = By.id("input-password"); //object repository
		 * 
		 * WebElement emailId = driver.findElement(username); WebElement password =
		 * driver.findElement(pwd); /// hitting the server during findelement
		 * 
		 * emailId.sendKeys("test@gmail.com"); password.sendKeys("test123");
		 */
		
		/*
		 * //4. By locator with utility: 
		 * By username = By.id(("input-email")); By pwd =
		 * By.id("input-password"); WebElement emailId = getElement(username);
		 * WebElement password = getElement(pwd);
		 * emailId.sendKeys("test@gmail.com"); password.sendKeys("test123");
		 */
		
		//5.
		/*
		 * By username = By.id(("input-email")); By pwd = By.id("input-password");
		 * WebElement emailId = getElement(username); WebElement password =
		 * getElement(pwd);
		 * 
		 * doSendKeys(username, "test@gmail.com"); doSendKeys(pwd, "test123");
		 */
		 
		 //6.
		 By username = By.id(("input-email")); 
		 By pwd = By.id("input-password"); 
		 ElementUtil eleUtil = new ElementUtil(driver);
		 eleUtil.doSendKeys(username, "test@gmail.com");
		 eleUtil.doSendKeys(pwd, "test123");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
}
