package navigationPayPal;

import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
 
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import org.testng.annotations.BeforeMethod;
 
import org.testng.annotations.AfterMethod;
 
public class TestNG {
 
	public WebDriver driver;
 
  @Test
 
  public void main() throws Exception {
	  
	  String driverPath = "C:/Users/sivaes/Downloads/chromedriver_win32/";
	  
	  System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
	  
	// Initialize browser
	WebDriver driver=new ChromeDriver();
 
      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
      //Launch the Online Store Website
 
      driver.get("https://www.paypal.com/us/home");
      
      driver.manage().window().maximize();
      
      Thread.sleep(20000);
	  
 
	// Find the element that's ID attribute is 'account'(My Account)
      
      driver.navigate().to("https://www.paypal.com/us/webapps/mpp/about-paypal-products");
      
      Thread.sleep(20000);
      
      driver.navigate().to("https://www.paypal-gifts.com/us/giftcardlist");
      
      Thread.sleep(50000);
      
      String newvalue = driver.findElement(By.xpath(".//*[@id='main-content']/div[3]/div/div[4]/section/div/div[4]")).getText();
      
      
      List<WebElement> allLinks = driver.findElements(By.cssSelector(".brand-box"));
      
      //List<WebElement> allLinks = driver.findElements(By.xpath(".//*[@id='main-content']/div[3]/div/div[4]/section/div/div[4]/div"));
      
      driver.navigate().to("https://www.paypal-gifts.com/us/brands/nike.html");
      
      driver.findElement(By.xpath(".//*[@id='denomination_2689']/a")).click();
      
      String ActualValue = driver.findElement(By.xpath(".//*[@id='denomination_2689']/a")).getText();
      
      System.out.println("Actual Size=>"+ActualValue);
      
      driver.findElement(By.id("buynowbutton_2689")).click();
      
      Thread.sleep(20000);
      
      driver.findElement(By.xpath(".//*[@class='terms-checkbox']")).click();
      
		
	  Thread.sleep(20000);
		 
   	 driver.findElement(By.xpath(".//a[@id='termsButton_enabled']")).click();
      
           
      String expectedValue = driver.findElement(By.xpath(".//*[@id='transactionCart']/span[2]/format-currency/span")).getText();
      
      
      Thread.sleep(20000);
      
      String evalue = expectedValue.substring(0,3);
      
      Assert.assertEquals(ActualValue, evalue);
      
      driver.quit();
      

      

      
 
  }
 
   
  //@AfterClass
 
  public void afterClass() {
 
	  // Close the driver
 
      driver.quit();
 
  }
 
}
