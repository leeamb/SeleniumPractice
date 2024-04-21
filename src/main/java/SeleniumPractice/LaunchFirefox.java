package SeleniumPractice;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LaunchFirefox {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");

		String title = driver.getTitle(); // get title
		System.out.println("Page title is : " + title);

		// checkpoint / verification point / Actual vs Expected
		if (title.equals("Your Store")) {
			System.out.println("correct title -- PASS");
		} else {
			System.out.println("Incorrect title -- FAIL");
		}

		// check URL
		String url = driver.getCurrentUrl();
		System.out.println(url);

		if (url.contains("naveenautomationlabs.com")) {
			System.out.println("correct url -- PASS");
		} else {
			System.out.println("Incorrect url -- FAIL");
		}

		// close the browser
		driver.close();
		System.out.println("Browser closed");
	}

}
