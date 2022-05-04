package com.learnautomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {
	
	
	public LoginPage(WebDriver ldriver) {
		BaseClass.driver=ldriver;
		
	}
	
	@FindBy(xpath="//input[@name='email-id']") WebElement uname;
	@FindBy(xpath="//input[@name='passwd']") WebElement password;
	@FindBy(xpath="//input[@id='loginsubmit']") WebElement loginbutton;
	
	
	public void loginToCRM(String username,String pwd) {
		uname.sendKeys(username);
		password.sendKeys(pwd);
		loginbutton.click();
	}
	


}
