package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest_setProperty {

	public static void main(String[] args) {
		// before Selenium 4.6 version need to set property to start chromedriver server. by using System.setProperty
		
		//4.0.0
		//MAC: Launching the server
		System.setProperty("webdriver.chrome.driver", "/Users/leena/Downloads/chromedriver-mac-x64/chromedriver");
		WebDriver driver = new ChromeDriver();//open browser

	}

}
