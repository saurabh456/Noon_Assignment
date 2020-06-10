package com.noon.resourceManager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

import com.noon.testData.TestConfig;

public class BrowserFactory {

	private static BrowserFactory browserFactory = null;
	private WebDriver driver = null;
	private ChromeOptions options = null;
	
	private BrowserFactory()
	{
		
	}
	public static BrowserFactory getInstance()
	{
		if(browserFactory==null)
			synchronized (BrowserFactory.class) 
			{
				if(browserFactory==null)
					browserFactory = new BrowserFactory();
			}
			
		  return browserFactory;
	}
	
	public WebDriver getDriver()
	{
		if(driver==null)
			driver = createDriver();
			
		return driver;
	}
	
	private WebDriver createDriver()
	{
		
		switch(TestConfig.browserType) 
		{
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver",TestConfig.driverPath);
			
		    ChromeOptions options = new ChromeOptions();    
		    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		    options.setExperimentalOption("useAutomationExtension", false);
		    
		    Map<String, Object> prefs = new HashMap<String, Object>();
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);
		    prefs.put("profile.default_content_setting_values.notifications", 2);

		    options.setExperimentalOption("prefs", prefs);
		    
		    driver = new ChromeDriver(options);
			
			Reporter.log("Chrome Browser launched successfully",true);
			
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", TestConfig.driverPath);
			
			FirefoxOptions option = new FirefoxOptions();
			option.addPreference("dom.webnotifications.enabled", false);
			
			driver = new FirefoxDriver(option);
			Reporter.log("Firefox Browser launched successfully",true);
			break;
			
		default:
			
			System.setProperty("webdriver.chrome.driver",TestConfig.driverPath);
			options = new ChromeOptions();    
		    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		    options.setExperimentalOption("useAutomationExtension", false);
		    
		    driver = new ChromeDriver(options);
		    Reporter.log("Chrome Browser launched successfully in default mode",true);
			
		}
		
		
		  driver.manage().window().maximize(); 
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(TestConfig.pageLoadTimeout,TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(TestConfig.implicitWait,TimeUnit.SECONDS); driver.get(TestConfig.appUrl);

		return driver;
		
	}
	
	public void quitBrowser()
	{
		if(driver!=null)
		{
			driver.quit(); 
			Reporter.log("Browser is now closed", true);
			
		    driver=null;
		   browserFactory=null; 
			
			Reporter.log("Driver is now successfully shut-down", true);
		}
		
	}
}