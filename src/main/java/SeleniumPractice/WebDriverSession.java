package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSession {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); //SI -123
		driver.get("https://www.google.com/");//SI-123
		String getTitle = driver.getTitle();//SI-123
		System.out.println(getTitle);
		
		//driver.close();// close browser -- server is active in the background. so same sessionID will be there
		//System.out.println(driver.getTitle());// gives NoSuchSessionException becasuse browser is closed. session ID is still the same.

		//driver.quit();// quits Driver. session ID = null
		//System.out.println(driver.getTitle()); // gives NoSuchSessionException session ID is NULL. 
	
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		driver.close();
		//driver.quit();
	
	}

}
