package TestCrimeReporting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


//@Listeners(TC003Listener.MyListener.class) //use common Listener.xml instead of annotation on every testcases...
public class CrimeReport {
	WebDriver driver;
	
	@BeforeClass
	void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\New chromedriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://hybrid.srishticampus.in/crime_reporting");
		driver.manage().window().maximize();
			
	}
  @Test(priority=1)
  void testlogo()
  {
	boolean logo = driver.findElement(By.xpath("//p[@class='navbar_title']//span[contains(text(),'Reporting')]")).isDisplayed();
	Assert.assertEquals(logo,true);
}
  
  @Test(priority=2)
  void testUrl()
  {
	  Assert.assertEquals(driver.getCurrentUrl(), "http://hybrid.srishticampus.in/crime_reporting");
	  System.out.println(driver.getCurrentUrl());
  }
  
@Test(priority=3, dependsOnMethods= {"testUrl"})
  void testHomePageTitle()
  {
	Assert.assertEquals(driver.getTitle(), "Crime Reporting");
	 System.out.println(driver.getTitle());
  }
  
  
  @AfterClass
  void tearDown()
  {
	  driver.quit();
  }
  
}