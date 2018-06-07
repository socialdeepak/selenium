package com.automationtest.E2EProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.ResultPage;
import testBase.Base;

public class TC01VerifyLoginWithInvalidCredentials extends Base
{
	LandingPage landpage;
	LoginPage LogPage;
	ResultPage rp;
  @Test
  public void LoginWithInvalidCredential() throws InterruptedException 
  {
	  log.info("==================Starting TC01_VerifyLoginWithInvalidCredentials Test================");
	  
	  LandingPage landpage=new LandingPage(driver);	  
	  landpage.signInToPage();
	  
	  LogPage=new LoginPage(driver);
	  LogPage.LoginToApp("abc@gmail.com","password");
	  
	  rp=new ResultPage(driver);
	  Assert.assertEquals(rp.getInvalidLoginTest(),"Authentication failed.");
	  
	  log.info("==================Ending TC01_VerifyLoginWithInvalidCredentials Test================");
  }
  @BeforeTest
  public void Setup() throws IOException 
  {
	  init();
	
  }

  @AfterTest
  public void teardown() 
  {
	  
  }

}
