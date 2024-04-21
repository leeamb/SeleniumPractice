package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeConcept {
	static WebDriver driver; 
	public static void main(String[] args) {
		
		//text-- getText()
		//attribute -- getAttribute()
		
		//get all links and capture href value
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		/*
		 * String fn_placeholder =
		 * driver.findElement(By.id("input-firstname")).getAttribute("placeholder");
		 * String fn_type =
		 * driver.findElement(By.id("input-firstname")).getAttribute("type"); String
		 * fn_name = driver.findElement(By.id("input-firstname")).getAttribute("name");
		 */
		/*
		 * System.out.println(fn_placeholder); System.out.println(fn_type);
		 * System.out.println(fn_name);
		 */
		
		By firstName = By.id("input-firstname");
		By registerLink = By.linkText("Register");
		
		String register_href = doElementGetAttribute(registerLink,"href");
		System.out.println(register_href);
		
		String fn_type = doElementGetAttribute(firstName, "type");
		System.out.println(fn_type);
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String doElementGetAttribute(By locator, String attName) {
		 return getElement(locator).getAttribute(attName);
	}

}
