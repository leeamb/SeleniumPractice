package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickSendKeys {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(3000);
		
		By email = By.xpath("//input[@id='input-email']");
		By pwd = By.xpath("//input[@id='input-password']");
		By login = By.xpath("//input[@value='Login']");
		
		Actions act = new Actions(driver);
		
//		act.sendKeys(driver.findElement(email), "test@gmail.com").perform();
//		act.sendKeys(driver.findElement(pwd), "test@123").perform();
//		act.click(driver.findElement(login)).perform();
		
		doActionsSendKeys((email), "test@gmail.com");
		doActionsSendKeys((pwd), "test@123");
		doActionsClick(login);
	}
	
	public static WebElement getElement (By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
}
