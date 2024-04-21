package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PollingTimeConcept {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//parent
		
		By twitter= By.xpath("//a[contains(@href, 'twitter')]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(2000));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(twitter)).click();

	}

}
