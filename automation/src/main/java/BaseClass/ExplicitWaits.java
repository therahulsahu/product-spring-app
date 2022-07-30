package BaseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaits 
{
	static WebDriver driver;

	public ExplicitWaits(WebDriver driver)
	{
	     this.driver=driver;	
	}

	public static WebElement WaitForElement(By Locator, Duration i) 
	{
		WebElement WE = null;
		try {
	
	  WebDriverWait wait = new WebDriverWait(driver,i);
	  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	  return element;
		}catch(Exception e) {
			System.out.println("Element not located" +e);
		}
	     return WE;
     }
	
	public WebElement elementToBeClickable(By locator,Duration timeout) {
	try {
	WebDriverWait wait=new WebDriverWait(driver,timeout);
	WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
	return element;
	} catch(Exception e) {
	System.out.println("Element not located" +e);
	}
	return null;
	}
	
	public void Sleep(int time)
	{
		try {
			Thread.sleep(time);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	

}