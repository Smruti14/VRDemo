package testCases_ReservationDispatchFollow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.dispatchMenu;
import testBase.BaseClasslogin;

public class TC_014_reservationReadyTestCase extends BaseClasslogin {
	@Test
	public void validateArrivalswithvaliddata() throws InterruptedException {

		dispatchMenu housekeepingMenu = new dispatchMenu(driver);

		housekeepingMenu.houseKeepingMenu();
		housekeepingMenu.ready();

		// Assignment Date
		String year = "2023";
		String month = "May";
		String date = "18";
		driver.findElement(By.xpath("//a[@class='datechangerbacha btn btn-sm btn-custom ']")).click();

		// Select month & year

		while (true) {
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (mon.equals(month.toUpperCase()) && yr.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//a[@title='Next']")).click(); // Next date
			driver.findElement(By.xpath("//a[@title='Prev']")).click(); // Prev date

		}
		// select date
		List<WebElement> creatAllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement dt : creatAllDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		} //

		List<WebElement> allUnitCode = driver.findElements(By.xpath("//table[@id='readyunits']//td[1]"));
//			 boolean markChecked = driver.findElement(By.xpath("//table[@id='arrivalunits']//i[contains(@class,'fas fa-times eventmodalhandler')]")).isDisplayed();
//			 boolean unChecked = driver.findElement(By.xpath("//table//i[@style='color:#05a34a;']")).isDisplayed();

		int unitCodeCounter = 0;

		String unitcodename = "DWH502";
		for (WebElement ele : allUnitCode) {

			int total = allUnitCode.size();
			unitCodeCounter++;
			// System.out.println(unitCode);
			if (ele.getText().equals(unitcodename)) {
				WebElement clickInsunit = driver.findElement(By.xpath(
						"//td[normalize-space()='DWH502']/ancestor::tr//i[@class='fas fa-paper-plane fa-stack-1x fa-inverse']"));

				clickInsunit.click();
				break;
			}
		}

		
		// Renter

		// change number
		driver.findElement(By.xpath("//i[@class='fas fa-edit']/ancestor::a[contains(@class,'editphonenumber')]"))
				.click();
		WebElement  phone=	driver.findElement(By.xpath("//input[@name='phonenumber']"));
		phone.clear();
		phone.sendKeys("7043733107");

		// Email

		driver.findElement(By.xpath("//i[@class='fas fa-edit']/ancestor::a[contains(@class,'editemail')]")).click();
		WebElement  email=	driver.findElement(By.xpath("//input[@name='emailaddr']"));
		email.clear();
		email.sendKeys("parekhsmruti31@gmail.com");
		//send click
		driver.findElement(By.xpath("//input[@value='Send']")).click();
	}

}
