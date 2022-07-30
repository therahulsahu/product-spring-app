package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.ExplicitWaits;
import BaseClass.logger;
import BaseClass.screenshots;

public class editProduct {
	
	WebDriver driver;
	ExplicitWaits wait;
	logger log;
	screenshots Screenshot;
	WebElement webElement;

	public editProduct(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		wait = new ExplicitWaits(driver);
		log = new logger(driver);
		Screenshot = new screenshots(driver);
	}
	
	By editlink = By.xpath("//tbody[@role='rowgroup']/tr/td[8]/button");
	By productPrice = By.xpath("//input[@ng-reflect-name='productPrice']");
	By productDesc = By.xpath("//textarea[@ng-reflect-name='productDesc']");
	By updateButton = By.xpath("(//button[@ng-reflect-color='primary'])[2]");
	
	
	public void editproductbutton()
	{

		webElement = wait.elementToBeClickable(editlink,Duration.ofSeconds(10));

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", webElement);
	}
	public void editproductPrice(String editedprice)
	{
		webElement = wait.elementToBeClickable(productPrice,Duration.ofSeconds(20));
		webElement.clear();
		webElement.sendKeys(editedprice);
	}
	public void editproductDescription(String editeddescription)
	{
		webElement = wait.elementToBeClickable(productDesc,Duration.ofSeconds(20));
		webElement.clear();
		webElement.sendKeys(editeddescription);
	}
	public void update()
	{
		webElement = wait.elementToBeClickable(updateButton,Duration.ofSeconds(10));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", webElement);
	}
	
	
	

}
