package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='users-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//div[@class='mb-3 text-center']//a")
	WebElement clicknextbtn;
	
	@FindBy(xpath="//input[@id='users-password']")
	WebElement txtpwd;
	
	@FindBy(xpath="//select[@name='userlayout']")
	WebElement list_view;
	
	@FindBy(id="loginSubmitBtn")
	WebElement btn_login;
	
	public void username(String email)
	{
		try {
			txtemail.sendKeys(email);
		}catch(Exception e) {
			
		}
	}
	public void Clicknext()
	{
		clicknextbtn.click();
	}
	public void password(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	
	public void view(String type)
	{
		list_view.click();
		Select view1=new Select(list_view);
	
		view1.selectByVisibleText(type);
	}
	
	public void Clicklogin()
	{
		btn_login.click();
	}
}
