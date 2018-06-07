package com.practiceProj.MyseleniumMaven.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.practiceProj.MyseleniumMaven.ExcelReader.ExcelReader;

import org.apache.commons.io.FileUtils;



public class TestBase 
{

	public static final Logger log=Logger.getLogger(TestBase.class.getName());
    public static WebDriver driver;
    public ExcelReader excel;
	String url="http://automationpractice.com/index.php";
	String browser="chrome";
	
	public void init()
	{
	 selectBrowser(browser);
	 getUrl(url);
	 String log4jconfpath="log4j.properties";
	 PropertyConfigurator.configure(log4jconfpath);
	 
	}
	
	public void selectBrowser(String Browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
		 log.info("Creating an object of" +browser);
		 driver=new ChromeDriver();
		 
		}
		if(browser.equalsIgnoreCase("FIREFOX"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\lib\\geckodriver.exe");
			 log.info("Creating an object of" +browser);
			 driver=new FirefoxDriver();
		}
	}
	
	public void getUrl(String Url)
	{
		log.info("Navigating to"+url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	public String[][] getData(String sheetName,String excelName)
	{
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\practiceProj\\MyseleniumMaven\\Data\\"+excelName;
		excel=new ExcelReader(path);
		String[][] data=excel.getDataFromSheet(sheetName, excelName);
		return data;
	}
	public void getScreenshot(String name)
	{
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formator=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
		String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/practiceProj/MyseleniumMaven/ScreenShot_Success";
		File destFile=new File((String)reportDirectory +name+ "_" +formator.format(calendar.getTime())+".png");
		FileUtils.copyFile(srcFile, destFile);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void closeBrowser()
	{
		//driver.quit();
	}

}
