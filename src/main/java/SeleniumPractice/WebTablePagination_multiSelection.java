package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePagination_multiSelection {
	
		static WebDriver driver;
		static String url = "https://classic.freecrm.com/index.html";
		static String contactName = "Virat Kohli";
		
		public static void main(String[] args) throws InterruptedException {
			
			driver = new ChromeDriver();
			driver.get(url);
			Thread.sleep(5000);

			login("apiautomation", "Selenium@12345");
			//Switch to frame
			driver.switchTo().frame("mainpanel");
			System.out.println("Switch to main frame");
			driver.findElement(By.linkText("CONTACTS")).click();
			System.out.println("Clicked on Contacts");
			Thread.sleep(5000);
			
			int pageNums = driver
					.findElements(By
							.xpath("(//div[@class='pagination'])[2]/a"))
					.size();
			
			//multiple selections
			for (int i = 2; i <= pageNums + 1; i++) {
				if (clickCheckbox(contactName) > 0) {
					Thread.sleep(2000);
					break;
				} else {
					try {
						driver.findElement(By.xpath(
								"(//div[@class='pagination'])[2]/a["
										+ i + "]"))
								.click();
						System.out.println("Searching on next page :" + i);
						Thread.sleep(5000);
						if (clickCheckbox(contactName) > 0) {
							Thread.sleep(2000);
							break;
						}
					} catch (Exception e) {
						System.out.println("Next page element not found...");
						e.printStackTrace();
					}
				}
			}
	}

		
		/**
		 * 
		 * @param uName
		 * @param pwd
		 * @throws InterruptedException
		 */
		public static void login(String uName, String pwd) throws InterruptedException {
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uName);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			System.out.println("Clicked on login button");
			Thread.sleep(5000);
		}

		
		/**
		 * 
		 * @param compName
		 * @return
		 */
		public static int clickCheckbox(String contactName) {
			int nameOccurance = driver
					.findElements(By.xpath("//form[@id='vContactsForm']//a[text()='" + contactName + "']")).size();
			if (nameOccurance > 0) {
				for(int i=1; i<=nameOccurance; i++) {
				driver.findElement(By.xpath("(//form[@id='vContactsForm']//a[text()='" + contactName
						+ "']/../preceding-sibling::td/input[@type='checkbox'])["+i+"]")).click();
				System.out.println("Checkbox clicked for " + contactName);
				}
			} else {
				System.out.println("Contact name not found on this page..");
			}
			return nameOccurance;
		}

}
