package com.practiceProj.MyseleniumMaven;

import org.testng.annotations.Test;

import com.practiceProj.MyseleniumMaven.TestBase.TestBase;
import com.practiceProj.MyseleniumMaven.UIActions.HomePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class TC003_VerifyLoginWithDifferentRecords extends TestBase
{
	public static final Logger log = Logger.getLogger(TC003_VerifyLoginWithDifferentRecords.class.getName());	
	HomePage homepage;

	@DataProvider(name="loginData")
	public String[][] getTestData()
	{
		String[][] testRecords = getData("LoginTestData","TestData.xlsx");
		return testRecords;
	}
	
	
	@BeforeClass
	public void setUp() throws IOException 
	{		
		init();
	}
	
	
	@Test(dataProvider="loginData")
	public void loginToApplication(String emailAddress, String password,String runMode) 
	{
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		
		log.info("============= Strting VerifyLoginWithDifferentRecords Test===========");
		homepage = new HomePage(driver);
		homepage.loginToApplication(emailAddress, password);
		Assert.assertEquals(homepage.getInvalidLoginTest(), "Authentication failed.");
		//getScreenShot("loginToApplication_"+ emailAddress);
		log.info("============= Finished VerifyLoginWithDifferentRecords Test===========");
	}
	
	
	@AfterClass
	public void endTest()
	{
		closeBrowser();
	}

}
