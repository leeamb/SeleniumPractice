package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleUrl {

	static WebDriver driver;
	
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		
		String titleFraction = waitForTitleContains("Free CRM software for customer relationship", 10);
		String title = waitForTitleIs("Free CRM software for customer relationship management, sales, and support.", 10);
		
		System.out.println(titleFraction);
		System.out.println(title);
		
		driver.findElement(By.linkText("Sign Up")).click();
		System.out.println(waitForUrlContains("/register/", 5));

	}
	
	/**
	 * 
	 * @param titleFraction
	 * @param timeOut
	 * @return
	 */
	public static String waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try{
			if(wait.until(ExpectedConditions.titleContains(titleFraction))) {
				return driver.getTitle();
			}
		}catch (Exception e) {
			System.out.println("title not found within " + timeOut);
		}
		return null;
	}
	
	/**
	 * 
	 * @param titleFraction
	 * @param timeOut
	 * @return
	 */
	public static String waitForTitleIs(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try{
			if(wait.until(ExpectedConditions.titleIs(title))) {
				return driver.getTitle();
			}
		}catch (Exception e) {
			System.out.println("title not found within " + timeOut);
		}
		return null;
	}
	
	/**
	 * 
	 * @param urlFraction
	 * @param timeOut
	 * @return String
	 */
	public static String waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try{
			if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
				return driver.getCurrentUrl();
			}
		}catch (Exception e) {
			System.out.println("URL not found within " + timeOut);
		}
		return null;
	}
	/**
	 * 
	 * @param url
	 * @param timeOut
	 * @return String
	 */
	public static String waitForUrlIs(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try{
			if(wait.until(ExpectedConditions.urlToBe(url))) {
				return driver.getCurrentUrl();
			}
		}catch (Exception e) {
			System.out.println("url not found within " + timeOut);
		}
		return null;
	}

}
