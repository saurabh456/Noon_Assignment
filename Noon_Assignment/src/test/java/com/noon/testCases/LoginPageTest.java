package com.noon.testCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.noon.extentReports.ExtentReportManager;
import com.noon.pageObjects.HomePage;
import com.noon.pageObjects.LoginPage;
import com.noon.resourceManager.PageObjectManager;
import com.noon.pageObjects.LoginPage;

public class LoginPageTest
{

	LoginPage loginPage = null;
	HomePage homePage = null;
	
	@Test(priority=1, description = "TestCase to perform Login into Portal")
	public void performSignInTest()
	{
		ExtentReportManager.extentTest =ExtentReportManager.extentReporter.createTest("performSignInTest TestCase Execution Started");
		
		PageObjectManager.getInstance().getLoginPage().clickOnClickHereLink();
		
		homePage = PageObjectManager.getInstance().getLoginPage().loginToPortal();
		
		Assert.assertNotNull(homePage,"HomePage Object is null");
		
		ExtentReportManager.extentTest.log(Status.INFO, MarkupHelper.createLabel("Successfully clicked VerifyNumber button to login", ExtentColor.BLUE));
		
	}
	
}
