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
		System.out.println("Straight Talk Catalog Test Executed: " + new java.util.Date());
		
		
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
	myURL="http://specials.straighttalk.com/catalog/";
	zip1="80301";


	// Navigate to Net10wireless.com
 	mydriver.navigate() .to(myURL);
 	
 	// Maximize windowv
 	mydriver.manage().window().maximize(); 

	TimeUnit.SECONDS.sleep(2);
	//take screenshot to make sure content is displaying corretly
	PrintScreen.main(mydriver);
	
	
	//Type in the Zipcode
	//System.out.println("Type in the Zipcode");
	mydriver.findElement(By.xpath("html/body/div[4]/div[2]/form/input[1]")).sendKeys(zip1);

	//click the “Enter” button
	//System.out.println("click the “Enter” button");
	mydriver.findElement(By.xpath("/html/body/div[4]/div[2]/form/input[11]")).click();

	//click the "Yes" button
	//System.out.println("click the "Yes" button");
	TimeUnit.SECONDS.sleep(2);
	mydriver.findElement(By.xpath("/html/body/div[6]/div[1]/div/a")).click();

	
	// Get the text of the body element
	WebElement body = mydriver.findElement(By.tagName("body"));
	String bodyText = body.getText();

	// Count occurrences of the string
	count = 0;

	// search for the string "VIEW DETAILS" within the text. when instance of string "VIEW DETAILS" found, increment 'phone_count'
	while (bodyText.contains("VIEW DETAILS")) {
		count++;
		// continue searching from where you left off
		bodyText = bodyText.substring(bodyText.indexOf("VIEW DETAILS") + "VIEW DETAILS".length());
	}
		
	
	//Prompt informing user of number of devices on page
	System.out.println("There are " + count + " phones currently on the page\n");


	//i is device count. set to device your having error at so you don't have to go through each device during execution
	// i=1 to start from begining
	for(int i = 55; i<=count ;i++){
	
	mydriver.navigate() .to(myURL);
			
	TimeUnit.SECONDS.sleep(3);
	
					if ((i > 3 ) ) {
						
						JavascriptExecutor jse = (JavascriptExecutor)mydriver;
						jse.executeScript("window.scrollBy(0,455)", "");	
					}
					
					if ((i > 6 ) ) {
						
						JavascriptExecutor jse = (JavascriptExecutor)mydriver;
						jse.executeScript("window.scrollBy(0,450)", "");
					}
					
					if ((i > 9 ) ) {
					
						JavascriptExecutor jse = (JavascriptExecutor)mydriver;
						jse.executeScript("window.scrollBy(0,450)", "");
					}
					
					if ((i > 12 ) ) {
						
						JavascriptExecutor jse = (JavascriptExecutor)mydriver;
						jse.executeScript("window.scrollBy(0,450)", "");
					}
					
					if ((i > 15 ) ) {
					
						JavascriptExecutor jse = (JavascriptExecutor)mydriver;
						jse.executeScript("window.scrollBy(0,450)", "");
					}
					
					if ((i > 18 ) ) {
					
						JavascriptExecutor jse = (JavascriptExecutor)mydriver;
						jse.executeScript("window.scrollBy(0,450)", "");
					}
					
					if ((i > 21 ) ) {
					
						JavascriptExecutor jse = (JavascriptExecutor)mydriver;
						jse.executeScript("window.scrollBy(0,450)", "");
						}
					
					if ((i > 24 ) ) {
						
						JavascriptExecutor jse = (JavascriptExecutor)mydriver;
						jse.executeScript("window.scrollBy(0,450)", "");
					}
					
					if ((i > 27 ) ) {
					
						JavascriptExecutor jse = (JavascriptExecutor)mydriver;
						jse.executeScript("window.scrollBy(0,450)", "");		
					}
		
					
			TimeUnit.SECONDS.sleep(3);
			
			
			
			// Select the Name of the Phone
			Name=mydriver.findElement(By.xpath("html/body/section[1]/div[3]/ul/li["+i+"]/div[3]/div")).getText();

			//Select the Price of phone on Straight talk  phones page
			Catalog_Price=mydriver.findElement(By.xpath("html/body/section[1]/div[3]/ul/li["+i+"]/div[4]")).getText();
			
			
		   //Prompt informing user of number of device #, device name, device price
		   System.out.println("#"+ i+ " " + "Straight Talk Catalog:"+ Name+"\n");
		   
		   
		   
		
		
							regular.main( mydriver,  i,  Bright_Point_Price,  Catalog_Price,  Name);
							
							
							




		   						}

	
	
					} /* end of major for loop */
	

    @AfterMethod
    
    public void afterMethod() {
   
  	   mydriver.quit();
  	  System.out.println("BYE BYE BYE");
   
          }
    

	
	}
	


