package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlerts {

static WebDriver driver;
	
	public static void main(String[] args) {
		//alert
		//prompt
		//confirm
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Alert
		//driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		//acceptAlert(5);
		
		//Alert alert = driver.switchTo().alert();
		
		//prompt
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		System.out.println(getAlertText(5));
//		//acceptAlert(5);
//		dismissAlert(5);
		
		//confirm
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		System.out.println(getAlertText(5));
		AlertSendkeys(5, "qwer");
		//acceptAlert(5);
		dismissAlert(5);
		System.out.println(driver.findElement(By.id("result")).getText());
		
		
	}
	
	
	public static Alert waitForJSAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String getAlertText(int timeout) {
		return waitForJSAlert(timeout).getText();
	}
	
	public static void acceptAlert(int timeout) {
		waitForJSAlert(timeout).accept();
	}
	
	public static void dismissAlert(int timeout) {
		waitForJSAlert(timeout).dismiss();
	}
	
	public static void AlertSendkeys(int timeout, String value) {
		waitForJSAlert(timeout).sendKeys(value);
	}

}
