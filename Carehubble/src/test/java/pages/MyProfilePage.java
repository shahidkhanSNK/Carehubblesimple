package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyProfilePage extends BaseClass{
	
	private By profilelinkoptionLocator = By.cssSelector("a.dropdown-item");
	
	public MyProfilePage(WebDriver browserDriver) {
		super(browserDriver);
		// wait for page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(profilelinkoptionLocator));
	}
	
	public void headerDropdownMyProfileOption() {
		wait.until(ExpectedConditions.elementToBeClickable(profilelinkoptionLocator));
		WebElement profilelinkoption = browser.findElement(profilelinkoptionLocator);
		profilelinkoption.click();
}

}
