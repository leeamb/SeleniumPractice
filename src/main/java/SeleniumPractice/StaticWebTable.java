package SeleniumPractice;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//find total number of cloumns in the table
		List<WebElement> columns= driver.findElements(By.xpath("//table[@id='customers']//th"));
		int colCount = columns.size();
		System.out.println("total number of colCount: " + colCount);
		

	}

}
