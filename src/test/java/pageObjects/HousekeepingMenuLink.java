package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HousekeepingMenuLink extends BasePage{

	public HousekeepingMenuLink(WebDriver driver) {
		super(driver);
	}
	
	
	//link of Dispatch 
	@FindBy(xpath="//a[@class='menu-item thisactive']")
	WebElement linkDispatch;
	
	
	public void ClickDispatch() 
	{
		linkDispatch.click();
	}
	
	// Link for add new dispatch page 
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement linknew;
	
	public void clickNew()
	{
		linknew.click();
	}
}
