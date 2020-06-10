package com.noon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noon.testData.TestConfig;
import com.noon.utilities.Waits;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class='loginCard__changeLogin']")
	private WebElement clickHereLink;
	
	@FindBy(css="[label='Enter Phone Number']")
	private WebElement enterPhoneNumberInputBox;
	
	@FindBy(xpath="//*[contains(text(),'Password')]/following-sibling::*[@type='password']")
	private WebElement passwordInputBox;
	
	@FindBy(xpath="//*[contains(text(),'Password')]/parent::div/following-sibling::button[contains(text(),'Verify Number')]")
	private WebElement verifyNumberButton;
	

		public void clickOnClickHereLink()
		{
			Waits.PageLoadStatus(driver);
			
			clickHereLink.click();
			
			System.out.println("Successfully clicked the 'Click Here' link");
			
		}
		
		public HomePage loginToPortal()
		{
			Waits.setExplicitWait(3);
			
			enterPhoneNumberInputBox.sendKeys(TestConfig.mobileNumber);
			passwordInputBox.sendKeys(TestConfig.password);
			
			Waits.setExplicitWait(2);
			verifyNumberButton.click();
			
			System.out.println("Successfully clicked the 'Verify-Number' button");
			
			Waits.setExplicitWait(5);
			
			return new HomePage(driver);
			
			
			
		}

}
