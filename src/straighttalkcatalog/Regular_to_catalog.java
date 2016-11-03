package straighttalkcatalog;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;




public class Regular_to_catalog  {
	
	// Get Chrome Driver for testing
    WebDriver mydriver = new ChromeDriver();

	
	public static void main (WebDriver mydriver,String Bright_Point_Price, String Name, int i, String Catalog_Price) throws IOException{
		
		System.out.println("*For regular phones that go straight to cart");
		
	

		  //Get price on our catalog
		 try
		   {
			   TimeUnit.SECONDS.sleep(3);	
			   System.out.println("Phone to Cart: Get Price");

			   //Get price
			   Catalog_Price=mydriver.findElement(By.xpath("/html/body/section[1]/div/form/table/tbody/tr[2]/td[3]/div")).getText();	   
		   }
		   catch (Throwable e)
		   {
			   PrintScreen.fail(mydriver, Name, i);
		    System.out.println("Phone to Cart: Unable to click 'Proceed To bright Point' ");
		   
		   }


		   try
		   {
			   TimeUnit.SECONDS.sleep(3);	
			   System.out.println("Phone to Cart: Click 'Proceed to Checkout'");
			   
			   //screen shot on our catalog
			   PrintScreen.take_screenshot(mydriver, Name, i);
			   //Select Proceed to checkout
			   mydriver.findElement(By.id("_ga_catalog_checkout")).click();
		   }
		   catch (Throwable e)
		   {
			   PrintScreen.fail(mydriver, Name, i);
			   System.out.println("Phone to Cart: Unable to click 'Proceed To Checkout' ");
		   
		   }
		   
		   //get price at BP
		   try
		   {
			   System.out.println("Phone to Cart: Get price at BP");
			   //screen shot on Bright Point Catalog
		       PrintScreen.take_screenshot(mydriver, Name, i);
			   //Get price
			   Bright_Point_Price=mydriver.findElement(By.cssSelector("td.cartPriceCol")).getText();
		       TimeUnit.SECONDS.sleep(3);
		      
		   }
		   catch (Throwable e)
		   {
			   PrintScreen.fail(mydriver, Name, i);
		    System.out.println("Phone to Cart: Unable to get price on Bright Point site");
		   
		   }
		   
		   try
		   {
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Phone to Cart: Click 'Clear Cart'");		
				mydriver.findElement(By.linkText("Clear Cart")).click();
		   }
		   catch (Throwable e)
		   {
			   PrintScreen.fail(mydriver, Name, i);
		       System.out.println("Phone to Cart: Unable to click 'Clear Cart'");
		  
		   }

	
	}
	

}
