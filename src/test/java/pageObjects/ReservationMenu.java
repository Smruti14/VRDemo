package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReservationMenu extends BasePage{

	public ReservationMenu(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//li[contains(@aria-label,'Reservation Menu')]")
	WebElement linkReservationMenu;
	
	@FindBy(xpath="//a[contains(@href,'/users/search')]")
	WebElement linkContactsmenu;
	
	// Add owner xpath
	@FindBy(xpath="(//a[normalize-space()='Add Owner'])")
	WebElement linkAddOwner;
	
	@FindBy(xpath="//li[@id='menu_item_84']//a[contains(@class,'menu-item')]")
	WebElement linkreservationgrid;
	
	
	//Properties link
	@FindBy(xpath="//li[@id='menu_item_100']//a")
	WebElement linkProperties;
	
	public void clickReservationMenu()
	{
		linkReservationMenu.click();
	}
	
	public void clickContactsmenu()
	{
		linkContactsmenu.click();
	}
	// Add owner click
	public void clickAddOwner()
	{
		linkAddOwner.click();
	}
	// Reservationgrid click
		public void clickreservationgrid()
		{
			linkreservationgrid.click();
		}
		
	// Properties click
		public void clickproperties()
		{
			linkProperties.click();
		}
}
