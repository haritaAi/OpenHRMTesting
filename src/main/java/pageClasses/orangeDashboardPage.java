package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orangeDashboardPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class = 'oxd-topbar-header']//h6")
	WebElement breadcrumb;
	
	@FindBy(xpath = "//div[@class='oxd-layout-navigation']//aside[contains(@class,'oxd-sidepanel')]")
	WebElement sidemenu;
	
	@FindBy(xpath = "//button[@class='oxd-icon-button oxd-main-menu-button']")
	WebElement menuToggleButton;
	
	public orangeDashboardPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		}
	
	public WebElement  getBreadcrumb() {
		
		return breadcrumb;
	}
	
	public WebElement sideMenuFull() {
		
		return sidemenu;
	}
	
	public WebElement menuToggleElement() {
		return menuToggleButton;
	}
	

}
