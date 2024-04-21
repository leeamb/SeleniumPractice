package SeleniumPractice;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

	public static void main(String[] args, URL serverURL, Capabilities capabilities) {
		
		//1. WD d = new CD();
		// Valid -- recommended
		//WebDriver driver = new ChromeDriver();
		
		//2. SC d = new CD();
		// valid -- not recommended
		// SearchContext driver = new ChromeDriver();
		//driver.  --- it does not give get and other methods. only findElement and findElements
		
		//3. RWD d = new CD();
		//valid - recommended
		//RemoteWebDriver driver = new ChromeDriver();
		//driver.get  - -- all methods from WebDriver interface are available .
		// In Selenium 3 class ChromeDriver directly extended RemoteWebDriver class however in Selenium 4 ChromeDriver class extends ChromiumDriver. 
		//thats why even though this topcasting is valid we try to use WbDriver Interface.
		
		//4. ChromiumD d - new CD();
		// valid but not recommended as it will work only with Chrome and Edge not other browsers.
		//ChromiumDriver driver = new ChromeDriver();
		
		//5. WD d = new RWD();
		//valid -- recommended 
		//whenever we have to use selenium grid / remote server/cloud machine
		//WebDriver driver = new RemoteWebDriver(serverURL,capabilities) ;
		
		//6. CD d = new CD();
		//valid but works only for chrome browser.
		
		//7. SC d = new RWD();
		//valid - not recommended 
		//SearchContext driver = new RemoteWebDriver(serverURL,capabilities);
		//driver.  -- it does not give get and other methods. only findElement and findElements
		

	}

}
