package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CustomeDispatchPage extends BasePage{

	public CustomeDispatchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//select[@name='unit_id']")
	WebElement selectUnit;
	
	@FindBy(xpath="//select[@name='hkuser']")
	WebElement selecthousekeeperUnit;
	
	
	
	@FindBy(xpath="//select[@name='types']")
	WebElement selectcleaningType;
	
	@FindBy(xpath="//textarea[@name='hknote']")
	WebElement txtNote;
	
	
	
	public void clickUnit(String View)
	{
		selectUnit.click();
		Select unit=new Select(selectUnit);
		unit.selectByVisibleText(View);
	}
	public void clickHouseKeeper(String housekeeperView)
	{
		selecthousekeeperUnit.click();
		Select houseKeeper=new Select(selecthousekeeperUnit);
		houseKeeper.selectByVisibleText(housekeeperView);
	}
	

}
