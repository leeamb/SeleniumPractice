package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This code shows difference between findElement and findElements for the element which is not available on the page.
 */
public class ElementException {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		//driver.findElement(By.name("search111")).click();	//this line will throw NoSuchElementException	
		
		List<WebElement> elemts = driver.findElements(By.name("search111")); // does not throw exception
		System.out.println(elemts.size());// size will be 0
		System.out.println(elemts); // will return blank arraylist []
	}

}
