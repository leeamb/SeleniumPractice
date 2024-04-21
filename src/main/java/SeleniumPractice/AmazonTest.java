package SeleniumPractice;

public class AmazonTest {

	public static void main(String[] args) {
		String browserName = "chrome";
		
		BrowserUtil brUtil = new BrowserUtil();
		brUtil.launchBrowser(browserName);
		
		brUtil.launchURL("www.amazon.com");
		String actTitle = brUtil.getPageTitle();
		
		if(actTitle.contains("amazon")) {
			System.out.println("Title-- PASS");
		}else {
			System.out.println("Title-- PASS");
		}
		
		String actUrl = brUtil.getPageURL();
		
		if(actUrl.contains("amazon")) {
			System.out.println("URL-- PASS");
		}else {
			System.out.println("URL-- PASS");
		}
		brUtil.closeBrowser();
	}

}
