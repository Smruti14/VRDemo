package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GlobalConfiguration;
import pageObjects.UserPage;
import testBase.BaseClasslogin;

public class TC_002_UserPage extends BaseClasslogin {

	@Test(priority=1)
	public void verifyallMandatoryfields() {
		GlobalConfiguration globalmenu = new GlobalConfiguration(driver);
		globalmenu.clickglobalconf();
		globalmenu.clickgeneral();
		globalmenu.clickuser();
		globalmenu.clicknew();

		UserPage user = new UserPage(driver);
		for (int i = 0; i < 10; i++) {
			user.drpclick();
			user.drpselectclick();

		}

		// to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		user.EnterFirstname(randomeString().toUpperCase());
		user.EnterUsername(randomeString().toUpperCase());

		user.Enteremail(randomeString() + "@gmail.com");

		user.Enterpassword("123456789");
		user.Entercpassword("123456789");
		user.ClickUser();

		String actualMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		Assert.assertEquals(actualMessage, "The user has been added successfully");

	}

	@Test(priority=2)
	public void verifyallallfields() {
		GlobalConfiguration globalmenu = new GlobalConfiguration(driver);
		globalmenu.clickglobalconf();
		globalmenu.clickgeneral();
		globalmenu.clickuser();
		globalmenu.clicknew();

		UserPage user = new UserPage(driver);
		for (int i = 0; i < 10; i++) {
			user.drpclick();
			user.drpselectclick();

		}

		// to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		user.EnterUsername(randomeString().toUpperCase());
		user.EnterFirstname(randomeString().toUpperCase());
		user.EnterLastname(randomeString().toUpperCase());
		user.Enterphone("1234567897");
		user.Enteremail(randomeString() + "@gmail.com");
		user.Enterpassword("123456789");
		user.Entercpassword("123456789");
		user.ClickUser();

		String actualMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		Assert.assertEquals(actualMessage, "The user has been added successfully");

	}

	@Test(priority=3)
	public void verifyallinvalidfields() {
		GlobalConfiguration globalmenu = new GlobalConfiguration(driver);
		globalmenu.clickglobalconf();
		globalmenu.clickgeneral();
		globalmenu.clickuser();
		globalmenu.clicknew();

		UserPage user = new UserPage(driver);
		//to perform Scroll on application using Selenium
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,350)", "");
	    
	   
		user.ClickUser();

		String actualgroupMessage = driver.findElement(By.xpath("//div[normalize-space()='Please select group']")).getText();
		Assert.assertEquals(actualgroupMessage, "Please select group");
		
		String actualUsernameMessage = driver.findElement(By.xpath("//div[contains(text(),'Please enter username')]")).getText();
		Assert.assertEquals(actualUsernameMessage, "Please enter username");
		
		
		String actualFirstnameMessage = driver.findElement(By.xpath("//div[contains(text(),'Please enter first name')]")).getText();
		Assert.assertEquals(actualFirstnameMessage, "Please enter first name"); 
		
		String actualEmailMessage = driver.findElement(By.xpath("//div[contains(text(),'Please enter email')]")).getText();
		Assert.assertEquals(actualEmailMessage, "Please enter email");		
		
		String actualPasswordMessage = driver.findElement(By.xpath("//div[contains(text(),'Please enter password')]")).getText();
		Assert.assertEquals(actualPasswordMessage, "Please enter password");	
		
		String actualCPasswordMessage = driver.findElement(By.xpath("//div[contains(text(),'Please enter password')]")).getText();
		Assert.assertEquals(actualCPasswordMessage, "Please enter password");	
	}

	@Test(priority=4)
	public void verifywitheexistusername() {
		GlobalConfiguration globalmenu = new GlobalConfiguration(driver);
		globalmenu.clickglobalconf();
		globalmenu.clickgeneral();
		globalmenu.clickuser();
		globalmenu.clicknew();

		UserPage user = new UserPage(driver);

		for (int i = 0; i < 10; i++) {
			user.drpclick();
			user.drpselectclick();

		}
		// to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		user.EnterFirstname("Smruti");
		user.EnterUsername("smrutiQA");
		user.Enteremail(randomeString() + "@gmail.com");
		user.Enterpassword("123456789");
		user.Entercpassword("123456789");
		user.ClickUser();

		String actualMessage = driver.findElement(By.xpath("//div[@class='error-message']")).getText();
		Assert.assertEquals(actualMessage, "This username already exist");

	}
	
	@Test(priority=5)
	public void verifywitheexistemailid() {
		GlobalConfiguration globalmenu = new GlobalConfiguration(driver);
		globalmenu.clickglobalconf();
		globalmenu.clickgeneral();
		globalmenu.clickuser();
		globalmenu.clicknew();

		UserPage user = new UserPage(driver);

		for (int i = 0; i < 10; i++) {
			user.drpclick();
			user.drpselectclick();

		}
		// to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		user.EnterUsername(randomeString().toUpperCase());
		user.EnterFirstname(randomeString().toUpperCase());
		user.EnterLastname(randomeString().toUpperCase());
		user.Enterphone("1234567897");
		user.Enteremail("munavvard222@gmail.com");
		user.Enterpassword("123456789");
		user.Entercpassword("123456789");
		user.ClickUser();

		String actualMessage = driver.findElement(By.xpath("//div[@class='error-message']")).getText();
		Assert.assertEquals(actualMessage, "This email already exist. Please Check in Users if Not Found In Owners.");

	}

}
