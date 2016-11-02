package straighttalkcatalog;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class StraightTalk_Catalog{

    public static void main(String[] args) throws IOException, InterruptedException {

	//Test Time and Date
	System.out.println("Test Executed: " + new java.util.Date());

    // Get Chrome Driver for testing
    System.setProperty("webdriver.chrome.driver", "chromedriver");
    WebDriver mydriver = new ChromeDriver();
    
    

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
	
	ArrayList<String> Pass = new ArrayList<String>();
	ArrayList<String> Fail = new ArrayList<String>();

	//i is device count. set to device your having error at so you don't have to go through each device during execution
	// i=1 to start from begining
	for(int i = 59; i<=count ;i++){
	
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
		
		   //System.out.println("Select Buy Now from specials.straighttalk.com");
		   //Select Buy Now from specials.straighttalk.com
		   mydriver.findElement(By.xpath("html/body/section[1]/div[3]/ul/li["+i+"]/a[2]")).click();
		  
		   
		   // if else statment. if equal to free the execution follows steps for free phone
		   if (Catalog_Price.equals("FREE"))   
		   {
			   Free.main(mydriver, Bright_Point_Price, Name, i, Catalog_Price);
		   }
		   
		   else {
			   
			   try
			   {
				   							//see if "Buy Phone Only" link present
										   if (mydriver.findElements(By.xpath("html/body/section[1]/section/div/a")).size() == 0) {
											    //block of code to be executed if condition1 is true
											   //regular phone that asks to select plan
											   System.out.println("No Plan: Need to click on Plan");
											   //Select Plan
											  mydriver.findElement(By.xpath("/html/body/section[1]/section/div/div/div[1]/a")).click(); 


						   
											} else if (mydriver.findElements(By.xpath("/html/body/section[1]/section/div/div/div[1]/a")).size() == 0) {
											   // block of code to be executed if the condition1 is false and condition2 is true
												//regular phone that goes to catalog
												Regular_to_catalog.main(mydriver, Bright_Point_Price, Name, i, Catalog_Price);
												break;
											} else {
											     //block of code to be executed if the condition1 is false and condition2 is false
												//Select Buy Phone Only. path for most phones
												   System.out.println("Select Buy Phone Only");
												   
												   mydriver.findElement(By.xpath("html/body/section[1]/section/div/a")).click(); 
											}
										   
				   
				   
				   
			   }
			   catch (Throwable e)
			   {
				PrintScreen.fail(mydriver, Name, i);
			    System.out.println("Unable to select 'Buy Phone Only'");
			   }

			   
			   try
			   {
				   

				   TimeUnit.SECONDS.sleep(3);	
				   System.out.println("Click check out");
				   //screen shot on our catalog
				   PrintScreen.take_screenshot(mydriver, Name, i);
				   //Select Proceed to checkout
				   //reassign amount
				   TimeUnit.SECONDS.sleep(3);
				   System.out.println("reassign amount");
				   Catalog_Price=mydriver.findElement(By.xpath("/html/body/section[1]/div/form/table/tbody/tr[2]/td[4]/div")).getText(); 
				   //
						   System.out.println("C@@@@@" + Catalog_Price + "%%%%");
				   mydriver.findElement(By.id("_ga_catalog_checkout")).click();
			   }
			   catch (Throwable e)
			   {
				   PrintScreen.fail(mydriver, Name, i);
			    System.out.println("Unable to click 'Proceed To Checkout' ");
			   
			   }

			   
			   try
			   {
				   TimeUnit.SECONDS.sleep(3);
				   System.out.println("Get price at BP site");
				   //screen shot on Bright Point Catalog
			       PrintScreen.take_screenshot(mydriver, Name, i);
				   //Get price
				   Bright_Point_Price=mydriver.findElement(By.cssSelector("td.cartPriceCol")).getText();
			      
			      
			   }
			   catch (Throwable e)
			   {
				   PrintScreen.fail(mydriver, Name, i);
			    System.out.println("Unable to get price on Bright Point site");
			   
			   }

			   
					  
			   try
			   {
					TimeUnit.SECONDS.sleep(3);
					System.out.println("Clear Cart");		
					mydriver.findElement(By.linkText("Clear Cart")).click();
			   }
			   catch (Throwable e)
			   {
				   PrintScreen.fail(mydriver, Name, i);
				   System.out.println("Unable to Click 'Clear Cart'");
			  
			   }

				  
			   
			   try
			   {
					TimeUnit.SECONDS.sleep(3);
					System.out.println("Continue Shopping to start next price check");
					mydriver.findElement(By.id("continueShoppingBtn")).click();
			   }
			   catch (Throwable e)
			   {
				   PrintScreen.fail(mydriver, Name, i);
			    System.out.println("Unable to click 'Continue Shopping' to start next price check");
			   
			   }


			   

				 System.out.println("Price Comparison/n");
				 System.out.println(Catalog_Price + " Straight Talk Catalog Price");
				 System.out.println(Bright_Point_Price + " Bright Point Price");
 				
 				 
 				 
				if (Catalog_Price.equals(Bright_Point_Price)){
 						Results=("Pass: results are expected");
 						Pass.add(Name + Results +" ");
 						System.out.println("MMPass: results are expected\n");

	
 					}else {
 						Results=("FAil: results are expected");
 						Fail.add(Name + Results +" ");
 						System.out.println("MMFail: results are not expected\n");

 					}
			   

		   }
		   
		   
		  			
			  			
							
							
							
							




		   						}
								
	
	System.out.println("I");
	System.out.println("Current Pass list is:"+Pass);
	
	
	if(Fail.isEmpty())
	{
	    System.out.println("There is no price errors");
	}else{
		System.out.println("Current FAIL list is:"+Fail);
		
	}
	
	
					} /* end of major for loop */
	


	
	}
	


	

			

