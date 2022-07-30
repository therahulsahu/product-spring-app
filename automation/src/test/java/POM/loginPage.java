package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.ExplicitWaits;
import BaseClass.logger;
import BaseClass.screenshots;

public class loginPage {

	WebDriver driver;
	ExplicitWaits wait;
	logger log;
	screenshots Screenshot;
	WebElement webElement;
	
	public loginPage (WebDriver driver)
	{
		this.driver = driver;
		wait = new ExplicitWaits(driver);
		log = new logger(driver);
		Screenshot = new screenshots(driver);
		
	}
	
	By username    = By.xpath("//input[@id ='userName']");
	By Password    = By.xpath("//input[@type ='password']");
	By loginButton = By.xpath("//span[@class ='mat-button-wrapper']");
	By addProduct  = By.xpath("(//span[@class='mat-button-wrapper'])[2]");
	
	
	public void enter_username(String userName)
	{
		webElement = wait.WaitForElement(username,Duration.ofSeconds(20));
		webElement.sendKeys(userName);		
		
	}
	
	public void enter_password(String pwd)
	{
		
		webElement = wait.WaitForElement(Password,Duration.ofSeconds(20));
		webElement.sendKeys(pwd);	
	}
	
	public void click_login_button()
	{
		webElement = wait.elementToBeClickable(loginButton, Duration.ofSeconds(20));
		webElement.click();
		log.Update_log("browser opened");
		
	}
	
	public void click_addProduct()
	{
		webElement = wait.elementToBeClickable(addProduct, Duration.ofSeconds(20));
		webElement.click();
		
	}

	
	
	
	
}
