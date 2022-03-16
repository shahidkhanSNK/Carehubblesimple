package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	WebDriver browser;
	WebDriverWait wait;
	
	public BaseClass(WebDriver browserDriver) {
		browser = browserDriver;
		
		wait = new WebDriverWait(browser,10);
	}
}
