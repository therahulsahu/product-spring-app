package POM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.channels.InterruptedByTimeoutException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseClass.ExplicitWaits;
import BaseClass.logger;
import BaseClass.screenshots;

public class addProducts {
	
	WebDriver driver;
	ExplicitWaits wait;
	logger log;
	screenshots Screenshot;
	WebElement webElement;
	WebElement webElement1;
	 public int count =0;
	
	public addProducts (WebDriver driver)
	{
		this.driver = driver;
		wait = new ExplicitWaits(driver);
		log = new logger(driver);
		Screenshot = new screenshots(driver);		
	}
	
	By productId    = By.xpath("//input[@name='productId']");
	//By productId = By.xpath("/html/body/app-root/add/mat-sidenav-container/mat-sidenav-content/form/input[1]");
	By productName  = By.xpath("//input[@name='productName']");
	By productDesc  = By.xpath("/html/body/app-root/add/mat-sidenav-container/mat-sidenav-content/form/mat-form-field[4]/div/div[1]/div/textarea");
	By productPrice = By.xpath("//input[@ng-reflect-name='productPrice']");
    By calendarIcon = By.xpath("//*[name()='path' and contains(@d,'M19 3h-1V1')]");
    By monthText    = By.xpath("(//button[@type='button'])[2]");
    By forwardarrow = By.xpath("//button[@aria-label='Next month']");
    By datetable    = By.xpath("//tbody/tr[4]/td[3]");
    By productType = By.xpath("(//input[@type='radio'])[2]");
    By quantity     = By.xpath("//input[@ng-reflect-name='productQuantity']");
    By productUpload= By.xpath("//input[@type='file']");
    By submit       = By.xpath("(//span[@class='mat-button-wrapper'])[7]");
    By addbutton    = By.xpath("/html/body/app-root/product/mat-sidenav-container/mat-sidenav-content/div[1]/button");
    
        
    public void setproductId(String ID)
    {
    	webElement = wait.WaitForElement(productId,Duration.ofSeconds(20));
    	webElement.click();
		webElement.sendKeys(ID);
    }
    
    public void setproductName (String Name)
    {
    	webElement = wait.elementToBeClickable(productName,Duration.ofSeconds(10));
		webElement.sendKeys(Name);
    }
    public void setPrice(String Price)
	{
		webElement = wait.elementToBeClickable(productPrice,Duration.ofSeconds(20));
		webElement.sendKeys(Price);
    }
	
	 public void setdescription (String Description)
	 {
	    	webElement = wait.elementToBeClickable(productDesc,Duration.ofSeconds(10));
			webElement.sendKeys(Description);
	 }

	 public void calendar () throws InterruptedException
	 {
		    String month = "AUG 2022";
		    String day   = "16";
	    	webElement = wait.elementToBeClickable(calendarIcon,Duration.ofSeconds(10));
	    	webElement.click();
	    	Thread.sleep(1000);
	    	while(true)
	    	{
	    		webElement = wait.elementToBeClickable(monthText, Duration.ofSeconds(10));
		    	String text = webElement.getText();
		    	if(text.equals(month))
		    	{
		    		break;
		    	}
		    	else
		    	{
		    		webElement = wait.elementToBeClickable(forwardarrow, Duration.ofSeconds(10));
		    		webElement.click();
		    	}
		    	
	    	}
	      webElement = wait.elementToBeClickable(datetable,Duration.ofSeconds(10));
	      webElement.click();
	    	
	    	
	 }
	
	public boolean	setDeviceType()
	{
		 boolean result = false;
		    int attempts = 0;
		    while(attempts < 2) {
		        try {
		            webElement = wait.elementToBeClickable(productType, Duration.ofSeconds(20));
		            JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click()", webElement);
		            result = true;
		            break;
		        } catch(StaleElementReferenceException e) {
		        }
		        attempts++;
		    }
		    return result;
    }
	
	
	public void productQuantity(String Quantity)
	{
		//Actions actions = new Actions(driver);
		//actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		webElement = wait.elementToBeClickable(quantity,Duration.ofSeconds(10));
		webElement.sendKeys(Quantity);
	}
	
	public void productfileupload()
	{
		webElement = wait.elementToBeClickable(productUpload,Duration.ofSeconds(10));
		File file = new File("src/test/resources/testdata/sample.pdf");			
		webElement.sendKeys(file.getAbsolutePath());
		        
    }
	public String uploadedfilename()
	{
		webElement = wait.elementToBeClickable(productUpload,Duration.ofSeconds(20));
		return webElement.getText();
		        
    }
     	
	public void submitButton() throws InterruptedException
	{
		
		webElement = wait.elementToBeClickable(submit,Duration.ofSeconds(20));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", webElement);
        count++;
	}
	public void addProductButton()
	{

		webElement = wait.elementToBeClickable(addbutton,Duration.ofSeconds(20));

        webElement.sendKeys(Keys.ENTER);       
        
	}
		
	}
    
