package testngsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	WebDriver driver;
	@Parameters({"url", "browser", "headless"})
	@BeforeTest // run once
	public void setup(String url, String browserName) {
		switch(browserName.toLowerCase().trim()) {
		case "chrome":
			ChromeOptions co = new ChromeOptions();
			if(Boolean.parseBoolean("headless")) {
				co.addArguments("--headless");
			}
			driver = new ChromeDriver(co);
			break;
		case "firefox":
			FirefoxOptions fo = new FirefoxOptions();
			if(Boolean.parseBoolean("headless")) {
				fo.addArguments("--headless");
			}
			driver = new FirefoxDriver(fo);
			break;
		case "safari":
			SafariOptions so = new SafariOptions();
			if(Boolean.parseBoolean("headless")) {
			//	so.addArguments("--headless");
			}
			driver = new SafariDriver(so);
			break;
		default:
			System.out.println("Please pass right browser..."+ browserName);
			break;
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterTest // run once
	public void teardown() {
		driver.quit();
	}

}
