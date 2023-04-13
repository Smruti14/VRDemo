package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactsPage;
import pageObjects.ReservationMenu;
import testBase.BaseClasslogin;

public class TC_003_ContactsPage extends BaseClasslogin {
	
	@Test(priority=1)
	public void verifywithallvaliddata()
	{
		ReservationMenu reservation=new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickContactsmenu();
		reservation.clickAddOwner(); 
		
		ContactsPage contacts=new ContactsPage(driver);
		
		contacts.Firstname("Smruti");
		contacts.Lastname("Parekh");
		contacts.Email("parekhsmruti@gmail.com");
		contacts.ClickAddowner();
		String actualMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		Assert.assertEquals(actualMessage, "The user has been added successfully");
		
	}
	
	@Test(priority=2)
	public void verifywithmandatoryfields()
	{
		ReservationMenu reservation=new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickContactsmenu();
		reservation.clickAddOwner(); 
		
		ContactsPage contacts=new ContactsPage(driver);
		
		contacts.Firstname("Smruti");
		contacts.Email("smrutitest@gmail.com");
		contacts.ClickAddowner();
		String actualMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		Assert.assertEquals(actualMessage, "The user has been added successfully");
		
	}
	
	@Test(priority=3)
	public void verifywithinvalidemailid()
	{
		ReservationMenu reservation=new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickContactsmenu();
		reservation.clickAddOwner(); 
		
		ContactsPage contacts=new ContactsPage(driver);
		
		contacts.Firstname("Smruti");
		contacts.Email("smruti");
		contacts.ClickAddowner();
		String actualMessage = driver.findElement(By.xpath("//div[@class='error-message']")).getText();
		Assert.assertEquals(actualMessage, "Please enter valid email");
		
	}
	
	@Test(priority=4)
	public void verifywithexistemailid()
	{
		ReservationMenu reservation=new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickContactsmenu();
		reservation.clickAddOwner(); 
		
		ContactsPage contacts=new ContactsPage(driver);
		
		contacts.Firstname("Smruti");
		contacts.Email("smrutiparekhsmruti31@gmail.com");
		contacts.ClickAddowner();
		String actualMessage = driver.findElement(By.xpath("//div[@class='error-message']")).getText();
		Assert.assertEquals(actualMessage, "This email already exist. Please Check in Users if Not Found In Owners.");
		
	}
	
	@Test(priority=5)
	public void verifywithoutenterdata()
	{
		ReservationMenu reservation=new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickContactsmenu();
		reservation.clickAddOwner(); 
		
		ContactsPage contacts=new ContactsPage(driver);
		
		contacts.Firstname("");
		contacts.Email("");
		contacts.ClickAddowner();
		String actualfirstMessage = driver.findElement(By.xpath("//div[contains(text(),'Please enter first name')]")).getText();
		Assert.assertEquals(actualfirstMessage, "Please enter first name");
		
		String actualemailMessage = driver.findElement(By.xpath("//div[contains(text(),'Please enter email')]")).getText();
		Assert.assertEquals(actualemailMessage, "Please enter email");
		
	}

}
