package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinkConcept {
	
	public static void main(String[] args) {
		// 1. total links
		// 2. print the text of each link
		// 3. avoid blank text
		// 4. broken link	
		int count = 0;

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Link: " + allLinks.size());

		for (int i = 0; i < allLinks.size(); i++) {
			String text = allLinks.get(i).getText();
			if (text.length() != 0) {
				//System.out.println(text);
				//count ++;
			}
		}
		//foreach element in the list
		for(WebElement e: allLinks) {
			String text = e.getText();
			if (text.length() != 0) {
				//System.out.println(text);
				count ++;
			}
		}
		
		//Total number of textboxes
		List<WebElement> allTextBox = driver.findElements(By.className("form-control"));
		System.out.println("Total number of Text boxes: "+ allTextBox.size());
		
		for(WebElement e: allTextBox) {
			String textBoxName = e.getAttribute("value placeholder");
			System.out.println(textBoxName);
		}
		
		System.out.println("Total visible links are: " + count);
		driver.quit();
	}

}
