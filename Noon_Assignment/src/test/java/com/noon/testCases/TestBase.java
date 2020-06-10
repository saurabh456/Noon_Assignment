package com.noon.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.noon.extentReports.ExtentReportManager;
import com.noon.pageObjects.LandingPage;
import com.noon.pageObjects.LoginPage;
import com.noon.resourceManager.BrowserFactory;
import com.noon.resourceManager.PageObjectManager;
import com.noon.testData.TestConfig;
import com.noon.utilities.TestUtilities;

public class TestBase {

	BrowserFactory browserFactory = null;
	WebDriver driver = null;
	
	PageObjectManager pageObjectManager = null;
	LandingPage landingPage = null;
	LoginPage signInPage = null;

	 @BeforeSuite
	public void initilise()
	{
		//driver=BrowserFactory.getInstance().getDriver();
		ExtentReportManager.reportSetup();
	
	} 
	
	 @BeforeTest
	  public void setUp() 
	  {
			driver=BrowserFactory.getInstance().getDriver();
		    driver.get(TestConfig.appUrl);
		 
	  }
	 
	  @AfterMethod
	  public void getResult(ITestResult result)
	  {
		  if(result.getStatus()==ITestResult.SUCCESS)
			  ExtentReportManager.extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" TestCase got Passed", ExtentColor.GREEN)); 
		  
		  else if (result.getStatus()==ITestResult.SKIP)
			  ExtentReportManager.extentTest.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+" TestCase got Skipped", ExtentColor.ORANGE));
		  
		  else if (result.getStatus()==ITestResult.FAILURE)
		  {
			  ExtentReportManager.extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" TestCase got Failed", ExtentColor.RED));
			  
			  ExtentReportManager.extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" TestCase got Failed", ExtentColor.RED));

			  String screenshotDirectoryPath = TestUtilities.captureScreenshot(driver, result.getName());
			  
			  try 
			  {
				ExtentReportManager.extentTest.fail("Snapshot for Failed Test Case as below: "+ExtentReportManager.extentTest.addScreenCaptureFromPath(screenshotDirectoryPath));
			  } 
			  catch (IOException e)
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
	
           }
		  
        }
	  
	  
	  @AfterTest ()
	  public void tearDown1() 
	  {
		 
	  }
	  
	  @AfterSuite(alwaysRun= true)
	  public void tearDown()
	  {
		  ExtentReportManager.reportFlush();
		  pageObjectManager=null;
		  browserFactory.getInstance().quitBrowser();
	  }
	 
	 
}
