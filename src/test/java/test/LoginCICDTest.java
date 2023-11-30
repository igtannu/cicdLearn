package test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom.LoginCICDPOM;
import utils.ExtentTestManager;
import utils.Log;

public class LoginCICDTest extends Base{
	LoginCICDPOM loginPOm=new LoginCICDPOM();
	
   @Test
  public void login(Method method) {
	   ExtentTestManager.startTest(method.getName(), "LOGIN");
	   Log.info(method.getName());
	loginPOm.userId().sendKeys("mngr540414");
	loginPOm.password().sendKeys("eqabUpu");
	loginPOm.login().click();
	Assert.assertTrue(loginPOm.verifyLogin().isDisplayed());
  }
}
  