package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage 
{
	public static final Logger log=Logger.getLogger(LandingPage.class.getName());
		public WebDriver driver;
		
		@FindBy(xpath=".//*[@id='email']")
		WebElement EmailAddress;
		
		@FindBy(name="passwd")
		WebElement Password;
		
		@FindBy(name="SubmitLogin")
		WebElement Submit;
		
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void LoginToApp(String emailID,String passWord)
		{
			EmailAddress.sendKeys(emailID);
			log.info("Entered email adress :-"+emailID+ "and object is:- "+EmailAddress.toString());
			Password.sendKeys(passWord);
			log.info("Entered password :-"+passWord+ "and object is:- "+Password.toString());
			Submit.click();
			log.info("Clicked on Submit button and object is :-"+Submit.toString());
			
			
		}

	
}
