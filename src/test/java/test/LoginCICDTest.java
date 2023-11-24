package test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom.LoginCICDPOM;
import utils.ExtentTestManager;

public class LoginCICDTest extends BaseTest{
	LoginCICDPOM loginPOm=new LoginCICDPOM();
	
   @Test
  public void login(Method method) {
	   ExtentTestManager.startTest(method.getName(), "LOGIN");
	loginPOm.userId().sendKeys("mngr540414");
	loginPOm.password().sendKeys("eqabUpu");
	loginPOm.login().click();
	Assert.assertTrue(loginPOm.verifyLogin().isDisplayed());

	
  }
}
  