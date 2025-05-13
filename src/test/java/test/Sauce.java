package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sauce {

	RemoteWebDriver driver;
	String jobStatus="failed";
	@Test
	public void TestRemote() throws MalformedURLException
	{
	ChromeOptions browserOptions = new ChromeOptions();
	browserOptions.setPlatformName("Windows 11");
	browserOptions.setBrowserVersion("latest");
	Map<String, Object> sauceOptions = new HashMap<String, Object>();
	sauceOptions.put("username", "oauth-suryamitracse-abd27");
	sauceOptions.put("accessKey", "1fefc8fc-3999-419f-9c3a-c006df5daf7f");
	sauceOptions.put("build", "selenium-build-IF2WP");
	sauceOptions.put("name", "Test- Surya");
	browserOptions.setCapability("sauce:options", sauceOptions);
	
	// start the session
	URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	 driver = new RemoteWebDriver(url, browserOptions);
	 



}
	
	@Test(dependsOnMethods="TestRemote")
    public void testPagination() throws InterruptedException {
        driver.get("https://practice.expandtesting.com/dynamic-pagination-table");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Print all names
      WebElement next =   driver.findElement(By.xpath("//a[text()='Next']/parent::li"));
      
      while(!next.getAttribute("class").contains("disabled"))
      {
     List<WebElement> names = driver.findElements(By.xpath("//tbody[@id='demo']/tr/td[1]"));
     for(int i=0;i<names.size();i++)
     {
     System.out.println(names.get(i).getText());
      }
     next.click();
     //Thread.sleep(5000);
     next = driver.findElement(By.xpath("//a[text()='Next']/parent::li"));
      }
      List<WebElement> names = driver.findElements(By.xpath("//tbody[@id='demo']/tr/td[1]"));
      for(int i=0;i<names.size();i++)
      {
      System.out.println(names.get(i).getText());
       }
      		
      jobStatus = "passed";
    }
	
	@AfterTest
	public void destroy()
	{
		// end the session
		driver.executeScript("sauce:job-result=" + jobStatus);
		driver.quit();
	}
}
