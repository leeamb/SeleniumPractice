package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		//WebElement country = driver.findElement(By.id("Form_getForm_Country"));
		
		By country = By.id("Form_getForm_Country");
		//Select select = new Select(country);
		
//		select.selectByIndex(5);
//		select.selectByValue("Bahamas");
//		select.selectByVisibleText("China");
		//List<WebElement> options = select.getOptions();
		
		doSelectByIndex(country, 6);
		doSelectByValue(country, "Cuba");
		doSelectByVisibleText(country, null);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public static void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		blankOrNullValueCheck(value);
		select.selectByValue(value);
	}
	
	public static void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		blankOrNullValueCheck(value);
		select.selectByValue(value);
	}
	
	public static void blankOrNullValueCheck(String value) {
		if(value ==null || value.length()== 0) {
			throw new MyElementException(value + "Value can not be Null or blank.");
		}
	}

}
