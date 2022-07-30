package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import BaseClass.ExplicitWaits;
import BaseClass.logger;
import BaseClass.screenshots;

public class reportsGeneration {
	
	WebDriver driver;
	ExplicitWaits wait;
	logger log;
	screenshots Screenshot;
	WebElement webElement;
	WebElement webElement1;

	public reportsGeneration(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new ExplicitWaits(driver);
		log = new logger(driver);
		Screenshot = new screenshots(driver);
	}
	
	By reportgenerationlink  = By.xpath("//button[@class='Generate']/mat-icon");
	
    By dropdown              = By.xpath("/html/body/app-root/app-report/mat-sidenav-container/mat-sidenav-content/mat-form-field/div/div[1]/div/select");	

    By downloadbutton        = By.xpath("//input[@value='Download']");
	
	public void Reportlink ()
	{
		   webElement = wait.elementToBeClickable(reportgenerationlink,Duration.ofSeconds(10));
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", webElement);
 
	}
	public void reportbutton()
	
	{
		webElement = wait.elementToBeClickable(dropdown, Duration.ofSeconds(10));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].click()", webElement);
		Actions action = new Actions(driver);
		action.clickAndHold(webElement).build().perform();
		
		Select select = new Select(webElement);
	
		select.selectByValue("1");
		webElement.sendKeys(Keys.ENTER);
		action.click().build().perform();
		action.release().build().perform();
				
	}
	public void downloadButton ()
	{
		webElement = wait.elementToBeClickable(downloadbutton,Duration.ofSeconds(10));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", webElement);
 
	}
	

}
