package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BaseClass{
	
	public Header(WebDriver browserDriver) {
		super(browserDriver);
		// wait for page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.icon-Upsmall")));
	}
	
	public void headerDropdownArrow() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.icon-Upsmall")));
		WebElement dropdownarrow = browser.findElement(By.cssSelector("span.icon-Upsmall"));
		dropdownarrow.click();
}

}
