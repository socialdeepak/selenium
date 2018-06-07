import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='travel_date']")).click();
		
		WebElement month=driver.findElement(By.className("datepicker-switch"));
		
		while(!month.getText().contains("March"))
		{
		 driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr/th[@class='next']")).click();	
		}
		List<WebElement> dates=driver.findElements(By.className("day"));
		int count=dates.size();
		for(int i=0;i<count;i++)
		{
			String text=driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("21"))
			{
				driver.findElements(By.className("day")).get(i).click();
				break;
			}	
		}

	}

}
