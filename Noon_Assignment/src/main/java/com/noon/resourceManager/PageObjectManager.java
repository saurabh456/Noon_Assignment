package com.noon.resourceManager;

import org.openqa.selenium.WebDriver;

import com.noon.pageObjects.LandingPage;
import com.noon.pageObjects.LoginPage;
import com.noon.pageObjects.HomePage;
import com.noon.pageObjects.HotelsListingPage;

public class PageObjectManager {
	
	WebDriver driver = null;
	
	private static PageObjectManager pageObjectManager = null;
	
	LandingPage landingPage = null;
	LoginPage   loginPage = null;
	HomePage    homePage = null;
	HotelsListingPage hotelsListingPage = null;
	
	
	private PageObjectManager()
	{
		driver = BrowserFactory.getInstance().getDriver();
	}
	
	public static PageObjectManager getInstance()
	{
		if(pageObjectManager==null)
			pageObjectManager = new PageObjectManager();
		
		return pageObjectManager;
			
	}
	
	public LandingPage getLandingPage()
	{
		if(landingPage == null)
			landingPage = new LandingPage(driver);
		
		return landingPage;
	}
	
	public LoginPage getLoginPage()
	{
		if(loginPage == null)
			loginPage = new LoginPage(driver);
		
		return loginPage;
	}
	
	public HomePage getHomePage()
	{
		if(homePage == null)
			homePage = new HomePage(driver);
		
		return homePage;
	}

	public HotelsListingPage getHotelsListingPage()
	{
		if(hotelsListingPage == null)
			hotelsListingPage = new HotelsListingPage(driver);
		
		return hotelsListingPage;
	}
}
