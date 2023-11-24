package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginCICDPOM {

	public WebElement userId() {
		return PageUtil.findBy(By.name("uid"));
	}
	public WebElement password() {
		return PageUtil.findBy(By.name("password"));
	}
	public WebElement login() {
		return PageUtil.findBy(By.name("btnLogin"));
	}
	public WebElement reset() {
		return PageUtil.findBy(By.name("btnReset"));
	}
	public WebElement verifyLogin() {
		return PageUtil.findBy(By.xpath("//td[contains(text(),'mngr540414')]"));
	}
	
	
}
