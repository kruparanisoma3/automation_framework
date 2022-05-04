package com.learnautomation.Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExceLProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {
	public static WebDriver driver;
	public static ExceLProvider excel;
	public ConfigDataProvider config;
	public ExtentSparkReporter report;
	public ExtentTest test;
	public ExtentReports reports;
	
	@BeforeSuite
	public void setUPExcel() {
		Reporter.log("this is before suite",true);
		 excel=new ExceLProvider();
		 config=new ConfigDataProvider();
		 report=new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\"+Helper.Datehandle()+".html");
		  reports=new ExtentReports();
		 reports.attachReporter(report);
		 reports.setSystemInfo("OS", "windows");
		 reports.setSystemInfo("build number", "100.10.45");
		 reports.setSystemInfo("browser", "chrome");
		 Reporter.log("this is comleted suite",true);
	}
	
	
	@BeforeClass
	public void setUp() {
		Reporter.log("this is starting of before class",true);
		BrowserFactory.startApp( config.getBrowser(), config.getStagingURL());
		Reporter.log("this is after of before class",true);

		
	}
	@AfterClass
	public void tearDown() {
		
		// closing the browse
		Reporter.log("this is starting of after class",true);
		BrowserFactory.quitbrowser();
		Reporter.log("this is after of after class",true);
		
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		Reporter.log("this is starting of after method",true);
		
		if(result.getStatus()==ITestResult.FAILURE) {
			//Helper.TakeScreenshot();
			//String filename=System.getProperty("user.dir")+"\\Screenshots\\"+Helper.Datehandle()+".png";
		//	test.fail("fail testcase");
		//	test.addScreenCaptureFromPath(filename);
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(Helper.TakeScreenshot()).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(Helper.TakeScreenshot()).build());

			
		}
		reports.flush();
		Reporter.log("this is after of after method",true);
	}
	
	

}
