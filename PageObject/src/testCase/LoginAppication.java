package testCase;

import org.testng.annotations.Test;

import objectRepository.RediffLoginPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class LoginAppication 
{
public WebDriver driver;	
  @Test
  public void LoginToRediff() 
  {
	  /*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\libBrowser\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://www.rediff.com/");
	  driver.manage().window().maximize();*/
	  RediffLoginPage rlp=new RediffLoginPage(driver);
	  rlp.signInTo().click();
	  rlp.logInUserName().sendKeys("priti");
	  rlp.loginPassword().sendKeys("sara");
	  rlp.home().click();
	  
	  		  
  }
  @BeforeClass
  public void setUp() 
  {
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\libBrowser\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get("http://www.rediff.com/");
	 driver.manage().window().maximize();
  }

  @AfterClass
  public void tearsDown() 
  {
	 driver.close();
  }

}
