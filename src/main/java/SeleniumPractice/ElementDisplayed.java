package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementDisplayed {

static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://practicetestautomation.com/");
		
		By locator = By.className("custom-logo11");
		
		// if classname is wrong or element is not present then 
		//boolean flag = driver.findElement(locator).isDisplayed(); // it will throw NOSuchElementException. 
		
		boolean flag = isElementDisplayed(locator);
		if (flag) {
			System.out.println("Logo is displayed");
		}else {
			System.out.println("Logo is NOT displayed");
		}

	}
	
	public static WebElement getElement(By locator) {
		WebElement element = null;
		try {
		element = driver.findElement(locator);
		}catch(NoSuchElementException e) {
			System.out.println("NO Such element is present on the page");
			e.printStackTrace();
		}
		return element;
	}
	
	public static boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

}
