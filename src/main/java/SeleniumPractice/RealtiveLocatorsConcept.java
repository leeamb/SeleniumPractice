package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RealtiveLocatorsConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		Thread.sleep(20000);
		
		WebElement ele = driver.findElement(By.linkText("Cranbrook, Canada"));
		String leftRank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(leftRank);
		
		String rightRank = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(rightRank);
		
		String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(aboveCity);
		
		String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(belowCity);
		
		String nearElement = driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(nearElement);// within 50 pixel

	}

}
