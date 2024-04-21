package SeleniumPractice;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author leena
 * @
 */


public class BrowserUtil {

	WebDriver driver;

	public WebDriver launchBrowser(String browserName) {
		System.out.println("browser name :" + browserName);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("PLease provide valid browser name");
			throw new BrowserException("BROWSER NOT FOUND");
		}

		return driver;
	}

	public void launchURL(String url) {
		if (url == null) {
			throw new BrowserException("URL IS NULL");
		}
		if (url.indexOf("http") == 0) {
			driver.get(url);
		}else {
			throw new BrowserException("HTTP/s IS MISSING IN URL");
		}
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}
}
