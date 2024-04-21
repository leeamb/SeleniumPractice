package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectionWindowWithSelectClass {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		
		WebElement dropDownEle = driver.findElement(By.xpath("//Select[@multiple]"));
		
		Select select = new Select(dropDownEle);
		
		if(select.isMultiple()) {
			select.selectByVisibleText("American flamingo");
			select.selectByVisibleText("Greater flamingo");
			select.selectByVisibleText("James's flamingo");
			select.selectByVisibleText("Lesser flamingo");
		}
		
		select.deselectByVisibleText("Lesser flamingo");
		select.deselectAll();
		}
	

}
