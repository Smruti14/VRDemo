package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id="users-email")
	WebElement txtusername;
	
	@FindBy(xpath="//a[normalize-space()='Next']")
	WebElement btnclick;
	
	@FindBy(id="users-password")
	WebElement txtpassword;
	
	@FindBy(xpath="//select[@name='userlayout']")
	WebElement selectView;
	
	@FindBy(id="loginSubmitBtn")
	WebElement btnlogin;
	
	
	public void enterUsername(String username)
	{
		txtusername.sendKeys(username);
	}
	
	public void clickNext()
	{
		btnclick.click();
	}
	public void enterPassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	public void selectview(String view)
	{
		selectView.click();
		Select view1=new Select(selectView);
	
		view1.selectByVisibleText(view);
	}
	public void clickLogin()
	{
		btnlogin.click();
	}
}
