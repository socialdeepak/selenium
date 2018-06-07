import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathFromSibling {

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://qaclickacademy.com/interview.php");
		driver.manage().window().maximize();
		//absolute path
		//driver.findElement(By.xpath(".//div/div/div/div/ul/li[@id='tablist1-tab1']")).click();
		
		//relative path
		//driver.findElement(By.xpath(".//*[@id='tablist1-tab1']")).click();
		
		//If we have more than one sibling we can get other sibling (following sibling)with the below command:
		//driver.findElement(By.xpath(".//div/div/div/div/ul/li[1]/following-sibling::li[text()=' Testing ']")).click();
		//driver.findElement(By.xpath(".//*[@id='tablist1-tab1']/following-sibling::li[2]")).click();
		
		//From sibling to parent
		//System.out.println(driver.findElement(By.xpath(".//*[@id='tablist1-tab1']/parent::ul")).getAttribute("role"));
		
		//we can get preceding sibling from any sibling
		//driver.findElement(By.xpath(".//*[@id='tablist1-tab4']/preceding-sibling::li[2]")).click();
		
		//if we know only text of any webpage then also we can find the webelement
		//driver.findElement(By.xpath(".//*[text()=' Selenium ']")).click();
		
		//we can use position to get the web element
		//driver.findElement(By.xpath(".//*[@id='tablist1-tab1']/following-sibling::li[position()='3']")).click();
		//driver.findElement(By.xpath(".//*[@id='tablist1-tab1']/following-sibling::li[last()]")).click();
		driver.findElement(By.xpath(".//*[@id='tablist1-tab1']/following-sibling::li[last()-1]")).click();
	}

}
