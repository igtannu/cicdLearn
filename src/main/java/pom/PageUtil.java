package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;

import browser.BrowserHandle;

public class PageUtil {

	public static WebElement findBy(By webLocator) {

//		Logs.logger.info("finding Web element " + webLocator);
		WebElement webList = (WebElement) BrowserHandle.getDriver().findElement(webLocator);
		return webList;

	}

	public static List<WebElement> findBys(By webLocator) {	

//		Logs.logger.info("finding Webelements " + webLocator);
		List<WebElement> webList = BrowserHandle.getDriver().findElements(webLocator);
		return webList;


	}
}
