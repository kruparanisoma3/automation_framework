package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(xpath="//input[@id='userName']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement pwd;
	
	@FindBy(xpath="//button[@id='login']")
	WebElement btn;
	
	public void loginaction() {
		username.sendKeys("kruparanisoma");
		pwd.sendKeys("Krupa@21");
		btn.click();
		
	}

}
