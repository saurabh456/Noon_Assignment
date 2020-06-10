package com.noon.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Wait;

import com.noon.resourceManager.PageObjectManager;

public class TestUtilities {

	static SimpleDateFormat dateFormat = null;
	
	public static String getFormattedDate()
	{
		dateFormat = new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss");
		
		return dateFormat.format(new Date());
	}
	
	public static String captureScreenshot(WebDriver driver, String testCaseName)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String formattedCurrentDate = getFormattedDate();
		
		//String screenshotName = testCaseName+"_"+formattedCurrentDate;
		String screenshotTargetDirectory = System.getProperty("user.dir")+"/Screenshots/"+testCaseName+"_"+"Fail"+"_"+formattedCurrentDate+".png";
		
		try 
		{
			FileHandler.copy(src, new File(screenshotTargetDirectory));
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return screenshotTargetDirectory;
	}

	
	
	
}
