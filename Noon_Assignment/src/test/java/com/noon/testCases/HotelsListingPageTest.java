package com.noon.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.noon.extentReports.ExtentReportManager;
import com.noon.resourceManager.PageObjectManager;

public class HotelsListingPageTest {

	boolean flag = false;
	
	@Test(priority=1, description = "Verification of Hotel Name")
	 public void verifyHotelNameTest()
	 {
		 
	   ExtentReportManager.extentTest = ExtentReportManager.extentReporter.createTest("verifyHotelNameTest Test Case started");
		 
	   flag = PageObjectManager.getInstance().getHotelsListingPage().verifyHotelsHeading();
	
	   Assert.assertTrue(flag,"Hotel Listing is for different Hotel-Name");
	
	   ExtentReportManager.extentTest.log(Status.INFO, MarkupHelper.createLabel("Hotel Listing is correct", ExtentColor.BLUE));	 
	 
	 }
	
	@Test(priority=2, description = "Verification of Hotel Name")
	 public void sortHotelListingByGuestsRatingTest()
	 {
		 
	   ExtentReportManager.extentTest = ExtentReportManager.extentReporter.createTest("sortHotelListingByGuestsRatingTest Test Case started");
		 
	   PageObjectManager.getInstance().getHotelsListingPage().selectGuestsRatings();
	
	   ExtentReportManager.extentTest.log(Status.INFO, MarkupHelper.createLabel("Successfully sorted the Hotels Listing", ExtentColor.BLUE));	 
	 
	 }
	
	@Test(priority=3, description = "Verification of current SortingOption of Hotel's Listing")
	 public void verifyCurrentHotelsSortingOptionTest()
	 {
		 
	   ExtentReportManager.extentTest = ExtentReportManager.extentReporter.createTest("verifyCurrentHotelsSortingOptionTest Test Case started");
		 
	   flag = PageObjectManager.getInstance().getHotelsListingPage().verifyCurrentSortByOption();
	   
	   Assert.assertTrue(flag, "Current Sorting Option is not 'Guest's Ratings'");
	
	   ExtentReportManager.extentTest.log(Status.INFO, MarkupHelper.createLabel("SortingOption for Hotels Listing is 'Guests Ratings", ExtentColor.BLUE));	 
	 
	 }
	
	
	@Test(priority=4, description = "Test to fetch Hotel Names and Prices")
	 public void fetchHotelNamesAndPricesTest()
	 {
		 
	   ExtentReportManager.extentTest = ExtentReportManager.extentReporter.createTest("fetchHotelNamesAndPricesTest Test Case started");
		 
	   PageObjectManager.getInstance().getHotelsListingPage().fetchHotelNameAndPrice();
	
	   ExtentReportManager.extentTest.log(Status.INFO, MarkupHelper.createLabel("Successfully Hotel Names and Prices", ExtentColor.BLUE));	 
	 
	 }
	

	
}
