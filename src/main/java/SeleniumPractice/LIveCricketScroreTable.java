package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LIveCricketScroreTable {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/england-in-india-2023-24-1389386/india-vs-england-4th-test-1389402/full-scorecard");
		
		
	}

}
