package BaseClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshots {
	
	WebDriver driver;
	logger log;
	
	public screenshots(WebDriver driver)
	{
		this.driver = driver;
		log = new logger(driver);
		
	}
	
	public void takeScreenshot(String fileName)
	{
		String path = "src/test/resources/screenshots/";
		File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File f2 = new File(path+fileName);
		try {
			FileUtils.copyFile(f1, f2);
			log.Update_log("Screenshots taken in name of " + fileName);
			
		}catch(IOException e)
		{
			log.Update_log("Error in taking screenshot");
		}		
		
	}
	

}
