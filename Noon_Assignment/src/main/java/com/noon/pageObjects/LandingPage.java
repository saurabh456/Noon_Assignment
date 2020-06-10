package com.noon.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noon.testData.SharedProperties;
import com.noon.testData.TestConfig;
import com.noon.utilities.Waits;

public class LandingPage {

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class*='homePage__container'] [class='sideMenuAuthButton__text']")
	private WebElement loginLink;
	
	@FindBy(css="[class='searchContainer__searchWidgetContainer'] [id='autoComplete__home']")
	private WebElement searchHotelTextBox;
	
    @FindBy(css="[class='d-popup geoSuggestionsList']>div>div:nth-of-type(2)")
    private WebElement secondHotelSuggestion;
    
    @FindBy(css="[class='d-popup geoSuggestionsList']>div>div:nth-of-type(2) [class*='geoSuggestionsList__locationName']")
    private WebElement secondHotelSuggestionText;
    
    @FindBy(xpath="//*[@class='d-popup geoSuggestionsList']/div/div[2]")
    private WebElement secondSuggestion;

	@FindBy(xpath="//*[@class='searchContainer__searchWidgetContainer']//*[contains(text(),'Search')]")
	private WebElement serachButton;
	
	@FindBy(xpath="//*[@class='c-1f05qwp']")
	private WebElement subscribeToNotificationsPopup;
	
	@FindBy(xpath="//*[@class='c-1f05qwp']//button[1]")
	private WebElement skipNotifButton;
	
	@FindBy(xpath="//*[contains(text(),'Log in now to unlock exclusive deals')]/parent::div//*[@id='close-icon']")
	private WebElement logininNowRibbon;
	
	
	public LoginPage clickOnLoginLink()
	{
		logininNowRibbon.click();
		
		loginLink.click();
		
		return new LoginPage(driver);
	}
	
	public void enterHotelName()
	{
		searchHotelTextBox.sendKeys(TestConfig.inputHotelName);
		
		Waits.setExplicitWait(3);
		
		if(secondHotelSuggestion.isDisplayed())
		{
			SharedProperties.selectedHotelName=secondHotelSuggestionText.getText().trim();
			
			secondHotelSuggestion.click();
		    System.out.println("Successfully selected Suggested hotel");
		}
		else
			System.out.println("Hotel Suggestions fails to load");
		
	}
	
	public HotelsListingPage clickSearchButton()
	{
		System.out.println("in the SearchButton method");
		if(subscribeToNotificationsPopup.isDisplayed())
		{
			System.out.println("Notification Popup is displays on the page");
			skipNotifButton.click();
		}
		else
			System.out.println("Notification popup is not displays on the screen");
		
		//Actions act = new Actions(driver);
		//act.moveToElement(serachButton).click().build();
		
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();", serachButton);
		
		serachButton.click();
		
		System.out.println("Successfully clicked the Search button to search the hotel");
		
		return new HotelsListingPage(driver);
	}
	
}
