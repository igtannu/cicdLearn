package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import browser.BrowserHandle;
import utils.Log;


public class BaseTest {
	
	static WebDriver driver;
	static File file=new File("./src/test/resources/browser-config.properties");
	static FileInputStream fis = null;
	static Properties prop = new Properties();  

	
static {
		
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			prop.load(fis);       
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



//@Parameters("browserName")
@BeforeClass
public  void initializeWebDriver()
{
	Log.info("intaialise browser");
	BrowserHandle.settingBrowser("chrome");


}

@BeforeMethod
public void openurl() {
	  
	Log.info("******************LAUNCH URL*******************");

	BrowserHandle.getDriver().get(prop.getProperty("url"));
	BrowserHandle.getDriver().manage().window().maximize();

}

@AfterSuite
public void closeBrowser() {
	  Log.info("******************CLOSE BROWSER*******************");
	browser.BrowserHandle.getDriver().quit();

}

public WebDriver getDriver() {
	return BrowserHandle.getDriver();
}

	
}
	
	
	
 

