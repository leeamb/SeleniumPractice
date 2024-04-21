package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.instacart.com/");
		List<WebElement> listImages = driver.findElements(By.tagName("img"));
		System.out.println("Toatl number of images: "+ listImages.size());
		
		driver.quit();

	}

}
