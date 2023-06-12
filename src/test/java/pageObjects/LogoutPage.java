package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{

	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@id='profileDropdown']")
	WebElement profile;
	
	@FindBy(xpath="//a[normalize-space()='Log Out']")
	WebElement logout;
	
	public void clickprofile()
	{
		profile.click();
	}
	public void clicklogout()
	{
		logout.click();
	}
}
