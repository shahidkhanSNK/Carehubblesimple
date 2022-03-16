package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecurityCodeScreen extends BaseClass {
	
	private By codeTextBoxesLocator = By.cssSelector("input.prevent-quotes");
	private By continueButtonLocator = By.id("continue");
	private By menuTextLocator = By.cssSelector("span.icon-Dashboard-Unfilled");

	
	
	public SecurityCodeScreen(WebDriver browserDriver) {
		super(browserDriver);
		// wait for page to load
		wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
	}
	
	public List<WebElement> getSecurityCodeTextBoxes(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("code_one")));
		List<WebElement> codeTextBoxes = browser.findElements(codeTextBoxesLocator);
		return codeTextBoxes;
	}
//	
//	public void setCodeOne(String codeOne) {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("code_one")));
//		WebElement codeoneTextbox = browser.findElement(By.name("code_one"));
//		//WebElement codeoneTextbox = browser.findElement(By.cssSelector("input.prevent-quotes"));
//		codeoneTextbox.sendKeys(codeOne);
//	}
//	
//	public void setCodeTwo(String codetwo) {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("code_two")));
//		WebElement codetwoTextbox = browser.findElement(By.name("code_two"));
//		codetwoTextbox.sendKeys(codetwo);
//	}
//	
//	public void setCodeThree(String codethree) {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("code_three")));
//		WebElement codethreeTextbox = browser.findElement(By.name("code_three"));
//		codethreeTextbox.sendKeys(codethree);
//	}
//	
//	public void setCodeFour(String codefour) {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("code_four")));
//		WebElement codefourTextbox = browser.findElement(By.name("code_four"));
//		codefourTextbox.sendKeys(codefour);
//	}
//	
	public void clickContinueButton() {
		wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
		WebElement continueButton = browser.findElement(continueButtonLocator);
		continueButton.click();
	}
	
	public String getDashboardPageTitle() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuTextLocator));
		String dashboardTitle = browser.getTitle();
		System.out.println(dashboardTitle);
		return dashboardTitle;
	}


}
