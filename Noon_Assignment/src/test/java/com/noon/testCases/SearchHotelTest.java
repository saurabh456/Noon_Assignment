package com.noon.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.noon.extentReports.ExtentReportManager;
import com.noon.pageObjects.HotelsListingPage;
import com.noon.pageObjects.LandingPage;
import com.noon.pageObjects.LoginPage;
import com.noon.resourceManager.BrowserFactory;
import com.noon.resourceManager.PageObjectManager;
import com.noon.utilities.TestUtilities;
import com.noon.pageObjects.LoginPage;

public class SearchHotelTest {
	
	HotelsListingPage hotelsListingPage = null;
	
	BrowserFactory browserFactory = null;
	WebDriver driver = null;
	
	PageObjectManager pageObjectManager = null;
	LandingPage landingPage = null;
	 
	 @Test(priority=0, description = "Test to Search the Desired Hotel")
	 public void searchHotelTest()
	 {
		 
	   ExtentReportManager.extentTest = ExtentReportManager.extentReporter.createTest("searchHotelTest Test Case started");
		 
	  // PageObjectManager.getInstance().getLandingPage().launchAppUrl();
	   
	   PageObjectManager.getInstance().getLandingPage().enterHotelName();
	   
	   hotelsListingPage  = PageObjectManager.getInstance().getLandingPage().clickSearchButton();
	
	   
	   Assert.assertNotNull(hotelsListingPage, "HotelsListing Page fails to load");
		   ExtentReportManager.extentTest.log(Status.INFO, MarkupHelper.createLabel("Successfully clicked Search Button and HotelsListingPage starts Loading", ExtentColor.BLUE));	 
	 
	 }

}
