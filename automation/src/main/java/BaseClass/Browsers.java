package BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers {
	
	public WebDriver driver;
	screenshots screenshot;
	logger log;
	
	@SuppressWarnings("deprecation")
	public WebDriver browserSetup(String browser,String url)
	{
		
		switch (browser.toLowerCase())
				 {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
			chromeOptions.addArguments("enable-automation");
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);			
			driver= new ChromeDriver(chromeOptions);
			break;
			
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
				firefoxOptions.addArguments("enable-automation");
				firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
				driver = new FirefoxDriver(firefoxOptions);
				break;		
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		log = new logger(driver);
		log.Update_log("browser opened");
		return driver;		
		
	}
	
	public void tearDown() {
		driver.quit();

}
}