package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionMoveToElement {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
//		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");

//		WebElement content = driver.findElement(By.className("menulink"));
//		Actions act = new Actions(driver);
//		act.moveToElement(content).perform();
//		Thread.sleep(1500);
//		
//		//build - sersies of actions
//		
//		driver.findElement(By.linkText("COURSES")).click();

		By parent = By.className("menulink");
		By sunMenu = By.linkText("COURSES");

		// BigBasket app
		driver.get("https://www.bigbasket.com/");

		handleMenuSubMenu(parent, sunMenu);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void handleMenuSubMenu(By parentMenuLocator, By SubMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).perform();
		Thread.sleep(1500);
		getElement(SubMenuLocator).click();
	}
}
