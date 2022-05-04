package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.Pages.BaseClass;
import com.learnautomation.Pages.LoginPage;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ExceLProvider;
import com.learnautomation.utilities.Helper;

public class LoginTestCRM extends BaseClass{
	
	
	

	
	@Test
	public void loginApp() {
		
		test=reports.createTest("Testing automation-Rediff.com");
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		test.info("Starting application");
		login.loginToCRM(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));
		test.pass("successfully executed");
		
		
	}

}
