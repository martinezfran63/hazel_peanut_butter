package newpackage;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class PrintScreen  {
	
	// Get Chrome Driver for testing
    WebDriver mydriver = new ChromeDriver();

	
	public static void main (WebDriver mydriver) throws IOException{

		//Get Screenshot on first website
		File scrFile = ((TakesScreenshot)mydriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("Screenshots/" + new java.util.Date() + ".png" ));
	}
	

	
	public static void take_screenshot (WebDriver mydriver, String NameOfDevice, int i) throws IOException{

			//Get Screenshot on first website
			File scrFile = ((TakesScreenshot)mydriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("Screenshots/" + i + "_" + NameOfDevice + "_" + new java.util.Date() + ".png" ));		
		}
	
	
	
	
	public static void fail (WebDriver mydriver, String NameOfDevice, int i) throws IOException{
			//Get Screenshot on first website
			File scrFile = ((TakesScreenshot)mydriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("Screenshots/Failed/" + i + "_FAIL_" + NameOfDevice + "_" + new java.util.Date() + ".png" ));		

		}

}
