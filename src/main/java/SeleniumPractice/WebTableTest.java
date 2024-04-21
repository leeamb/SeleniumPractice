package SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTest {

	static WebDriver driver;
	static String contactName = "Jow smith";

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		driver.findElement(By.name("username")).sendKeys("apiautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(4000);
		// NoSuchElementException
		// driver.findElement(By.linkText("CONTACTS")).click();

		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		selectContact(contactName);
//		getCompName(contactName);
//		getPhoneNum(contactName);
//		getEmail(contactName);
		getContactsInfoList(contactName);
	}

	public static void selectContact(String contactName) {
		String xPath = "//a[text()='"+contactName+"']/parent::td/preceding-sibling::td/input[@name='contact_id']";
		driver.findElement(By.xpath(xPath)).click();

	}

	public static String getCompName(String contactName) {
		String xPath = "//a[text()='"+contactName+"']/parent::td/following-sibling::td/a[@context='company']";
		return (driver.findElement(By.xpath(xPath)).getText());
	}

	public static void getPhoneNum(String contactName) {
		String xPath = "//a[text()='"+contactName+"']/parent::td/following-sibling::td/child::span[@context='phone']";
		driver.findElement(By.xpath(xPath)).click();
		List<WebElement> phoneNumbers=driver.findElements(By.xpath(xPath));
		ArrayList<String> phoneBook = new ArrayList<String>();
		for(WebElement e:phoneNumbers) {
			phoneBook.add(e.getText());
		}
		System.out.println(phoneBook);
	}
	
	public static String getEmail(String contactName) {
		String xPath = "//a[text()='"+contactName+"']/parent::td/following-sibling::td/child::a[contains(@href,'mailto:')]";
		return (driver.findElement(By.xpath(xPath)).getText());
	}

	public static void getContactsInfoList(String contactName) {
		System.out.println(contactName + "'s Company Name is : " + getCompName(contactName));
		System.out.println("Phone numbers are: ");
		getPhoneNum(contactName);
		
		System.out.println(contactName + "'s Email is : " + getEmail(contactName));
		
	
	}
}
