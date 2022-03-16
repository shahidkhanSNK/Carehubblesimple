package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Header;
import pages.LoginPage;
import pages.MyProfilePage;
import pages.SecurityCodeScreen;

public class Testcases {

	//WebDriver driver = null;
	WebDriver browser;
	WebDriverWait wait;

	@BeforeTest
	public void setuptest() {


		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath);

		// To set the property for Google Chrome drive, without it, it will throw an error
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/DriverChrome/chromedriver.exe");
		browser = new ChromeDriver();
		wait = new WebDriverWait(browser, 10);

		// To maximize the browser window
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		// Go to CareHubble FrontEnd Portal
		browser.get("https://qa.carehubble.com/signin");

	}

	@Test(priority = 0)
	public void loginwithInvalidEmail() throws InterruptedException {

		// log in
		LoginPage loginpageobj = new LoginPage(browser);
		loginpageobj.setEmailAddress("shahid+257@troontechnologies.comm");
		loginpageobj.setPassword("12345Qwe!@");
		loginpageobj.clickSignInButton();
		String loginErrorMessage = loginpageobj.getErrorMessage();
		String expectedError = "Error! The email or password is incorrect";
		Assert.assertEquals(loginErrorMessage, expectedError);
		System.out.println("Error Message Appeared - Test Passed\n");
	}
	
	@Test(priority = 1)
	public void loginwithInvalidPassword() throws InterruptedException {

		// log in
		LoginPage loginpageobj = new LoginPage(browser);
		loginpageobj.setEmailAddress("shahid+257@troontechnologies.com");
		loginpageobj.setPassword("12345Qwe!@@");
		loginpageobj.clickSignInButton();
		String loginErrorMessage = loginpageobj.getErrorMessage();
		String expectedError = "Error! The email or password is incorrect";
		Assert.assertEquals(loginErrorMessage, expectedError);
		System.out.println("Error Message Appeared - Test Passed\n");
	}
	
	@Test(priority = 2)
	public void loginwithEmptyFields() throws InterruptedException {

		// log in
		LoginPage loginpageobj = new LoginPage(browser);
		loginpageobj.setEmailAddress("");
		loginpageobj.setPassword("");
		loginpageobj.clickSignInButton();
		String loginValidationMessage = loginpageobj.getValidationMessage();
		String expectedMessage = "Email is a required field";
		Assert.assertEquals(loginValidationMessage, expectedMessage);
		System.out.println("Validation Message Appeared - Test Passed\n");
	}

	@Test(priority = 3)
	public void loginwithValidData() throws InterruptedException {

		// log in
		LoginPage loginpageobj = new LoginPage(browser);
		loginpageobj.setEmailAddress("shahid+257@troontechnologies.com");
		loginpageobj.setPassword("12345Qwe!@");
		loginpageobj.clickSignInButton();
		String pageTitleText = loginpageobj.getPageText();
		String expectedText = "Sign In: CareHubble";
		Assert.assertEquals(pageTitleText, expectedText);
		System.out.println("Navigated to Security Code Screen Successfully - Test Passed\n");
	}


	@Test(priority = 4)
	public void securitycode() throws InterruptedException {

		// Enter security code and click continue button
		SecurityCodeScreen sescuritycodepageobj = new SecurityCodeScreen(browser);
		List<WebElement> codetest = sescuritycodepageobj.getSecurityCodeTextBoxes();
		codetest.get(0).sendKeys("0");
		codetest.get(1).sendKeys("0");
		codetest.get(2).sendKeys("0");
		codetest.get(3).sendKeys("0");
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
		//sescuritycodepageobj.setCodeOne("0");
		//sescuritycodepageobj.setCodeTwo("0");
		//sescuritycodepageobj.setCodeThree("0");
		//sescuritycodepageobj.setCodeFour("0");
		sescuritycodepageobj.clickContinueButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.icon-Dashboard-Unfilled")));
//		if (browser.findElement(By.cssSelector("span.icon-Dashboard-Unfilled")).isDisplayed()) {
//			System.out.println("Customer login is Successful - Test Passed\n");
//			}
//			else {
//			System.out.println("Customer login is Unsuccessful - Test Failed\n");
//			}
		String loginDashboardPageTitleText = sescuritycodepageobj.getDashboardPageTitle();
		String expectedText = "Dashboard: CareHubble";
		Assert.assertEquals(loginDashboardPageTitleText, expectedText);
		System.out.println("Customer login is Successful - Test Passed\n");
	}
	
	@Test(priority = 5)
	public void headerDropdown() throws InterruptedException {
		Header headerclassobj = new Header(browser);
		headerclassobj.headerDropdownArrow();
		
	}
	
	@Test(priority = 6)
	public void profilemenuoption() throws InterruptedException {
		MyProfilePage myprofilepageobj = new MyProfilePage(browser);
		myprofilepageobj.headerDropdownMyProfileOption();
		Thread.sleep(6000);
		
	}
	

	@AfterTest
	public void teardowntest() {
		browser.close();
		browser.quit();

	}


}
