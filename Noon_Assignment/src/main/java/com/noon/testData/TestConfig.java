package com.noon.testData;

public interface TestConfig {
	
	String mobileNumber = "8588800690";
	String password= "Anmkl@890";
	
	String appUrl = "https://www.oyorooms.com/";
	
	String browserType = "chrome";
	String driverPath = "./Drivers/chromedriver.exe";
	
	// ./Drivers/geckodriver.exe
	String inputHotelName = "Sikanderpur, Gurugram";
	
	long pageLoadTimeout = 60;
	long implicitWait    =30;
	
	String testReportPath = "./TestReports";
	
	String sortByDropdownValue = "Guest Ratings";
	
}
