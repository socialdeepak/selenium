package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPage 
{

	WebDriver driver;
	 
      public RediffLoginPage(WebDriver driver)
      {
    	 this.driver=driver ;
    	 PageFactory.initElements(driver, this);
      }

	 @FindBy(linkText="Sign in")
	 WebElement signin;
	 
	 @FindBy(id="login1")
	 WebElement username;
	 
	 @FindBy(id="password")
	 WebElement password;
	 
	 @FindBy(linkText="Home")
	 WebElement backtoHome;
	 
	 public WebElement signInTo()
	 {
		 return signin;
	 }
	 
	 public WebElement logInUserName()
	 {
		 return username;
	 }
	 
	 public WebElement loginPassword()
	 {
		 return password;
	 }
	 
	 public WebElement home()
	 {
		 return backtoHome;
	 }

}
