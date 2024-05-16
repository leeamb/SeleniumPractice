package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */
public class WebTablePaginationNum {
	static WebDriver driver;
	static String url = "https://classic.freecrm.com/index.html";
	static String compName = "Zoom";

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();

		driver.get(url);
		Thread.sleep(5000);

		login("apiautomation", "Selenium@12345");

		driver.switchTo().frame("mainpanel");
		System.out.println("Switch to main frame");
		driver.findElement(By.linkText("COMPANIES")).click();
		System.out.println("Clicked on Companies");
		Thread.sleep(5000);

		int pageNums = driver
				.findElements(By
						.xpath("//form[@id='vCompaniesForm']/table/tbody/tr[last()]/td[contains(text(),'Pages : ')]/a"))
				.size();

		// single Selection
		for (int i = 2; i <= pageNums + 1; i++) {
			if (clickCheckbox(compName) > 0) {
				Thread.sleep(2000);
				break;
			} else {
				try {
					driver.findElement(By.xpath(
							"//form[@id='vCompaniesForm']/table/tbody/tr[last()]/td[contains(text(),'Pages : ')]/a[text()='"
									+ i + "']"))
							.click();
					System.out.println("Searching on next page :" + i);
					Thread.sleep(5000);
					if (clickCheckbox(compName) > 0) {
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
	public static int clickCheckbox(String compName) {
		int compOccurance = driver
				.findElements(By.xpath("//form[@id='vCompaniesForm']//a[contains(text(),'" + compName + "')]")).size();
		if (compOccurance > 0) {
			driver.findElement(By.xpath("//form[@id='vCompaniesForm']//a[text()='" + compName
					+ "']/../preceding-sibling::td/input[@type='checkbox']")).click();
			System.out.println("Checkbox clicked for " + compName);
		} else {
			System.out.println("Company name not found on this page..");
		}
		return compOccurance;
	}

}
