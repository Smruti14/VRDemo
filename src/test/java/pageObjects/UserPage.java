package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {

	public UserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='users_user_group_id_chosen']")
	WebElement Clicksearchtxt;

	@FindBy(xpath = "//div[@class='chosen-drop']//li[contains(@class,'active-result')]")
	WebElement SelectActivelist;

	@FindBy(xpath = "//input[@id='users-first-name']")
	WebElement TxtfirstName;
	
	@FindBy(xpath = "//input[@id='users-username']")
	WebElement Txtusername;

	@FindBy(xpath = "//input[@id='users-last-name']")
	WebElement Txtlastname;

	@FindBy(xpath = "//input[@id='users-user-detail-cellphone']")
	WebElement TxtPhonenumber;
	
	@FindBy(xpath = "//input[@id='users-email']")
	WebElement Txtemail;
	
	@FindBy(xpath = "//input[@id='users-password']")
	WebElement Txtpassword;

	@FindBy(xpath = "//input[@id='users-cpassword']")
	WebElement TxtConfirmpassword;

	@FindBy(xpath = "//input[@id='addUserSubmitBtn']")
	WebElement linkddUser;

	@FindBy(xpath = "//a[@class='btn btn-secondary']")
	WebElement linkcancel;

	public void drpclick() {
		Clicksearchtxt.click();
	}

	public void drpselectclick() {
		SelectActivelist.click();
	}

	public void EnterFirstname(String Firstname)
	{
		TxtfirstName.sendKeys(Firstname);
	}
	public void EnterUsername(String Username)
	{
		Txtusername.sendKeys(Username);
	}
	
	public void EnterLastname(String lastname)
	{
		Txtlastname.sendKeys(lastname);
	}
	public void Enterphone(String phone)
	{
		TxtPhonenumber.sendKeys(phone);
	}
	public void Enteremail(String email)
	{
		Txtemail.sendKeys(email);
	}
	public void Enterpassword(String pwd)
	{
		Txtpassword.sendKeys(pwd);
	}
	public void Entercpassword(String cpwd)
	{
		TxtConfirmpassword.sendKeys(cpwd);
	}
	public void ClickUser() 
	{
		
		linkddUser.click();
	}
}
