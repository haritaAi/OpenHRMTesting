package pageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class orangeLoginPage {
WebDriver driver;


@FindBy(xpath = "//input[@name='username']")
WebElement loginUserName;

@FindBy(xpath = "//input[@name='password']")
WebElement loginPassword;

@FindBy(xpath = "//button[@type='submit']")
WebElement  loginButton;



By title = By.cssSelector("//button[@type='submit']");


public orangeLoginPage(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver,this);

}

public WebElement loginUser() {
	
	
 
	return loginUserName;
}

public WebElement loginpasswordElement() {

  return loginPassword;
}

public WebElement loginButtonElement() {
	
	return loginButton;
	
	
}

}



