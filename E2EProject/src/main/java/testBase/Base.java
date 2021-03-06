package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import pkgForExcel.ExcelReader;




public class Base 
{
	public static final Logger log=Logger.getLogger(Base.class.getName());
	public static WebDriver driver;
	public ExcelReader excel;
    public Properties pro=new Properties();
    //FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.properties");
	//FileInputStream fis=new FileInputStream("E:\\PropertiesFile\\Data.properties");
    
	
	//public String browserName;
	//public String urlName;
	public FileInputStream fis;
	public String browserName;
	public String urlName;
	
	public void init() throws IOException
	{
		selectBrowser(browserName);
		getUrl(urlName);
		String log4jconfpath="log4j.properties";
		PropertyConfigurator.configure(log4jconfpath);
	}
	
	public String  selectBrowser(String Browser) throws IOException
	{
		pro=new Properties();
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.properties");
		pro.load(fis);
	    browserName=pro.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome "))
		{	
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
		 log.info("Creating a object of"+Browser);
		 driver=new ChromeDriver();
		}
		 
		 else if(browserName.equalsIgnoreCase("firefox"))
		 {
			 log.info("Creating a object of"+Browser);
			 driver=new FirefoxDriver();
		 } 
		
		return browserName;
		
	
	}
	public void  getUrl(String Url) throws IOException
	{
		pro=new Properties();
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.properties");
		pro.load(fis);
		urlName=pro.getProperty("url");
		log.info("Navigating to: "+urlName);
		driver.get(urlName);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		
		
	}
	public String[][] getData(String sheetName,String excelName) throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\"+excelName;
		System.out.println(excelName);
		excel=new ExcelReader(path);
		String[][] data=excel.getDataFromSheet(sheetName, excelName);
		return data;
	}
	
	
	
		
		
		
		
		
		
		 
	}


