package browser;


import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserHandle  {

	public static final String BrowserStackUSername="tanugupta_NtS6mv";
			public static final String BrowserStackPassword="UCC6sofoi1CnekWq14YX";
			public static final String BrowserStackURL="https://"+BrowserStackUSername+":"
			+BrowserStackPassword+"@hub-cloud.browserstack.com/wd/hub";
					
	
	static final WebDriver driver = null;
	 static WebDriverWait wait = null;
	 static final  ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static WebDriver settingBrowser(String browser) throws Exception {
		// Setup Seleneium Grid......
//		 DesiredCapabilities dc = new DesiredCapabilities();	
//		 dc.setBrowserName(browser);
//		dc.setPlatform(Platform.WIN11);
//		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"),dc);
//		tlDriver.set(driver);
		// end Selenium Grid setup 
		
		
		
		// Setup BrowserStack
		
		 DesiredCapabilities dc = new DesiredCapabilities();	
		 dc.setBrowserName(browser);
			dc.setPlatform(Platform.WIN11);
			dc.setVersion("102");

		WebDriver driver = new RemoteWebDriver(new URL(BrowserStackURL),dc);
		tlDriver.set(driver);

		//Run two commnd on cmd.....
		// for hub -- java -jar selenium-server-4.15.0.jar hub
		//java -jar selenium-server-4.15.0.jar node
		

//		if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			HashMap<String, Object> chromePrefs = new HashMap<>();
//			chromePrefs.put("profile.default_content_settings.popups", 0);
//			chromePrefs.put("download.default_directory", "" + System.getProperty("user.dir") + "\\Downloads");
//			ChromeOptions options = new ChromeOptions();
//			options.setExperimentalOption("prefs", chromePrefs);
//			options.addArguments("--remote-allow-origins=*");
//			WebDriver driver = new ChromeDriver(options);
//			tlDriver.set(driver);
//
//		} 
//		else if (browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			tlDriver.set(new FirefoxDriver());
//		} 
//		else if (browser.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			tlDriver.set(new EdgeDriver());
//		} 
//		else {
//			throw new Exception("Nos such browser");
//			 
//		}
//		 wait = new WebDriverWait(getDriver(),Duration.ofSeconds(60));
//
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
//		
		return getDriver();
		
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	
	
}
