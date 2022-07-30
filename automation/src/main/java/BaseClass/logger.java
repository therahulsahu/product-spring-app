package BaseClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class logger {
	
	WebDriver driver;
	Logger Log;
	
	public logger(WebDriver driver)
	{
		this.driver = driver;
		Log = Logger.getLogger("devpinoyLogger");
		
	}
	
	public void Update_log(String Message)
	{
		Log.debug(Message);
	}
	

}
