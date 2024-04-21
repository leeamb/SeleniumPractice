package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest{
	
	

	@Test(priority=4)
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "30-Day Advanced Free Trial | OrangeHRM", "Title is not matched");

	}

	@Test(priority=2)
	public void imageTest() {
		boolean flag = driver.findElement(By.xpath("//img[@alt='OrangeHRM Logo']")).isDisplayed();
		Assert.assertEquals(flag, true);
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void urlTest() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("30-day-free-trial"));
	}

	
	
}
