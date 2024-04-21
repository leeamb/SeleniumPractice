package SeleniumPractice;

import org.openqa.selenium.WebDriver;

public class OpenCartLoginTest {

	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		
		WebDriver driver = brUtil.launchBrowser("Chrome");
	}

}
