package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * This code selects choices from dropdown box.
 * three types of selection
 * - single choice
 * - multiple choices
 * - all choices
 */
public class JqueryDropdown {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");

		By dropDownLocator = By.id("justAnInputBox");
		By choices = By.xpath("//span[@class=\"comboTreeItemTitle\"]");

		// single choice selection
		// selectChoice(dropDownLocator, choices, "choice 3");

		// multiple choices selection
		//selectChoice(dropDownLocator, choices, "choice 3", "choice 5", "choice 2 2", "choice 7");

		// select All choices
		selectChoice(dropDownLocator, choices, "all");
	}
	
/**
 * 
 * @param dropDownLocator
 * @param choices
 * @param value
 * ... varargs - spread parameter(JS) -- array
 * 
 */
	public static void selectChoice(By dropDownLocator, By choices, String... value) {
		driver.findElement(dropDownLocator).click();

		List<WebElement> dropDownList = driver.findElements(choices);
		System.out.println(dropDownList.size());

		for (WebElement e : dropDownList) {
			String text = e.getText();
			System.out.println(text);

			if (value[0].equals("all")) {
				try {
					e.click();
					}catch(ElementNotInteractableException ex){
						break;
					}
			} else {

				for (String val : value) {
					if (text.equals(val)) {
						e.click();
					}
				}
			}
		}
	}

}
