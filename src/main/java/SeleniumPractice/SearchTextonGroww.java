package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * 
 */
public class SearchTextonGroww {
	
	static WebDriver driver;
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException  {
		String websiteName = "https://www.yahoo.com";
		String searchAttr = "p";
		By searchField = By.name(searchAttr);
		By suggessions = By.xpath("//ul[@class='_yb_evmrmt']//span[@class='_yb_vpy4ue']");
		
		driver = new ChromeDriver();
		driver.get(websiteName);
		
		doSearch(searchField,"ICICI",suggessions,"Equity");
	}
	/**
	 * 
	 * @param searchField
	 * @param searchKey
	 * @param searchSeuggession
	 * @param value
	 * @throws InterruptedException
	 */
	public static void doSearch(By searchField,String searchKey, By searchSeuggession, String value ) throws InterruptedException {
		driver.findElement(searchField).sendKeys(searchKey);
		Thread.sleep(3000);
		List<WebElement> suggessions = driver.findElements(searchSeuggession);
		System.out.println(suggessions.size());
		for(WebElement e : suggessions) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains(value)) {
				e.click();
				break;
			}
		}
	}

}
