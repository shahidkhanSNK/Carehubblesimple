package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseClass {
	
	private By emailAddressLocator = By.name("email");
	private By passwordLocator = By.name("password");
	private By signInButtonLocator = By.tagName("button");
	private By errorMessageLocator = By.cssSelector("div.notif-msg.d-flex");
	private By validationMessageLocator = By.cssSelector("span.error.error-feedback");
	private By continueButtonLocator = By.id("continue");
	
	
	public LoginPage(WebDriver browserDriver) {
		super(browserDriver);
		// wait for page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressLocator));
	}
	
	public void setEmailAddress(String emailAddress) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressLocator));
		WebElement emailTextbox = browser.findElement(emailAddressLocator);
		emailTextbox.clear();
		emailTextbox.sendKeys(emailAddress);
	}
	
	public void setPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
		WebElement passwordTextbox = browser.findElement(passwordLocator);
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
	}
	
	public void clickSignInButton() {
		wait.until(ExpectedConditions.elementToBeClickable(signInButtonLocator));
		WebElement signInButton = browser.findElement(signInButtonLocator);
		signInButton.click();
	}
	
	public String getErrorMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
		String errorMessage = browser.findElement(errorMessageLocator).getText();
		System.out.println(errorMessage);
		return errorMessage;
	}
	
	public String getValidationMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(validationMessageLocator));
		String validationMessage = browser.findElement(validationMessageLocator).getText();
		System.out.println(validationMessage);
		return validationMessage;
	}
	
	public String getPageText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueButtonLocator));
		String pageTitle = browser.getTitle();
		System.out.println(pageTitle);
		return pageTitle;
	}

}
