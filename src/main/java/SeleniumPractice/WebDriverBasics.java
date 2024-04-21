package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		//open browser : Chrome
		//enter the URL
		//Get the title
		//verify the title - actual VS Expected
		
		WebDriver driver = new ChromeDriver(); // open browser
		
		// driver.get("www.google.com"); // will open the browser but not the url. it will throw InvalidArgument exception
		driver.get("https://www.google.com"); // open URL
		
		String title = driver.getTitle();  // get title
		System.out.println("Page title is : "+ title);
		
		//checkpoint / verification point / Actual vs Expected
		if(title.equals("Google")) {
			System.out.println("correct title -- PASS");
		} else {
			System.out.println("Incorrect title -- FAIL");
		}

		//check URL
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		if(url.contains("google.com")) {
			System.out.println("correct url -- PASS");
		} else {
			System.out.println("Incorrect url -- FAIL");
		}
			
		//close the browser
		driver.close();
		System.out.println("Browser closed");
		
	}

}
