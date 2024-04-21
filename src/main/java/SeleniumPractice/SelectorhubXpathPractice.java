package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectorhubXpathPractice {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		selectCheckbox("Joe.Root");
		getInfo("Joe.Root");
	}

	public static void selectCheckbox(String userName) {
		driver.findElement(
				By.xpath("//a[text()='" + userName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}
	
	public static void getInfo(String userName) {
		List<WebElement> userinfo = driver
				.findElements(By.xpath("//a[text()='" + userName + "']/parent::td/following-sibling::td"));

		for (WebElement e : userinfo) {
			String text = e.getText();
			System.out.println(text);
		}
	}

}
