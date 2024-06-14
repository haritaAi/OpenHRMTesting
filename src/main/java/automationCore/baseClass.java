package automationCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {

	
	public WebDriver driver;
	public Properties prop;
		

	
	public WebDriver browserInitialization(String browserName) throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new  FileInputStream("C:\\Users\\sesame\\eclipse-workspace\\OrangeHRMTest\\src\\main\\resources\\testdata\\testdata.properties");
		prop.load(fis);
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\sesame\\eclipse-workspace\\OrangeHRMTest\\src\\main\\resources\\Driver\\chromedriver.exe");
				
			 driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("FireFox")) {
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\sesame\\eclipse-workspace\\OrangeHRMTest\\src\\main\\resources\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		
		
		 
		return driver;
	}
	
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\test-output\\"+testCaseName + ".png";
		com.google.common.io.Files.copy(source, new File(destinationFile));
		
		return destinationFile;
	}
	
	
	
}
