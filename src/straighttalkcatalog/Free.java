package straighttalkcatalog;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;




public class Free  {
	
	// Get Chrome Driver for testing
    WebDriver mydriver = new ChromeDriver();

	
	public static void main (WebDriver mydriver,String Bright_Point_Price, String Name, int i, String Catalog_Price) throws IOException{
		
		System.out.println("*Please note the price comparision for free devices includes a plan");
		
		 try
		   {
			 System.out.println("Free: Click on Plan");
			   //Select Plan
			   mydriver.findElement(By.xpath("/html/body/section[1]/section/div/div/div[1]/a")).click(); 
			   
		   }
		   catch (Throwable e)
		   {
			   PrintScreen.fail(mydriver, Name, i);
		    System.out.println("Unable to get price on http://specials.straighttalk.com/catalog/");
		   
		   }
		 
		 
		  //Get price on our catalog
		 try
		   {
			   TimeUnit.SECONDS.sleep(3);	
			   System.out.println("Free: Get Price");

			   //Get price
			   Catalog_Price=mydriver.findElement(By.xpath("/html/body/section[1]/div/form/table/tbody/tr[2]/td[3]/div")).getText();	   
		   }
		   catch (Throwable e)
		   {
			   PrintScreen.fail(mydriver, Name, i);
		    System.out.println("Unable to click 'Proceed To bright Point' ");
		   
		   }


		   try
		   {

			   //reassign amount
			   TimeUnit.SECONDS.sleep(3);
			   Catalog_Price=mydriver.findElement(By.xpath("/html/body/section[1]/div/form/table/tbody/tr[4]/td[2]")).getText(); 

			   
			   TimeUnit.SECONDS.sleep(3);	
			   System.out.println("CLick 'Proceed to Checkout'");
			   
			   //screen shot on our catalog
			   PrintScreen.take_screenshot(mydriver, Name, i);
			   //Select Proceed to checkout
			   mydriver.findElement(By.id("_ga_catalog_checkout")).click();
		   }
		   catch (Throwable e)
		   {
			   PrintScreen.fail(mydriver, Name, i);
			   System.out.println("Unable to click 'Proceed To Checkout' ");
		   
		   }
		   
		   //get price at BP
		   try
		   {
			   System.out.println("Free: Get price at BP");
		       //screen shot on Bright Point Catalog
		       PrintScreen.take_screenshot(mydriver, Name, i);
			   //Get price
			   Bright_Point_Price=mydriver.findElement(By.cssSelector("td.cartPriceCol")).getText();
		       TimeUnit.SECONDS.sleep(3);

		   }
		   catch (Throwable e)
		   {
			   PrintScreen.fail(mydriver, Name, i);
		    System.out.println("Unable to get price on Bright Point site");
		   
		   }
		   
		   try
		   {
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Click 'Clear Cart'");		
				mydriver.findElement(By.linkText("Clear Cart")).click();
		   }
		   catch (Throwable e)
		   {
			   PrintScreen.fail(mydriver, Name, i);
		       System.out.println("Unable to Click 'Clear Cart'");
		  
		   }


		 System.out.println("Price Comparison/n");
		 System.out.println(Catalog_Price + " Straight Talk Catalog Price");
		 System.out.println(Bright_Point_Price + " Bright Point Price");
				 
			if (Catalog_Price.equals(Bright_Point_Price)){
				 System.out.println("Pass statement");
						System.out.println("free Pass: results are expected");
						System.out.println("");

					}else {
						System.out.println("Fail statemetn");
						System.out.println("freeFAIL: results are not expected");
						System.out.println("");		
						}
	
	}
	

}
