package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class dispatchMenu extends BasePage{

	public dispatchMenu(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[@id='mainmenua7 ']")
	WebElement clickHouskeepingMenu;
	
	@FindBy(xpath="//span[normalize-space()='Dispatch']/parent::a")
	WebElement clickDispatch;
	
	@FindBy(xpath="//span[normalize-space()='Ready']/parent::a")
	WebElement clickReady;
	
	@FindBy(xpath="//span[normalize-space()='Arrivals']/parent::a")
	WebElement clickArrivals;
	
	@FindBy(xpath="//span[normalize-space()='Notifications']/parent::a")
	WebElement clickNotifications;
	
	@FindBy(xpath="//span[normalize-space()='Invoice']/parent::a")
	WebElement clickInvoice;
	
	@FindBy(xpath="//a[@class='btn btn-default btn-secondary']")
	WebElement ClickAD;
	
	public void houseKeepingMenu()
	{
		clickHouskeepingMenu.click();
	}
	public void dispatch()
	{
		clickDispatch.click();
	}
	public void ready()
	{
		clickReady.click();
	}
	public void arrivals()
	{
		clickArrivals.click();
	}
	public void notifications()
	{
		clickNotifications.click();
	}
	public void invoice()
	{
		clickInvoice.click();
	}
	public void ADButton()
	{
		ClickAD.click();
	}
}	
