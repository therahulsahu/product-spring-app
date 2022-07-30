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

public class showProducts {
	
	WebDriver driver;
	ExplicitWaits wait;
	logger log;
	screenshots Screenshot;
	WebElement webElement;

	public showProducts(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		wait = new ExplicitWaits(driver);
		log = new logger(driver);
		Screenshot = new screenshots(driver);
		
	}
	By showproductButton = By.xpath("(//span[@class='mat-button-wrapper'])[3]");
	By searchButton = By.xpath("//input[@data-placeholder='Search...']");
	
	
	public void showProduct()
	{
		webElement = wait.elementToBeClickable(showproductButton, Duration.ofSeconds(10));
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", webElement);
	}
	public void searchTextbox()
	{
		webElement = wait.elementToBeClickable(searchButton, Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", webElement);
		jse.executeScript("arguments[0].value='realme'",webElement);
		webElement.sendKeys(Keys.ENTER);
		
	}
	public void searchTextboxclear()
	{
		webElement = wait.elementToBeClickable(searchButton, Duration.ofSeconds(10));		
		webElement.clear();
		JavascriptExecutor jse = (JavascriptExecutor)driver;	
		jse.executeScript("arguments[0].value='opp'",webElement);
		webElement.sendKeys(Keys.ENTER);
		
	}
			

}
