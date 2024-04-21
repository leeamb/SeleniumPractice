package SeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
		element = driver.findElement(locator);
		}catch(NoSuchElementException e) {
			System.out.println("NO Such element is present on the page");
			e.printStackTrace();
		}
		return element;
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doSendKeys(By locator, String value, int timeout) {
		waitForElementVisible(locator, timeout).sendKeys(value);
	}
	
	public  void doSearch(By locator,By searchSuggession,String SearchKey, String value) throws InterruptedException {
		doSendKeys(locator,SearchKey);

		Thread.sleep(3000);

		List<WebElement> suggessions = driver.findElements(searchSuggession);
		System.out.println(suggessions.size());

		for (WebElement e : suggessions) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(value)) {
				e.click();
				break;
			}
		}
	}
	
	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	
	//*************************************** Actions Utils ****************************************
	
	public void handleMenuSubMenuLevel4(By level1Menu, By levcel2Menu, By levcel3Menu, By levcel4Menu) throws InterruptedException {
		getElement(level1Menu).click();
		Thread.sleep(1500);
		
		Actions act = new Actions(driver);
		act.moveToElement(getElement(levcel2Menu)).perform();
		Thread.sleep(1500);
		act.moveToElement(getElement(levcel3Menu)).perform();
		Thread.sleep(1500);
		getElement(levcel4Menu).click();;
	}
	
	public void handleMenuSubMenuLevel2(By level1Menu, By levcel2Menu) throws InterruptedException {
		getElement(level1Menu).click();
		Thread.sleep(1500);
		
		Actions act = new Actions(driver);
		act.moveToElement(getElement(levcel2Menu)).perform();
		Thread.sleep(1500);
		
		getElement(levcel2Menu).click();;
	}
	
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	
	//*************************************** Wait Utils ****************************************
	
	/**
	 * checking an element is visible and enabled such that you can click it.
	 * @param locator
	 * @param timeOut
	 */
	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return WebElement
	 */
		public WebElement waitForElementPresence(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}

		/**
		 * checking that there is at least one element present on a web page.
		 * @param locator
		 * @param timeOut
		 */
		public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}

		/**
		 * An expectation for checking that an element is present on the DOM of a page and visible. 
		 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
		 * @param locator
		 * @param timeOut
		 * @return WebElement
		 */
		public WebElement waitForElementVisible(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		
		/**
		 * Wait will ignore instances of NotFoundException that are encountered (thrown) by default in the 'until' condition, 
		 * and immediately propagate all others. You can add more to the ignore list by calling ignoring(exceptions to add).
		 * @param locator
		 * @param timeOut
		 * @param intervalTime
		 * @return
		 */
		public WebElement waitForElementVisible(By locator, int timeOut, int intervalTime) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		
		/**
		 * checking that all elements present on the web page that match the locator are visible. 
		 * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
		 * @param locator
		 * @param timeOut
		 * @return List<WebElement>
		 */
		public List<WebElement> waitForElementsVisibility(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
		
		
		/**
		 * 
		 * @param titleFraction
		 * @param timeOut
		 * @return String
		 */
		public String waitForTitleContains(String titleFraction, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			try{
				if(wait.until(ExpectedConditions.titleContains(titleFraction))) {
					return driver.getTitle();
				}
			}catch (Exception e) {
				System.out.println("title not found within " + timeOut);
			}
			return null;
		}
		
		/**
		 * 
		 * @param titleFraction
		 * @param timeOut
		 * @return String
		 */
		public String waitForTitleIs(String title, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			try{
				if(wait.until(ExpectedConditions.titleIs(title))) {
					return driver.getTitle();
				}
			}catch (Exception e) {
				System.out.println("title not found within " + timeOut);
			}
			return null;
		}
		
		/**
		 * 
		 * @param timeout
		 * @return Alert
		 */
		public Alert waitForJSAlert(int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.alertIsPresent());
		}
		
		/**
		 * 
		 * @param timeout
		 * @return
		 */
		public String getAlertText(int timeout) {
			return waitForJSAlert(timeout).getText();
		}
		
		/**
		 * accepts JS alerts, prompts and confirm
		 * @param timeout
		 */
		public void acceptAlert(int timeout) {
			waitForJSAlert(timeout).accept();
		}
		
		/**
		 * click on cancel button on JS confirm
		 * @param timeout
		 */
		public void dismissAlert(int timeout) {
			waitForJSAlert(timeout).dismiss();
		}
		
		/**
		 * Send keys to JS prompts
		 * @param timeout
		 * @param value
		 */
		public void AlertSendkeys(int timeout, String value) {
			waitForJSAlert(timeout).sendKeys(value);
		}
		
		/**
		 * 
		 * @param totalNumberOfWindowsToBe
		 * @param timeout
		 * @return True/False
		 */
		public boolean waitForWindow(int totalNumberOfWindowsToBe, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.numberOfWindowsToBe(totalNumberOfWindowsToBe));
		}

}
