package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GuestPage extends BasePage {

	public GuestPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//input[@id='first-name']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='last-name']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@name='phone_number[]']")
	WebElement txtphone;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement txtAdd1;
	
	@FindBy(xpath="//input[@id='address2']")
	WebElement txtAdd2;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement txtcity;
	
	@FindBy(xpath="//span[@id='select2-country-container']")
	WebElement selectcountry;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement txtentercountry;
	
	@FindBy(xpath="//span[@class='select2-dropdown select2-dropdown--below']")
	WebElement drpcountry;
	
	@FindBy(xpath="//input[@id='state']")
	WebElement txtstate;
	
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement txtpostal;
	
	@FindBy(xpath="//input[@id='cardNumber']")
	WebElement txtcardNumber;
	
	@FindBy(xpath="//input[@id='cvv']")
	WebElement txtcvv;
	
	@FindBy(xpath="//div[contains(@class,'col-6')]//span[@data-select2-id='52']")
	WebElement selectExpirationDate;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement txtExpirationDate;
	
	@FindBy(xpath="//ul[@id='select2-exp_month-hi-results']//li")
	WebElement drpExpirationDate;
	
	@FindBy(xpath="//div[contains(@class,'col-6')]//span[@data-select2-id='55']")
	WebElement selectyear;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement txtyear;
	
	@FindBy(xpath="//ul[@id='select2-exp_year-ah-results']//li")
	WebElement drpyear;
	
	@FindBy(xpath="//a[@class='btn btn-primary col saveguest']")
	WebElement btnSaveGuest;
	
	@FindBy(xpath="//a[@class='btn btn-secondary col newguest']")
	WebElement btnCloseGuest;
	
	@FindBy(xpath="//textarea[@id='reservationnotes']")
	WebElement txtReservationNotes;
	
	@FindBy(xpath="//button[@class='btn btn-primary continue']")
	WebElement btnReserve;
	
	@FindBy(xpath="//button[@class='btn btn-secondary uk-modal-close closemodel']")
	WebElement btnCancel;
	
	
	public void firstName(String firstname)
	{
		txtfirstname.sendKeys(firstname);
	}
	
	public void lastName(String lastname)
	{
		txtlastname.sendKeys(lastname);
	}
	
	public void email(String email)
	{
	
		txtemail.sendKeys(email);
	}
	public void phone(String num)
	{
		
		txtphone.sendKeys(num);
	}
	
	public void add1(String Add)
	{
		txtAdd1.sendKeys(Add);
	}
	
	public void add2(String Add2)
	{
		txtAdd2.sendKeys(Add2);
	}
	
	public void city(String city)
	{
		txtcity.sendKeys(city);
	}
	public void Country()
	{
		selectcountry.click();
		txtentercountry.sendKeys("United States");
		
		Actions action= new Actions(driver);
		do {
		    action.sendKeys(Keys.ARROW_DOWN).perform();
		} while (!txtentercountry.isDisplayed());
		txtentercountry.click();
	}
	public void state (String state)
	{
		txtstate.sendKeys(state);
	}
	
	public void postal(String postal)
	{
		txtpostal.sendKeys(postal);
	}
	public void cardno(String cardnum)
	{
		txtcardNumber.sendKeys(cardnum);
	}
	public void CVV(String cvv) throws InterruptedException
	{
		txtcvv.sendKeys(cvv);
		Thread.sleep(1000);
	}
	
	public void ExpirationDate() throws InterruptedException
	{
		selectExpirationDate.click();
        txtentercountry.sendKeys("02");
		
		Actions action= new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	public void year(String Year)
	{
		selectyear.click();
		txtyear.sendKeys(Year);
		
		Actions action= new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();

	}
	public void save()
	{
		btnSaveGuest.click();
	}
}


