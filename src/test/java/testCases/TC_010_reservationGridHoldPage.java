package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ReservationMenu;
import testBase.BaseClasslogin;

public class TC_010_reservationGridHoldPage extends BaseClasslogin {

	@Test(priority=1)
	public void validateTheHoldOption() throws InterruptedException {
		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();

		// Actions act = new Actions(driver);
		int singleDayWidth = 24;
		int nights = 3;
		String Unitname = "SMR001";
		String Holdtype = "Owner";

		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));
		WebElement unit = driver.findElement(By
				.xpath("//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_code,'"
						+ Unitname + "')]"));// 240,
		// 277
		WebElement hold = driver.findElement(By.xpath("//a[@class='test dropdown-toggle']"));
		// Search unit
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Unitname);
		// this will find all matching nodes in calendar
		List<WebElement> allDates = driver.findElements(By.xpath(
				"//div[@class='day-header-holder']/table[@class='table']//tr[contains(@class,'daynumberheader')]//div"));// (453,
																															// 201)

		// to do MAKE DATE COUNTER DYNAMIC
		int dateCounter = 0;
		// now we will iterate all values and will capture the text. We will select when
		// date is 28

		for (WebElement ele : allDates) {

			String date = ele.getText();
			dateCounter++;
			// System.out.println(date); // once date is 28 then click and break
			if (date.equals("8")) {
				break;
			}
		}
		// System.out.println(dateCounter);
		Actions act2 = new Actions(driver);

		// System.out.println(recervationpoint.getRect().x+" - "+
		// recervationpoint.getRect().y);
		act2
				// initially mouse will be at (0,0)
				.moveByOffset(recervationpoint.getRect().x + (singleDayWidth * dateCounter) + 2,
						unit.getLocation().y + 2)
				// click and hold on current location, will be res div
				.click()

				// move by days + width
				.moveByOffset(singleDayWidth * nights, 3).contextClick().click(hold).perform();
		driver.findElement(By.xpath("//a[normalize-space()='" + Holdtype + "']")).click();
		Thread.sleep(2000);

		String validateTitle = driver.findElement(By.xpath("//b[normalize-space()='Create Hold']")).getText();
		// System.out.println(validateTitle);
		Assert.assertEquals(validateTitle, "Create Hold");

	}
	

	@Test(priority=2)
	public void validateTheCreateHoldUsingValidCredentials() throws InterruptedException {
		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();

		// Actions act = new Actions(driver);
		int singleDayWidth = 24;
		int nights = 3;
		String Unitname = "SMR001";
		String Holdtype = "Renter";

		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));
		WebElement unit = driver.findElement(By
				.xpath("//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_code,'"
						+ Unitname + "')]"));// 240,
		// 277
		WebElement hold = driver.findElement(By.xpath("//a[@class='test dropdown-toggle']"));
		// Search unit
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Unitname);
		// this will find all matching nodes in calendar
		List<WebElement> allDates = driver.findElements(By.xpath(
				"//div[@class='day-header-holder']/table[@class='table']//tr[contains(@class,'daynumberheader')]//div"));// (453,
																															// 201)

		// to do MAKE DATE COUNTER DYNAMIC
		int dateCounter = 0;
		// now we will iterate all values and will capture the text. We will select when
		// date is 28

		for (WebElement ele : allDates) {

			String date = ele.getText();
			dateCounter++;
			// System.out.println(date); // once date is 28 then click and break
			if (date.equals("8")) {
				break;
			}
		}
		// System.out.println(dateCounter);
		Actions act2 = new Actions(driver);

		// System.out.println(recervationpoint.getRect().x+" - "+
		// recervationpoint.getRect().y);
		act2
				// initially mouse will be at (0,0)
				.moveByOffset(recervationpoint.getRect().x + (singleDayWidth * dateCounter) + 2,
						unit.getLocation().y + 2)
				// click and hold on current location, will be res div
				.click()

				// move by days + width
				.moveByOffset(singleDayWidth * nights, 3).contextClick().click(hold).perform();
		driver.findElement(By.xpath("//a[normalize-space()='" + Holdtype + "']")).click();
		logger.info("** Enter Valid details **");
		// Assignment Date
		String year = "2023";
		String month = "May";
		String date = "10";
		driver.findElement(By.xpath("//input[@name='hold_until_date']")).click();

		// Select month & year

		while (true) {
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (mon.equals(month.toUpperCase()) && yr.equals(year)) {
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Future date

		}
		// select date
		List<WebElement> creatAllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement dt : creatAllDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;

			}
		}

		driver.findElement(By.xpath("//div[@class='col-md-6 mb-2']//input[@name='first_name']")).sendKeys("Smruti");
		driver.findElement(By.xpath("//div[@class='col-md-6 mb-2']//input[@name='last_name']")).sendKeys("Parekh");
		driver.findElement(By.xpath("//input[@name='phone_number']")).sendKeys("9898987845");
		driver.findElement(By.xpath("//div[@class='col-md-6 mb-2']//input[@name='email']"))
				.sendKeys("smruti@gmail.com");
		driver.findElement(By.xpath("//textarea[@name='notes']")).sendKeys("Test Notes");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btnulti btnulti-gray makehold']")).click();
		Thread.sleep(2000);
		String validateHoldID = driver.findElement(By.xpath("//div[@class='success_hold_div']//ul//a")).getText();
		System.out.println(validateHoldID);

	}
	
	@Test(priority=3)
	public void deleteHoldReservation() throws InterruptedException {
		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();

		// Actions act = new Actions(driver);
		int singleDayWidth = 24;
		int nights = 1;
		String Unitname = "SMR001";
		

		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));
		WebElement unit = driver.findElement(By
				.xpath("//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_code,'"
						+ Unitname + "')]"));// 240,
		// 277
		WebElement hold = driver.findElement(By.xpath("//a[@id='cancelhold']"));
		// Search unit
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Unitname);
		// this will find all matching nodes in calendar
		List<WebElement> allDates = driver.findElements(By.xpath(
				"//div[@class='day-header-holder']/table[@class='table']//tr[contains(@class,'daynumberheader')]//div"));// (453,
																															// 201)

		// to do MAKE DATE COUNTER DYNAMIC
		int dateCounter = 1;
		// now we will iterate all values and will capture the text. We will select when
		// date is 28

		for (WebElement ele : allDates) {

			String date = ele.getText();
			dateCounter++;
			// System.out.println(date); // once date is 28 then click and break
			if (date.equals("10")) {
				break;
			}
		}
		// System.out.println(dateCounter);
		Actions act2 = new Actions(driver);

		// System.out.println(recervationpoint.getRect().x+" - "+
		// recervationpoint.getRect().y);
		act2
				// initially mouse will be at (0,0)
				.moveByOffset(recervationpoint.getRect().x + (singleDayWidth * dateCounter) + 2,
						unit.getLocation().y + 2)
				// click and hold on current location, will be res div
				.click()

				// move by days + width
				.moveByOffset(singleDayWidth * nights, 1).contextClick().click(hold).perform();
		
}
		

}
