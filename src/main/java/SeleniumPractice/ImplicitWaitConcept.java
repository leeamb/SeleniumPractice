package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitConcept {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);-- selenium 3.x
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		///implicite wait is global 
		
		driver.get("https://automationexercise.com/login");
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("test123");
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("test768@jkl.com");
		driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).click();
		try {
		WebElement emailExistMesg = driver.findElement(By.xpath("//form[@action='/signup']/p[contains(text(),'Email Address already exist!')]"));
	
		if (emailExistMesg.isDisplayed()) {
			System.out.println("email Already exist.");
		}
	
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
			driver.findElement(By.id("id_gender1")).click();
		
	}
	
	//Disadvantage of Implicit wait:
	//1. It applies through out the framework so if we want to change the wait time , we have to override the implicitWait
	//2. it is global , applied to all elements
	//3. It is not applicable to non web elements e.g. alerts, titles, URL, browser window
	// thats why avoid using implicite wait in th eframework.

}
