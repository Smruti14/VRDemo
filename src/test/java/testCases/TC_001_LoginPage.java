package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import testBase.BaseClass;
public class TC_001_LoginPage extends BaseClass {
	@Test(priority=1)
	public void validateLoggingIntoTheApplicationUsingValidCredentials()
	{
		logger.info("** Starting TC_001_LoginPage **");
		LoginPage login=new LoginPage(driver);
		logger.info("** LoginWithValidCredentials **");
		login.enterUsername("bestbeach");
		login.clickNext();
		login.enterPassword("Winter-house2021");
		login.selectview("Select view or Default");
		login.clickLogin();
		logger.info("** Check Dispatch Page Open or Not**");
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//h4[@class='mb-3 mb-md-0']")).isDisplayed());
		logger.info("Test Case : Validate logging into the Application using valid credentials --PASS-- ");
	
		LogoutPage logout=new LogoutPage(driver);
		logger.info("** Click on profile icon**");
		logout.clickprofile();
		logger.info("** Click on logout button**");
		logout.clicklogout();
		logger.info("Test Case 1 : Validate logging into the Application using valid credentials --PASS-- ");
	}
	
	@Test(priority=2)
	public void ValidateLoggingIntoTheApplicationUsingInvalidCredentials()
	{
		logger.info("** Starting TC_001_LoginPage **");
		LoginPage login=new LoginPage(driver);
		logger.info("** LoginWithInvalidCredentials **");
		logger.info("** Enter Invalid Username **");
		login.enterUsername("bestbeach123");
		login.clickNext();
		logger.info("** Enter Invalid Password **");
		login.enterPassword("Winter-house2000");
		login.selectview("Select view or Default");
		login.clickLogin();
		String actualEmailWarning = driver.findElement(By.xpath("//div[@class='toast toast-error']/child::div")).getText();
		AssertJUnit.assertEquals(actualEmailWarning, "Incorrect Email/Username or Password");
		logger.info("Test Case 2 : Validate logging into the Application using invalid credentials (i.e. Invalid email address and Invalid Password) --PASS-- ");
		
	}
	@Test(priority=3)
	public void ValidateLoggingIntoTheApplicationUsingInvalidEmailAddressValidPassword()
	{
		logger.info("** Starting TC_001_LoginPage **");
		LoginPage login=new LoginPage(driver);
		logger.info("** LoginWithInvalidCredentials **");
		logger.info("** Enter Invalid Username **");
		login.enterUsername("bestbeach123");
		login.clickNext();
		logger.info("** Enter valid Password **");
		login.enterPassword("Winter-house2021");
		login.selectview("Select view or Default");
		login.clickLogin();
		String actualEmailWarning = driver.findElement(By.xpath("//div[@class='toast toast-error']/child::div")).getText();
		AssertJUnit.assertEquals(actualEmailWarning, "Incorrect Email/Username or Password");
		logger.info("Test Case 3 : Validate logging into the Application using invalid email address and valid Password --PASS-- ");
	}
	@Test(priority=4)
	public void ValidateLoggingIntoTheApplicationUsingvalidEmailAddressInvalidPassword()
	{
		logger.info("** Starting TC_001_LoginPage **");
		LoginPage login=new LoginPage(driver);
		logger.info("** LoginWithInvalidCredentials **");
		logger.info("** Enter valid Username **");
		login.enterUsername("bestbeach");
		login.clickNext();
		logger.info("** Enter Invalid Password **");
		login.enterPassword("Winter-house2023");
		login.selectview("Select view or Default");
		login.clickLogin();
		String actualEmailWarning = driver.findElement(By.xpath("//div[@class='toast toast-error']/child::div")).getText();
		AssertJUnit.assertEquals(actualEmailWarning, "Incorrect Email/Username or Password");
		logger.info("Test Case 4 : Validate logging into the Application using valid email address and invalid Password) --PASS-- ");
	}
	@Test(priority=5)
	public void ValidateLoggingIntoTheApplicationWithoutProvidingAnyCredentials() throws InterruptedException
	{
		logger.info("** Starting TC_001_LoginPage **");
		LoginPage login=new LoginPage(driver);
		logger.info("** LoginWithInvalidCredentials **");
		logger.info("** Dont enter email address into the 'E-Mail Address' field  **");
		login.enterUsername("");
		login.clickNext();
		logger.info("** Dont enter password into the 'Password' field    **");
		login.enterPassword("");
		login.selectview("Select view or Default");
		login.clickLogin();
		
		login.clickNext();
		Thread.sleep(4000);
		String actualEmailWarning = driver.findElement(By.xpath("//div[contains(text(),'Please enter email or username')]")).getText();
		AssertJUnit.assertEquals(actualEmailWarning, "Please enter email or username");
		String actualPasswordWarning = driver.findElement(By.xpath("//div[contains(text(),'Please enter password')]")).getText();
		AssertJUnit.assertEquals(actualPasswordWarning, "Please enter password");
	
		logger.info("Test Case 5 : Validate logging into the Application without providing any credentials --PASS-- ");
	}
	@Test(priority=3)
	public void ValidateLoggingIntoTheApplicationWithSelectDropdown()
	{
		
		logger.info("** Starting TC_001_LoginPage **");
		LoginPage login=new LoginPage(driver);
		logger.info("** Login With With Select view Dropdown **");
		login.enterUsername("bestbeach");
		login.clickNext();
		login.enterPassword("Winter-house2021");
		
		String select="Dispatch";
		
		switch(select)
		{
		case "Select view or Default":
			login.selectview("Select view or Default");
			login.clickLogin();	
			String dispatchpage = driver.findElement(By.xpath("//h4[normalize-space()='Dispatch']")).getText();
			AssertJUnit.assertEquals(dispatchpage,"Dispatch");
			break;
			
		case "Dispatch":
			login.selectview("Dispatch");
			login.clickLogin();	
			String dispatchpage1msg = driver.findElement(By.xpath("//h4[normalize-space()='Dispatch']")).getText();
			AssertJUnit.assertEquals(dispatchpage1msg,"Dispatch");
			break;
			
		case "Field Manager":
			login.selectview("Field Manager");
			login.clickLogin();	
			String FieldManagermsg = driver.findElement(By.xpath("//a[@id='home-tab']")).getText();
			AssertJUnit.assertEquals(FieldManagermsg,"Dashboard");
			break;
			
		case "Cleaning":
			login.selectview("Cleaning");
			login.clickLogin();	
			String Cleaningmsg = driver.findElement(By.xpath("//h4[normalize-space()='Housekeeping Units']")).getText();
			AssertJUnit.assertEquals(Cleaningmsg,"Housekeeping Units");
			break;
			
		case "Service":
			login.selectview("Service");
			login.clickLogin();	
			String Servicemsg = driver.findElement(By.xpath("//h4[normalize-space()='Open Tasks']")).getText();
			AssertJUnit.assertEquals(Servicemsg,"Open Tasks");
			break;
			
		default:
			System.out.println("Please select valid option..." + select);
			break;
		}
	
		logger.info("Test Case 5 : Validate Logging Into The Application With Select Dropdown --PASS-- ");
	}

}
