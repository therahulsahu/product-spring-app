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

public class homepage 
{
	WebDriver driver;
	ExplicitWaits wait;
	logger log;
	screenshots Screenshot;
	WebElement webElement;
	public homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new ExplicitWaits(driver);
		log = new logger(driver);
		Screenshot = new screenshots(driver);
	}
	
	By Homepagelink = By.xpath("//ul[@class='nav_links']/li[1]/a");
	By Homepage  = By.xpath("//a[@routerlink='/dashboard']/mat-icon");
	By note      = By.xpath("//h1[normalize-space()='Welcome To Product Catalog']");
    
    
    public void clickhomepage()
	{

		webElement = wait.elementToBeClickable(Homepage,Duration.ofSeconds(10));
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", webElement);
      
	}
    public String homePagenote()
    {
    	webElement = wait.WaitForElement(note, Duration.ofSeconds(10));
    	String note = webElement.getText();
    	return note;
    }
	
    
}
