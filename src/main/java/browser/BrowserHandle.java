package browser;


import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandle  {
	static final WebDriver driver = null;
	 static WebDriverWait wait = null;
	 static final  ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static WebDriver settingBrowser(String browser) throws Exception {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			HashMap<String, Object> chromePrefs = new HashMap<>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", "" + System.getProperty("user.dir") + "\\Downloads");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(options);
			tlDriver.set(driver);

		} 
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} 
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		} 
		else {
			throw new Exception("Nos such browser");
			 
		}
		 wait = new WebDriverWait(getDriver(),Duration.ofSeconds(60));

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
		
		return getDriver();
		
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	
	
}
