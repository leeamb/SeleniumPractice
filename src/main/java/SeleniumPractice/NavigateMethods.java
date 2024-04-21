package SeleniumPractice;



import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Get vs Navigate to(String) == both are same. synonym to each other. both load a new webpage in current browser window . 
// it is doen by HTTP post request

public class NavigateMethods {

	public static void main(String[] args) throws MalformedURLException {
		
		WebDriver driver = new ChromeDriver(); 
		
		/*
		 * driver.get("https://naveenautomationlabs.com/opencart/");
		 * System.out.println(driver.getTitle());
		 * 
		 * driver.navigate().to("https://www.google.com/");
		 * System.out.println(driver.getTitle());
		 * 
		 * driver.navigate().back(); System.out.println(driver.getTitle());
		 * 
		 * driver.navigate().forward(); System.out.println(driver.getTitle());
		 */

		//driver.navigate().to(new URL("https://naveenautomationlabs.com/opencart/"));//-- rarely used. 
		
	}

}
