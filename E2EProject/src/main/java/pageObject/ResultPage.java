package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage 
{
public static final Logger log=Logger.getLogger(ResultPage.class.getName());
WebDriver driver;
	
	@FindBy(xpath=".//*[@id='center_column']/div[1]/ol/li")
	WebElement AuthenticationFailed;
	
	public ResultPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getInvalidLoginTest()
	{	
	log.info("Error message is :-" +AuthenticationFailed.getText());	
	return AuthenticationFailed.getText();
	
	}
}
