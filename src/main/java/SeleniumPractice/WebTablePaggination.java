package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePaggination {
	static WebDriver driver;
	static String countryName;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);

		countryName = "India";

		// single row selection
		while (true) {
			if (driver.findElements(By.xpath("//td[text()='" + countryName + "']")).size() > 0) {
				selectCountry(countryName);
				break;
			} else {
				WebElement next= driver.findElement(By.linkText("Next"));
				if(next.getAttribute("class").contains("disabled")) {
					System.out.println("pagination is over.. country name is not found..");
					break;
				}
				next.click();
				System.out.println("Clicking on next button");
				Thread.sleep(2000);
			}
		}
		
		//multiselection
		while(true) {
			if (driver.findElements(By.xpath("//td[text()='" + countryName + "']")).size() > 0) {
				selectCountryMultiEntries(countryName);
			} 
				WebElement next= driver.findElement(By.linkText("Next"));
				if(next.getAttribute("class").contains("disabled")) {
					System.out.println("pagination is over.. country name is not found..");
					break;
				}
				next.click();
				System.out.println("Clicking on next button");
				Thread.sleep(2000);
		}
	}
	
	
	/*
	 * 
	 */
	
	public static void selectCountry(String country) throws InterruptedException {
		driver.findElement(
				By.xpath("//td[text()='" + country + "']/preceding-sibling::td/input[@type='checkbox']"))
				.click();
		System.out.println("Clicked on the checkbox for "+country);
		Thread.sleep(2000);
	}
	
	
	public static void selectCountryMultiEntries(String country) {
		List<WebElement> checkboxes =driver.findElements(
				By.xpath("//td[text()='" + country + "']/preceding-sibling::td/input[@type='checkbox']"));
		for(WebElement e : checkboxes) {
			e.click();
		}
	}

}
