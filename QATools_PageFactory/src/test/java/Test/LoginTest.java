package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProfilePage;

public class LoginTest {
	
	@Test
	public void logintest() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/login");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		ProfilePage profile=PageFactory.initElements(driver, ProfilePage.class);
		login.loginaction();
		profile.testText();
		profile.logout();
		driver.quit();
	}

}
