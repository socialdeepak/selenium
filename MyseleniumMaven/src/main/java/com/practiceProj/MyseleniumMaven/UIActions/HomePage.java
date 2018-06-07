package com.practiceProj.MyseleniumMaven.UIActions;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
  public static final Logger log=Logger.getLogger("HomePage.class.getName()");
  WebDriver driver;	
  
  @FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
  WebElement SignIn;
  
  @FindBy(xpath=".//*[@id='email']")
  WebElement EmailAddress;
  
  @FindBy(xpath=".//*[@id='passwd']")
  WebElement Password;
  
  @FindBy(xpath=".//*[@id='SubmitLogin']")
  WebElement SubmitButton ;
  
  @FindBy(xpath=".//*[@id='center_column']/div[1]/ol/li")
  WebElement AuthenticationFailed;
  
  
  
  

public HomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void loginToApplication(String emailAddress,String password)
{
SignIn.click();
log.info("Clicked on SignIn and object is "+SignIn.toString());
EmailAddress.sendKeys(emailAddress);
log.info("Entered Email Address :"+EmailAddress+"and the object is" +EmailAddress.toString());
Password.sendKeys(password);
log.info("Entered password :"+Password+"and the object is" +Password.toString());
log.info("");
SubmitButton.click();
log.info("Clicked on Submit and object is "+SubmitButton.toString());
}

public String getInvalidLoginTest()
{
log.info("Error message is :-" +AuthenticationFailed.getText());	
return AuthenticationFailed.getText();	
}

}
