package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUnitPagePro extends BasePage{

	public AddUnitPagePro(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Add Unit']")
	WebElement clickAdd;
	
	@FindBy(xpath="//input[@id='unit-code']")
	WebElement txtUnitCode;
}
