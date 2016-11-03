//main methods
package tracfone;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class tracfone{
	
	
	public static WebDriver mydriver;
	
	
	@BeforeMethod

	  public void beforeMethod() throws Exception {
		//Test Time and Date
		System.out.println("Tracfone Test Executed: " + new java.util.Date());
		
		
	}
	
	
	
	@Test
    public void main() throws IOException, InterruptedException {

	

    // Get Chrome Driver for testing
    System.setProperty("webdriver.chrome.driver", "chromedriver");
     mydriver = new ChromeDriver();
    
    

	String myURL;
	String zip1;
	String Bright_Point_Price;
	String Name;
	String Catalog_Price;
	int count;
	String Results;
	
	 
	Bright_Point_Price = "0";
	myURL="http://sale.tracfone.com/";
	zip1="80301";


	// Navigate to Net10wireless.com
 	mydriver.navigate() .to(myURL);
 	
 	// Maximize windowv
 	mydriver.manage().window().maximize(); 

	TimeUnit.SECONDS.sleep(2);
	//take screenshot to make sure content is displaying corretly
	PrintScreen.main(mydriver);
	

		
						
							
							
							




		   						

	
	
					} /* end of major for loop */
	

    @AfterMethod
    
    public void afterMethod() {
   
  	   mydriver.quit();
  	  System.out.println("BYE BYE BYE");
   
          }
    

	
	}
	


