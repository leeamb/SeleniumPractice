package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMultiLevelMenuHandling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(3000);
		
		By level1Menu = By.xpath("(//span[text()='Shop by'])[2]");
		By levcel2Menu = By.linkText("Beverages");
		By levcel3Menu = By.linkText("Tea");
		By levcel4Menu = By.linkText("Green Tea");
		
		handleMenuSubMenu4(level1Menu, levcel2Menu, levcel3Menu, levcel4Menu);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
		
	}
	
	public static void handleMenuSubMenu4(By level1Menu, By levcel2Menu, By levcel3Menu, By levcel4Menu) throws InterruptedException {
		getElement(level1Menu).click();
		Thread.sleep(1500);
		
		Actions act = new Actions(driver);
		act.moveToElement(getElement(levcel2Menu)).perform();
		Thread.sleep(1500);
		act.moveToElement(getElement(levcel3Menu)).perform();
		Thread.sleep(1500);
		getElement(levcel4Menu).click();;
		
	}
}
