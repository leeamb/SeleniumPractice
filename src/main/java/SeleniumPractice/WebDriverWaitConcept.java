package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// WAit(Interface): until(); -- Fluentwait(class): @overridden until(){} + other methods -- WebDriverWait(class) : no methods
		
		 driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		By fullName = By.id("Form_getForm_Name");
		//driver.findElement(fullName).sendKeys("testing");
		
		//e1
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement fullName_ele = wait.until(ExpectedConditions.presenceOfElementLocated(fullName));
		WebElement fullName_ele =waitForElementPresence(fullName, 10);
		fullName_ele.sendKeys("testing");
		
		//e2
		By businessEmail = By.id("Form_getForm_Email");
		//driver.findElement(businessEmail).sendKeys("test@gmail.com");
		waitForElementPresence(businessEmail, 5).sendKeys("NAveen");
		waitForElementVisible(businessEmail, 5).sendKeys("Leena");
	}
	
/**
 * An expectation for checking that an element is present on the DOM of a page. 
 * This does not necessarily mean that the element is visible.
 * @param locator
 * @param timeOut
 * @return
 */
	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * 

	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible. 
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
