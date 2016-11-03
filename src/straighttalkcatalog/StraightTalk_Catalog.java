package straighttalkcatalog;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class StraightTalk_Catalog{

    public static void main(String[] args) throws IOException, InterruptedException {

	//Test Time and Date
	System.out.println("Test Executed: " + new java.util.Date());

    // Get Chrome Driver for testing
    System.setProperty("webdriver.chrome.driver", "chromedriver");
    WebDriver mydriver = new ChromeDriver();
    
	 //Create File In C: Driver.  
	  String TestFile = "/Users/fmartinez/Documents/workspace/IMM_Selenium/Text_Output/Straight_Talk_Catalog_" +new java.util.Date()+ ".txt";
	  File FC = new File(TestFile);//Created object of java File class.
	  FC.createNewFile();//Create file.
	  //Writing In to file.
	  //Create Object of java FileWriter and BufferedWriter class.
	  FileWriter FW = new FileWriter(TestFile);
	  BufferedWriter BW = new BufferedWriter(FW);
    
	String myURL;
	String zip1;
	String Bright_Point_Price;
	String Name;
	String Catalog_Price;
	int count;
	 
	Bright_Point_Price = "0";
	myURL="http://specials.straighttalk.com/catalog/";
	zip1="80301";


	// Navigate to Net10wireless.com
 	mydriver.navigate() .to(myURL);
 	
 	// Maximize windowv
 	mydriver.manage().window().maximize(); 

	//TimeUnit.SECONDS.sleep(2);
	//take screenshot to make sure content is displaying correctly
	//PrintScreen.main(mydriver);
	
	
	//Type in the Zipcode
	System.out.println("Type in the Zip Code");
	mydriver.findElement(By.xpath("html/body/div[4]/div[2]/form/input[1]")).sendKeys(zip1);

	//click the “Enter” button
	System.out.println("Click the 'Enter' button");
	mydriver.findElement(By.xpath("/html/body/div[4]/div[2]/form/input[11]")).click();

	//click the "Yes" button
	System.out.println("Click the 'Yes' button");
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
		
   System.out.println("There are " + count + " phones currently on the page\n");
   BW.write("There are " + count + " phones currently on the page\n"); //Writing In To File.
   BW.newLine();//To write next string on new line.


	//i is device count. set to device your having error at so you don't have to go through each device during execution
	// i=1 to start from beginning
	//for(int i = 1; i<=count ;i++){
	for(int i = 1; i<=2 ;i++){
	
    // go back to catalog page after each individual phone comparison done
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
		   System.out.println("#"+ i+ " " + "Straight Talk Catalog: "+ Name);
		   BW.write("#"+ i+ " " + "Straight Talk Catalog: "+ Name); //Writing In To File.
		   BW.newLine();//To write next string on new line.
			  
		   //Select Buy Now from specials.straighttalk.com
		   System.out.println("Select Buy Now from 'specials.straighttalk.com' ");
		   mydriver.findElement(By.xpath("html/body/section[1]/div[3]/ul/li["+i+"]/a[2]")).click();
		  
		   //if else statement. if equal to 'FREE' the program follows steps for free phone
		   if (Catalog_Price.equals("FREE"))   
		   {
			   Free.main(mydriver, Bright_Point_Price, Name, i, Catalog_Price, BW, FW);
		   }
		   
		   //flow for phones that are not free
		   else {
			   
			   try
			   {
				   							//see if "Buy Phone Only" link present
										   if (mydriver.findElements(By.xpath("html/body/section[1]/section/div/a")).size() == 0) {
											    //block of code to be executed if condition1 is true
											    //regular phone that asks to select plan
											    System.out.println("*For regular phone where Select Buy Phone Only' link not present. Need to click on Plan and do comparison with plan");
											  
											  //Select Plan
											  mydriver.findElement(By.xpath("/html/body/section[1]/section/div/div/div[1]/a")).click(); 
											  System.out.println("*Please note the price comparision for this device includes a plan. Unable to find 'Select Buy Phone only'");
						   
											} else if (mydriver.findElements(By.xpath("/html/body/section[1]/section/div/div/div[1]/a")).size() == 0) {
											    // block of code to be executed if the condition1 is false and condition2 is true
												//regular phone that goes straight to cart
												System.out.println("*For regular phones that go straight to cart");
												Regular_to_catalog.main(mydriver, Bright_Point_Price, Name, i, Catalog_Price);
												
												
												break;
											} else {
											     //block of code to be executed if the condition1 is false and condition2 is false
												 //Select Buy Phone Only. path for most phones
												 System.out.println("*For regular phones that has 'Select Buy Phone Only' link ");
												 System.out.println("Select 'Buy Phone Only'");
												   
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
				   System.out.println("Click 'Proceed To Checkout'");
				   
				   //Screen Shot on our Catalog
				   System.out.println("Print Screen at our catalog");
				   PrintScreen.take_screenshot(mydriver, Name, i);
				   
				   //Select Proceed to checkout
				   
				   //Reassign amount; have to do this or phones that require plan will fail comparsion
				   TimeUnit.SECONDS.sleep(3);
				   System.out.println("Reassign variable holding device value to value of device at our Catalog's Cart");
				   Catalog_Price=mydriver.findElement(By.xpath("/html/body/section[1]/div/form/table/tbody/tr[2]/td[4]/div")).getText(); 
				   System.out.println("Catalog Cart Price: " + Catalog_Price);
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
				   System.out.println("Get Price at BP site");
				   //Screen Shot on Bright Point Catalog
				   System.out.println("Print Screen at BP site");
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

			   BW.write(Catalog_Price +" Straight Talk Catalog Price"); //Writing In To File.
			   BW.newLine();//To write next string on new line.
			   BW.write(Bright_Point_Price +" Bright Point Price"); //Writing In To File.
			   BW.newLine();//To write next string on new line.

			   System.out.println(Catalog_Price + " Straight Talk Catalog Price");
			   System.out.println(Bright_Point_Price + " Bright Point Price");

			   		//code to compare our Catalog Price with BP price
					if (Catalog_Price.equals(Bright_Point_Price)){

 						System.out.println("PASS\n");
 						BW.write("PASS"); //Writing In To File.
 						BW.newLine();//To write next string on new line.
 						BW.newLine();//To write next string on new line.
 						
 					}else {

 						System.out.println("FAIL\n");
 						BW.write("FAIL"); //Writing In To File.
 						BW.newLine();//To write next string on new line.
 						BW.newLine();//To write next string on new line.
 						
 					}
 				 
					
		   }
		   


		   						}
								
	     System.out.println("\n\n\nEND OF TEST!\n");
	     BW.close();
	
				} /* end of major for loop */
	


	
	}
	


	

			

