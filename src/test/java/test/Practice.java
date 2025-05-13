package test;

import java.time.Duration;
import java.util.List;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
    WebDriver driver;

    // Use @BeforeClass to initialize WebDriver
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();  // Initialize ChromeDriver
        driver.manage().window().maximize();  // Maximize window
    }

    @Test
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
      		
   
    }

    // Optional: Add @AfterClass to quit the driver after tests are done
    @AfterClass
    public void tearDown() {
        driver.quit();  // Close the browser
    }
}
