package pkgSeleniumWebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {

	public static void main(String[] args) 
	{
		WebDriver driver;
		//System.setProperty("webdriver.chrome.driver","E:\\Priti-selenium-practice\\Software\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\lib\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"\\lib\\geckodriver.exe");
		driver=new ChromeDriver();
		//driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		System.out.println("Hello Selenium");

	}
}