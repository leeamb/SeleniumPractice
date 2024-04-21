package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchSuggestions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		By searchField = By.name("q");
		By Suggessions = By.xpath("//ul[@class='G43f7e' and @role='listbox']//div[@class='wM6W7d']/span");
		doSearch(searchField,Suggessions,"pizza","Indian");
	}

	public static void doSearch(By locator,By searchSuggession,String SearchKey, String value) throws InterruptedException {
		driver.findElement(locator).sendKeys(SearchKey);

		Thread.sleep(3000);

		List<WebElement> suggessions = driver.findElements(searchSuggession);
		System.out.println(suggessions.size());

		for (WebElement e : suggessions) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(value)) {
				e.click();
				break;
			}

		}
	}
	
}
