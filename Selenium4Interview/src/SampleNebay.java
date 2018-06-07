import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleNebay {

	public static void main(String[] args) 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("No of links present in the parent page is :" +links.size());
		
		WebElement header=driver.findElement(By.xpath(".//*[@id='gh']"));
		List<WebElement> hlinks=header.findElements(By.tagName("a"));
		System.out.println("No of links present in the header page is :" +hlinks.size());
		
		
		
		WebElement footer=driver.findElement(By.xpath(".//*[@id='glbfooter']"));
		List<WebElement> flinks=footer.findElements(By.tagName("a"));
		System.out.println("No of links present in the footer page is :" +flinks.size());

	}

}
