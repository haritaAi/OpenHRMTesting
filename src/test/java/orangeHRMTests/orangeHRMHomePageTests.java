package orangeHRMTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationCore.baseClass;
import pageClasses.orangeDashboardPage;
import pageClasses.orangeLoginPage;
import utilities.pageUtility;
import utilities.waitUtility;

public class orangeHRMHomePageTests extends baseClass {

	WebDriver driver;
	orangeLoginPage objOrangeLoginPage;
	orangeDashboardPage objOrangeDashboardPage;
	
	@BeforeClass
	@Parameters({"browser"})
	public void initializebrowser(String browser) throws IOException {
		
	
		driver = browserInitialization(browser);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		objOrangeLoginPage =  new orangeLoginPage(driver);
		objOrangeDashboardPage = new orangeDashboardPage(driver);

		
	}
	
	@Test
	public void OR_01_smokeTest() {
		
		
		String pageTitle = driver.getTitle();
		System.out.println("PageTitle = " + pageTitle);
		if(pageTitle.equals("OrangeHRM"))
          		System.out.println("Smoke test Passed");
		else
			System.out.println("Smoke test failed");
		
		
		System.out.println("This is smokeTest");
	}
	
	
	@Test
	public void OR_02_loginTest() {
	
		waitUtility.waitForanElementVisible(driver, objOrangeLoginPage.loginUser());
		String loginText = prop.getProperty("username");
		WebElement loginUser =   objOrangeLoginPage.loginUser();
		
	
		loginUser.sendKeys(loginText);
		
		loginText = prop.getProperty("password");
		WebElement loginPassword = objOrangeLoginPage.loginpasswordElement();
		loginPassword.sendKeys(loginText);
		
		
		WebElement loginButton = objOrangeLoginPage.loginButtonElement();
		loginButton.click();		
		
		
		
	}
	
	@Test
	public void OR_03_checkBreadcrumb() {
	waitUtility.waitForanElementVisible(driver,objOrangeDashboardPage.getBreadcrumb() );
	WebElement breadCrumb = objOrangeDashboardPage.getBreadcrumb();
	String breadcrumbText =  pageUtility.getElementText(breadCrumb);
	if(breadcrumbText.equals("Dashboard"))
		System.out.println("Dashboard  page ");
	else System.out.println("Wrong page");
	
	}
	
	@Test
	public void OR_04_sideMenuToggle() {
		waitUtility.waitForElementToBeClickable(driver, objOrangeDashboardPage.menuToggleElement());
		WebElement menuToggle = objOrangeDashboardPage.menuToggleElement();
		pageUtility.clickOnElement(menuToggle);
		
		WebElement sideMenu = objOrangeDashboardPage.sideMenuFull();
		String sideMenuClass = sideMenu.getAttribute("class");
		
		if(sideMenuClass.contains("toggled"))
			System.out.println("Menu is collapsed");
		else 
			System.out.println("Menu is expanded");
		
		
		pageUtility.clickOnElement(menuToggle);
		
		sideMenuClass = sideMenu.getAttribute("class");
		
		if(sideMenuClass.contains("toggled"))
			System.out.println("Menu is collapsed");
		else 
			System.out.println("Menu is expanded");
		
	}
	
	@AfterSuite
	public void endTest() {
		driver.quit();
	}
	
	
	
	
}
