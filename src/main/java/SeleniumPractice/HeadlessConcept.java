package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessConcept {

	public static void main(String[] args) {
		//headless - no browser visibility or browser is running in the background.
		
		//Advantages:
		//- faster, 
		// eun testcase on CI CD/ Jenkins/Linux: headless
		// recommended: not recommended
		//local: 
		//Problems: Its not an actual user simulation
		//complex apps/HTML DOM:
		//alerts and popups could be a problem
		
		ChromeOptions co = new ChromeOptions();
		//co.addArguments("--incognito");
		co.addArguments("--headless"); 
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://amazon.com");
		System.out.println(driver.getTitle());
		driver.quit();		
		
		
	}

}
