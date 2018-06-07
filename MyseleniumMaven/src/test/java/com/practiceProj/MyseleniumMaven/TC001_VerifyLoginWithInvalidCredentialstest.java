package com.practiceProj.MyseleniumMaven;

import org.testng.annotations.Test;

import com.practiceProj.MyseleniumMaven.TestBase.TestBase;
import com.practiceProj.MyseleniumMaven.UIActions.HomePage;

import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TC001_VerifyLoginWithInvalidCredentialstest extends TestBase
{
 public static final Logger log=Logger.getLogger(TC001_VerifyLoginWithInvalidCredentialstest.class.getName());
 HomePage homepage;
  @Test
  public void verifyLoginWithInvalidCredentials()
  {
	  log.info("-----Starting TC001_VerifyLoginWithInvalidCredentials--------");
	  homepage=new HomePage(driver);
	  homepage.loginToApplication("test@gmail.com", "password");
	  Assert.assertEquals(homepage.getInvalidLoginTest(), "Authentication failed.");
	  log.info("-----Ending TC001_VerifyLoginWithInvalidCredentials--------");
	  
  }
  @BeforeTest
  public void startUP() 
  {
	  init();  
  }

  @AfterTest
  public void endTest() 
  {
	 // closeBrowser();  
  }

}
