package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_001_LoginPage extends BaseClass{
	
	
	@Test(priority=1)
	public void verifyLoginWithvaliddata()
	{
		
		LoginPage login=new LoginPage(driver);
		login.username("bestbeach");
		login.Clicknext();
		login.password("Winter-house2021");
		login.Clicklogin();

		Assert.assertTrue(driver.findElement(By.xpath("//h4[@class='mb-3 mb-md-0']")).isDisplayed());
		
	}
	
	
	
	@Test(priority=2)
	public void verifyLoginWithInvalidemail()
	{
		
		LoginPage login=new LoginPage(driver);
		login.username("smruti");
		login.Clicknext();
		login.password("Winter-house2021");
		login.Clicklogin();

		String actualEmailWarning = driver.findElement(By.xpath("//div[@class='toast toast-error']/child::div"))
				.getText();
	
		Assert.assertEquals(actualEmailWarning, "Incorrect Email/Username or Password");
		
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidpassword()
	{
		
		LoginPage login=new LoginPage(driver);
		login.username("bestbeach");
		login.Clicknext();
		login.password("Winter-house");
		login.Clicklogin();

		String actualEmailWarning = driver.findElement(By.xpath("//div[@class='toast toast-error']/child::div"))
				.getText();
		
		Assert.assertEquals(actualEmailWarning, "Incorrect Email/Username or Password");
		
	}
	

}
