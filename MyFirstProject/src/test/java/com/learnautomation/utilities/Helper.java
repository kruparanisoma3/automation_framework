package com.learnautomation.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.learnautomation.Pages.BaseClass;

public class Helper extends BaseClass{
	
	public static String TakeScreenshot() {
		TakesScreenshot take=(TakesScreenshot)driver;
		File src=take.getScreenshotAs(OutputType.FILE);
		String filename=Datehandle()+".png";
		File dest=new File(System.getProperty("user.dir")+"\\Screenshots\\"+filename);
		try {
			FileUtils.copyFile(src,dest );
			System.out.println("screenshot captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("unable to take picture:"+e.getMessage());
		}
		return filename;
		
			
			
	}
	
	public static String Datehandle() {
		Date date=new Date();
		return date.toString().replace(":", "-").replace(" ", "-");
	}

}
