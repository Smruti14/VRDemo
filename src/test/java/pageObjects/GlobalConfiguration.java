package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GlobalConfiguration extends BasePage{

	public GlobalConfiguration(WebDriver driver) {
		super(driver);
	}
	//For User menu
	@FindBy(xpath="//a[@href='#collapsemenu']")
	WebElement linkkglobalconf;
	
	@FindBy(xpath="//a[contains(@href,'#collapsemenu36')]")
	WebElement linkgeneral;
	
	@FindBy(xpath="//a[contains(@href,'/users/index2')]")
	WebElement linkuser;
	@FindBy(xpath="//a[@class='btn btn-primary newbtn']")
	WebElement linknew;
	
	public void clickglobalconf()
	{
		linkkglobalconf.click();
	}
	public void clickgeneral()
	{
		linkgeneral.click();
	}
	public void clickuser()
	{
		linkuser.click();
	}
	public void clicknew()
	{
		linknew.click();
	}
	
} 
