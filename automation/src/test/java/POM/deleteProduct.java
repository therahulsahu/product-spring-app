package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.ExplicitWaits;
import BaseClass.logger;
import BaseClass.screenshots;

public class deleteProduct 
{
	
	WebDriver driver;
	ExplicitWaits wait;
	logger log;
	screenshots Screenshot;
	WebElement webElement;
	
	public deleteProduct(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new ExplicitWaits(driver);
		log = new logger(driver);
		Screenshot = new screenshots(driver);		
		
	}
	  
	  
	 By deleteButton = By.xpath("//button[@class='mat-focus-indicator del mat-icon-button mat-button-base mat-warn']");
	 By checkBox     = By.xpath("//tbody[@role='rowgroup']/tr[1]/td[1]/mat-checkbox/label/span[1]/input");
	 
	
	  public void productcheckBox()
	  {
		  webElement = wait.elementToBeClickable(checkBox, Duration.ofSeconds(30));
		  String checkBoxstatus = webElement.getAttribute("aria-checked");
		  System.out.println("checkboxstatus is " + checkBoxstatus );
	  
	       if(checkBoxstatus.equals("false"))
	      {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", webElement);
	      }
	  //checkBoxstatus= webElement.getAttribute("aria-checked");
	
	   }
		 
	  public void productdeleteButton()
	  {
		  webElement = wait.elementToBeClickable(deleteButton, Duration.ofSeconds(50));
		  
		  if(webElement.isDisplayed())
		  {
			     JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()", webElement);
		  }
		  else
		  {
			  System.out.println("Delete button is not present");
		  }
	  }

}
