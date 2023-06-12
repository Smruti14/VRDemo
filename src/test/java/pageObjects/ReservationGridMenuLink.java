package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReservationGridMenuLink extends BasePage{

	public ReservationGridMenuLink(WebDriver driver) {
		super(driver);
	}

	
	//Reservation maim link icon
	@FindBy(xpath="//a[@id='mainmenua9 ']")
	WebElement linkmainmenuReservation;
	
	// Reservation grid link
	@FindBy(xpath="//span[normalize-space()='Reservation Grid']")
	WebElement linkreservationgrid;
	
	
	
	public void ClickReservationMenu()
	{
		linkmainmenuReservation.click();
	}
	public void ClickReservationGrid()
	{
		linkreservationgrid.click();
	}
}


