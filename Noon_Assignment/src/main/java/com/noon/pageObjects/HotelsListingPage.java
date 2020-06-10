package com.noon.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noon.testData.SharedProperties;
import com.noon.testData.TestConfig;
import com.noon.utilities.Waits;

public class HotelsListingPage {

	WebDriver driver;
	
	public HotelsListingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='listing__contentWrapper']//*[@class='ListingContentHeader__h1']")
	private WebElement hotelListingHeader;

	@FindBy(xpath="//*[contains(text(),'Sort By')]/following-sibling::*[@class='dropdown__select']")
	private WebElement sortByDropdown;

	@FindBy(xpath="//*[contains(text(),'Sort By')]/following-sibling::*[@class='dropdown__select']//*[contains(text(),'Guest Ratings')]")
	private WebElement guestRatingsDropdownOption;
	
	@FindBy(xpath="//*[@class='oyo-row oyo-row--no-spacing ListingHotelCardWrapper']/div")
	private List<WebElement> totalHotels;

	@FindBy(xpath="//*[@class='oyo-row oyo-row--no-spacing ListingHotelCardWrapper']/div//*[@class='listingPrice__finalPrice']")
	private List<WebElement> hotelsPrice;
	
	public boolean verifyHotelsHeading()
	{
		Waits.PageLoadStatus(driver);
		
		boolean flag = false;
		
		if(hotelListingHeader.getText().trim().contains(SharedProperties.selectedHotelName))
		{
			System.out.println("Hotel Listing is correct");
			flag = true;
		}
		else
			System.out.println("Hotel Listing is for differnt location");
		
		  return flag;	  
	}
	
	public void selectGuestsRatings()
	{
		sortByDropdown.click();
		
		Waits.setExplicitWait(2);
		guestRatingsDropdownOption.click();
		
		Waits.PageLoadStatus(driver);
		
	}
	
		public boolean verifyCurrentSortByOption()
		{
			boolean flag = false;
			
			if(sortByDropdown.getText().trim().equalsIgnoreCase(TestConfig.sortByDropdownValue.trim()))
			 {
				System.out.println("Current Sorting value is 'Guests Rating'");
				flag = true;
			 }
			
			return flag;
		}
		
		public void fetchHotelNameAndPrice()
		{
			//*[@class='oyo-row oyo-row--no-spacing ListingHotelCardWrapper']/div[5]//*[@class='listingPrice__finalPrice']
			
			String initialXpath="//*[@class='oyo-row oyo-row--no-spacing ListingHotelCardWrapper']/div[";
			
			String priceXpath="]//*[@class='listingPrice__finalPrice']";
			
			String nameXpath="]//*[@itemprop='name']";
			
			for(int i=1;i<=totalHotels.size();)
			{
			if(i==9)
				break;
			else
			{
				String completeHotelNameXpath=initialXpath+String.valueOf(i)+nameXpath;
				String completeHotelPriceXpath=initialXpath+String.valueOf(i)+priceXpath;
				
				System.out.println("Hotel Name is: "+driver.findElement(By.xpath(completeHotelNameXpath)).getText());
				
				System.out.println("Hotel Price is: "+driver.findElement(By.xpath(completeHotelPriceXpath)).getText().trim().substring(1));
			}
				i=i+2;

			}
		
		}
}
