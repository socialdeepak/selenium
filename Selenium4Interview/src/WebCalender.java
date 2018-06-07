import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebCalender 
{
	 public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			//CheckIn
			driver.get("https://www.tripadvisor.in/");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='taplc_trip_search_home_default_0']/div[2]/div[2]/div/span[1]/span[1]")).click();
			//Thread.sleep(3000);
			//driver.findElement(By.linkText("Check In")).click();
			String date="3-August 2018";
			String splitter[]=date.split("-");
			String checkInday=splitter[0];
			String checkInMonth =splitter[1];
			
			selectDate(checkInMonth,checkInday);
			
			//CheckOut
			driver.findElement(By.xpath("//*[@id='taplc_trip_search_home_default_0']/div[2]/div[2]/div/span[3]/span[1]")).click();
			String date1="10-August 2018";
			String splitter1[]=date1.split("-");
			String checkOutday=splitter1[0];
			String checkOutMonth =splitter1[1];
			
			selectDate(checkOutMonth,checkOutday);	
		}
		
		

public static void selectDate(String month_year,String day) throws InterruptedException
  {
				
  // List<WebElement> elements= driver.findElements(By.xpath("//div[@class='calendar']/div[@class='month']/table/thead/tr/th[@class='caption']"));
   List<WebElement> elements= driver.findElements(By.xpath(".//*[@class='dsdc-months']/span[@class='dsdc-month']/span[@class='dsdc-month-title']"));
	for(int i=0;i<elements.size();i++)
		{
		 //System.out.println(elements.get(i).getText());
		 if(elements.get(i).getText().equals(month_year))
		  {
			//List<WebElement> days=driver.findElements(By.xpath("//div[@class='calendar']/div[@class='month']["+(i+1)+"]/table/tbody/tr/td"));
			List<WebElement> days=driver.findElements(By.xpath(".//*[@class='dsdc-months']["+(i+1)+"]/span[@class='dsdc-month']/span[@class='dsdc-cell dsdc-day']"));
			for(WebElement d: days)
			 {
				System.out.println(d.getText());
				if(d.getText().equals(day))
				{
				 d.click();
				 return;
				 
				}
			 }
		  }
		}
		//driver.findElement(By.xpath("//span[@class='next sprite-date_picker-btnRightIdle']")).click();
		driver.findElement(By.xpath(".//*[@id='BODY_BLOCK_JQUERY_REFLOW']/span/div[3]/div/div[2]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//span[@class='next sprite-date_picker-btnRightIdle']")).click();
		driver.findElement(By.xpath(".//*[@id='BODY_BLOCK_JQUERY_REFLOW']/span/div[3]/div/div[2]")).click();
				
		Thread.sleep(6000);
		selectDate(month_year,day);
		}
}
