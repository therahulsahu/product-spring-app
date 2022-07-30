package TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.Browsers;
import BaseClass.logger;
import BaseClass.screenshots;
import ExcelDataUtils.ReadExcel;
import POM.addProducts;
import POM.deleteProduct;
import POM.editProduct;
import POM.homepage;
import POM.loginPage;
import POM.reportsGeneration;
import POM.showProducts;

public class testng {
	 
	WebDriver driver;
	Browsers browser;
	loginPage login;
	addProducts addproduct;
	ReadExcel readExcel;
	int count=0;
	showProducts showproduct;
	deleteProduct deleteproduct;
	editProduct editproduct;
	reportsGeneration reportgeneration;
	homepage homePage;
	screenshots Screenshot;
	Logger log = Logger.getLogger(testng.class);

	@BeforeClass
	public void beforeMethod()
	
	{   	   
		    browser = new Browsers();
		    driver  = browser.browserSetup("chrome", "http://localhost:4200/");	
		    login   = new loginPage(driver);
		    Screenshot = new screenshots(driver);
			Screenshot.takeScreenshot("loginpage.jpg");
		    login.enter_username("abc");
		    log.info("entered username");
		    login.enter_password("abc");
		    log.info("entered password");
		    login.click_login_button();
		    log.info("loginpage successful");			   
		    String title = driver.getTitle();
		    System.out.println("Title is " + title);
		    Assert.assertEquals("Newlist", title);
		    Screenshot = new screenshots (driver);
		    Screenshot.takeScreenshot("dashboard.jpg");
		    addproduct = new addProducts(driver);
		    login.click_addProduct();
		    			    
	}
		
		
	@Test(dataProvider="excel_data")
	public void TestCase1(String ID,String Name, String Description,String Quantity,String Price) throws InterruptedException {
	    
		addproduct = new addProducts(driver);
		
	    if(count>=1)
	    {
	    	addproduct.addProductButton();
	    
	    }
	        addproduct.setproductId(ID);
	        addproduct.setproductName(Name);
	        addproduct.setPrice(Price);
	        addproduct.setdescription(Description);
	        addproduct.calendar();
	        addproduct.productQuantity(Quantity);
	        addproduct.setDeviceType();
	        Actions actions = new Actions(driver);
	     	actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();		 
			Thread.sleep(4000);			  	
			addproduct.productfileupload();
			Thread.sleep(1000);
			addproduct.submitButton();
		    count++;
		    
		    //System.out.println("count is " + ap.count);	        	       
		    
	    }	
	@AfterClass
	public void testcase1() throws InterruptedException
	{  
		addproduct = new addProducts(driver);
		showproduct = new showProducts(driver);
		deleteproduct = new deleteProduct(driver);
		homePage = new homepage(driver);
		editproduct = new editProduct(driver);
		reportgeneration = new reportsGeneration(driver);
		homePage.clickhomepage();		
		Screenshot = new screenshots (driver);
		Screenshot.takeScreenshot("homePage1.jpg");
		showproduct.showProduct();	
		Thread.sleep(1000);	
		Screenshot = new screenshots (driver);
		Screenshot.takeScreenshot("showProduct.jpg");
		showproduct.searchTextbox();		
		editproduct.editproductbutton();
		Thread.sleep(1000);
		Screenshot = new screenshots (driver);
		Screenshot.takeScreenshot("editProducts.jpg");
		editproduct.editproductPrice("20000");
		editproduct.editproductDescription("250 GB Storage");
		Actions actions = new Actions(driver);
    	actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
    	editproduct.update();
    	Thread.sleep(1000);
    	Screenshot = new screenshots (driver);
   		Screenshot.takeScreenshot("showProductPostUpdating.jpg");
        showproduct.searchTextboxclear();
    	Thread.sleep(1000);
    	deleteproduct.productcheckBox();
    	Thread.sleep(1000);		
    	deleteproduct.productdeleteButton();
        Screenshot = new screenshots (driver);
        Screenshot.takeScreenshot("showProductPostDeleting.jpg");
    	reportgeneration.Reportlink();            
    	Thread.sleep(10000);
    	Screenshot = new screenshots (driver);
    	Screenshot.takeScreenshot("reportGenerationPage.jpg");    		
    	reportgeneration.reportbutton();
    	reportgeneration.downloadButton();
    	Thread.sleep(1000);
    	Screenshot = new screenshots (driver);
    	Screenshot.takeScreenshot("reportGenerationPostGeneratingReport.jpg");
    	homePage.clickhomepage();
    	driver.close();
		
	}
	
	@DataProvider
	public String[][] excel_data()
	{
		readExcel = new ReadExcel();
		readExcel.get_data("products",3,5);
		return readExcel.testdata;
		
	}
	
		
}
