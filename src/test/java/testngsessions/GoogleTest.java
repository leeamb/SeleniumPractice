package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
	
	@Test (priority=1)
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google", "Title is not matched");
	}

	@Test (priority=2)
	public void imageTest() {
		boolean flag = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		Assert.assertEquals(flag, true);
		Assert.assertTrue(flag);
	}

	@Test (priority=3)
	public void urlTest() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("google"));
	}

	
}
