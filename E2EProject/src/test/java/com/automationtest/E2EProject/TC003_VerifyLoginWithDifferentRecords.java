package com.automationtest.E2EProject;

import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.ResultPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import testBase.Base;

public class TC003_VerifyLoginWithDifferentRecords extends Base
{
	LandingPage landpage;
	LoginPage LogPage;
	ResultPage rp;
	
	@DataProvider(name="loginData")
	  public String[][] getTestData() throws IOException 
	  {
		  String[][] testRecords = getData("LoginTestData","TestData.xlsx");
			return testRecords; 
	  }
	
	@BeforeClass
	 public void beforeClass() throws IOException 
	   {
		 init();  
	   }
	      
  @Test(dataProvider="loginData") 
  public void loginToApplication(String emailAddress, String password,String runMode) 
  {
	  if(runMode.equalsIgnoreCase("n"))
	    {
		 
			throw new SkipException("user marked this record as no run");
		}
	  log.info("==================Starting TC003_VerifyLoginWithDifferentRecords Test================");
	  
	  landpage=new LandingPage(driver);
	  landpage.signInToPage();
	  
	  LogPage=new LoginPage(driver);
	  LogPage.LoginToApp(emailAddress,password);
	  
	  rp=new ResultPage(driver);
	  Assert.assertEquals(rp.getInvalidLoginTest(),"Authentication failed.");
	  log.info("==================Ending TC003_VerifyLoginWithDifferentRecords Test================");
  }

 
  @AfterClass
  public void afterClass() 
  {
	  
  }

}