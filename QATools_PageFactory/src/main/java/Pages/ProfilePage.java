package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProfilePage {
	WebDriver driver;
	
	public ProfilePage(WebDriver driver){
		 this.driver=driver;
		 
	 }
	 
	 @FindBy(xpath="//label[@id='userName-value']")
	 WebElement uservalue;
	 
	 @FindBy(xpath="//div[@class='text-right col-md-5 col-sm-12']/button[@id='submit']")
	 WebElement btn;
	 
	 
	 public void testText() {
		 String expected=uservalue.getText();
		 Assert.assertEquals("kruparanisoma", expected);
	 }
	 
	 public void logout() {
		 btn.click();
	 }
	 
	 
	
	

}
