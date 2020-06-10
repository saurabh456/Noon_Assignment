package com.noon.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.noon.extentReports.ExtentReportManager;
import com.noon.pageObjects.LandingPage;
import com.noon.pageObjects.LoginPage;
import com.noon.resourceManager.BrowserFactory;
import com.noon.resourceManager.PageObjectManager;
import com.noon.utilities.TestUtilities;
import com.noon.pageObjects.LoginPage;

public class LandingPageTest {
	
	LoginPage loginPage = null;
	
	BrowserFactory browserFactory = null;
	WebDriver driver = null;
	
	PageObjectManager pageObjectManager = null;
	LandingPage landingPage = null;
	 
	 @Test(priority=0, description = "Clicking on Login Link Test")
	 public void clickSignInLinkTest()
	 {
		 
	   ExtentReportManager.extentTest = ExtentReportManager.extentReporter.createTest("clickLoginLinkTest Test Case started");
		 
	   //PageObjectManager.getInstance().getLandingPage().launchAppUrl();
	   loginPage =  PageObjectManager.getInstance().getLandingPage().clickOnLoginLink();
	
	   
	   if(loginPage !=null)
		   ExtentReportManager.extentTest.log(Status.INFO, MarkupHelper.createLabel("Successfully clicked the SignInPage and Page starts Loading", ExtentColor.BLUE));	 
	 
	 }
	  

}
