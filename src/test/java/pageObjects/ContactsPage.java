package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@id='users-first-name']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='users-last-name']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='users-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='addUserSubmitBtn']")
	WebElement btnAddowner;
	
	
	public void Firstname(String firstname)
	{
		txtfirstname.sendKeys(firstname);
	}
	
	public void Lastname(String lastname)
	{
		txtlastname.sendKeys(lastname);
	}
	public void Email(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void ClickAddowner()
	{
		btnAddowner.click();
	}
	
}
