package com.learnautomation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.learnautomation.Pages.BaseClass;

public class BrowserFactory extends BaseClass {
	
	
	public static WebDriver startApp(String browserName,String appURL) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
			
		}
		else if (browserName.equalsIgnoreCase("internet")) {
			driver=new InternetExplorerDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
		}
		else {
			System.out.println("sorry we dont support this browser");
		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitbrowser() {
		driver.quit();
		
	}

}
